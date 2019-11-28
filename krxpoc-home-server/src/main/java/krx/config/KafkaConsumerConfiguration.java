package krx.config;

import static krx.ConfigurationConstants.CONF_KAFKA_ENDPOINT;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@EnableKafka
@Configuration
public class KafkaConsumerConfiguration {

  public static final String KAFKA_GLOBAL_TOPIC = "global";
  public static final String KAFKA_BANK_TOPIC = "krx-bank01";

  @Autowired
  protected coinstack.util.Configuration configuration;

  /**
   * .
   * 
   * @return
   */
  @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> config = new HashMap<>();
    // config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
    // "PLAINTEXT://192.168.0.191:9092,PLAINTEXT://192.168.0.192:9092");
    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
        configuration.getAsString(CONF_KAFKA_ENDPOINT, "localhost:9092"));
    config.put(ConsumerConfig.GROUP_ID_CONFIG, "");
    config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    return config;
  }

  /**
   * .
   * 
   * @return
   */
  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs());/* , new StringDeserializer(), */
    // );
    // new JsonDeserializer<>(User.class));
  }

  /**
   * .
   * 
   * @return
   *
   */
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    // factory.setMessageConverter(new StringJsonMessageConverter());
    return factory;
  }

}
