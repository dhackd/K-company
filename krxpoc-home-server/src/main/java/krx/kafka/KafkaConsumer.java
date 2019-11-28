package krx.kafka;

import static krx.config.KafkaConsumerConfiguration.KAFKA_BANK_TOPIC;
import static krx.util.Utils.sha256hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import krx.model.packet.MessageForm;
import krx.service.KafkaService;
import krx.service.SmartContractService;
import krx.service.Worker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumer {

  private final Worker globalWorker;
  private final Worker bankWorker;
  private final Worker ksdWorker;
  private final ObjectMapper om = new ObjectMapper();

  @Autowired
  private KafkaService kafkaService;

  /**
   * Generates a no-args constructor.
   */
  @Autowired
  public KafkaConsumer(SmartContractService smartContractService) {
    globalWorker = new Worker(smartContractService);
    bankWorker = new Worker(smartContractService);
    ksdWorker = new Worker(smartContractService);
    globalWorker.start();
    bankWorker.start();
    ksdWorker.start();
  }

  /**
   * Kafka Listener. (KRX <-> Bank)
   *
   * @param value PlainText.
   * @param key GlobalId.
   * @throws Exception {@link Exception}
   */
  @KafkaListener(groupId = "krx-bank01-consumer-group", topics = KAFKA_BANK_TOPIC)
  public void krxBankConsumer(@Payload String value) throws Exception {
    System.out.println("krx-bank01 consumer entrance!!");
    System.out.println("value = "+ value);
  }
}
