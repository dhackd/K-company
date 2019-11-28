// package krx;
//
// import static krx.util.Utils.sha256hex;
// import static org.assertj.core.api.Assertions.assertThat;
//
// import com.fasterxml.jackson.databind.ObjectMapper;
// import io.blocko.json.JSONObject;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.UUID;
// import java.util.concurrent.ConcurrentHashMap;
// import java.util.concurrent.ExecutionException;
// import java.util.concurrent.LinkedBlockingQueue;
// import java.util.stream.IntStream;
// import krx.model.packet.OrderForm;
// import krx.model.packet.SmartContractForm;
// import krx.service.Worker;
// import lombok.extern.slf4j.Slf4j;
// import org.apache.kafka.clients.consumer.ConsumerConfig;
// import org.apache.kafka.clients.consumer.ConsumerRecord;
// import org.apache.kafka.clients.producer.ProducerConfig;
// import org.apache.kafka.common.serialization.StringDeserializer;
// import org.apache.kafka.common.serialization.StringSerializer;
// import org.junit.After;
// import org.junit.AfterClass;
// import org.junit.Before;
// import org.junit.Rule;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
// import org.springframework.kafka.core.DefaultKafkaProducerFactory;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.kafka.core.ProducerFactory;
// import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
// import org.springframework.kafka.listener.MessageListener;
// import org.springframework.kafka.listener.config.ContainerProperties;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.util.StopWatch;
//
/// **
// * Please annotate 'smartContractService.execute(smartContractForm)' in worker class to test.
// */
// @Slf4j
// @RunWith(SpringRunner.class)
// public class KafkaTest {
// private static int count = 1;
// private static final int MESSAGE_NUM = 100;
// private static final int REPEAT_NUM = 5;
//
// @Rule
// public RepeatRule repeatRule = new RepeatRule();
//
// private Worker worker;
//
// private KafkaTemplate<String, String> kafkaTemplate;
// private ConcurrentMessageListenerContainer<String, String> globalListener;
// private ConcurrentMessageListenerContainer<String, String> krxBank01Listener;
//
// private List<SmartContractForm> dummySmartContractForm = new ArrayList<SmartContractForm>();
// private List<String> jsonSmartContractForm = new ArrayList<String>();
//
// private List<String> sendedMessage = Collections.synchronizedList(new ArrayList<>());
// private List<String> receivedMessage = Collections.synchronizedList(new ArrayList<>());
//
// private static List<Long> timeList = new ArrayList<Long>();
//
// private ObjectMapper objectMapper = new ObjectMapper();
//
// /**
// * set up.
// */
// @Before
// public void setUp() throws Exception {
// worker = new Worker(new LinkedBlockingQueue<String>(),
// new ConcurrentHashMap<String, SmartContractForm>());
// IntStream.range(0, MESSAGE_NUM).forEach(i -> {
// SmartContractForm smartContractForm = makeDummySmartContractForm();
// dummySmartContractForm.add(smartContractForm);
// JSONObject jsonObject = new JSONObject(smartContractForm);
// jsonSmartContractForm.add(jsonObject.toString());
// });
//
// final Map<String, Object> producerProps = new HashMap<String, Object>();
// producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
// "PLAINTEXT://192.168.0.191:9092,PLAINTEXT://192.168.0.192:9092");
// producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
// producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
// ProducerFactory<String, String> producerFactory =
// new DefaultKafkaProducerFactory<String, String>(producerProps);
// kafkaTemplate = new KafkaTemplate<String, String>(producerFactory);
//
// krxBank01Listener = getListener(new MessageListener<String, String>() {
// @Override
// public void onMessage(ConsumerRecord<String, String> message) {
// try {
// final SmartContractForm smartContractForm =
// objectMapper.readValue(message.value(), SmartContractForm.class);
// worker.addSmartContractForm(sha256hex(message.value()), smartContractForm);
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
// }, "krx-bank01-consumer-group", "krx-bank01");
//
// globalListener = getListener(new MessageListener<String, String>() {
// @Override
// public void onMessage(ConsumerRecord<String, String> message) {
// receivedMessage.add(message.value());
// worker.addHash(message.value());
// }
// }, "krx-global-consumer-group", "global");
//
// worker.start();
// krxBank01Listener.start();
// globalListener.start();
// Thread.sleep(1000);
// }
//
// @Test
// @Repeat(REPEAT_NUM)
// public void testWorker() throws InterruptedException, ExecutionException {
// Thread krxBank01Thread = new Thread(() -> {
// IntStream.range(0, MESSAGE_NUM).parallel().forEach(i -> {
// kafkaTemplate.send("krx-bank01", 0, "key", jsonSmartContractForm.get(i));
// });
// });
//
// Thread globalThread = new Thread(() -> {
// IntStream.range(0, MESSAGE_NUM).forEach(i -> {
// kafkaTemplate.send("global", 0, "key", sha256hex(jsonSmartContractForm.get(i)));
// sendedMessage.add(sha256hex(jsonSmartContractForm.get(i)));
// });
// });
//
// StopWatch sw = new StopWatch();
// sw.start();
//
// krxBank01Thread.start();
// globalThread.start();
//
// while (true) {
// if (worker.get() == MESSAGE_NUM) {
// worker.interrupt();
// break;
// }
// }
// sw.stop();
// final double time = sw.getTotalTimeMillis();
// final double tps = (double) MESSAGE_NUM / (time / 1000);
// timeList.add((long) time);
// log.info("Test {} - time : {} ms, tps : {} tps", count++, time, tps);
// assertThat(sendedMessage).isEqualTo(receivedMessage);
// }
//
// /**
// * tear down.
// */
// @After
// public void tearDown() {
// globalListener.stop();
// krxBank01Listener.stop();
// worker.interrupt();
// }
//
// /**
// * tear down class.
// */
// @AfterClass
// public static void tearDownClass() {
// final double averageTime = timeList.stream().mapToLong(Long::longValue).average().getAsDouble();
// final double averageTps = (double) MESSAGE_NUM / (averageTime / 1000);
// log.info("Total Average - time : {} ms, tps : {} tps", averageTime, averageTps);
// }
//
// /**
// * get listener.
// */
// public ConcurrentMessageListenerContainer<String, String> getListener(
// final MessageListener<String, String> listener, final String groupId,
// final String... topics) {
// final Map<String, Object> consumerProps = new HashMap<String, Object>();
// consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
// "PLAINTEXT://192.168.0.191:9092,PLAINTEXT://192.168.0.192:9092");
// consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
// consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
// consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
// consumerProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
// final DefaultKafkaConsumerFactory<String, String> consumerFactory =
// new DefaultKafkaConsumerFactory<>(consumerProps);
// final ContainerProperties containerProps = new ContainerProperties(topics);
// containerProps.setMessageListener(listener);
// final ConcurrentMessageListenerContainer<String, String> container =
// new ConcurrentMessageListenerContainer<>(consumerFactory, containerProps);
// return container;
// }
//
// /**
// * make dummy smart contract form.
// */
// public SmartContractForm makeDummySmartContractForm() {
// final SmartContractForm smartContractForm = new SmartContractForm();
// final OrderForm orderForm = new OrderForm();
// String custId = "";
// for (int i = 0; i < 84; i++) {
// custId += UUID.randomUUID().toString();
// }
// orderForm.setCustId(custId);
// smartContractForm.setOrderform(orderForm);
// return smartContractForm;
// }
// }
