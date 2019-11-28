package krx.config;

import static krx.ConfigurationConstants.CONF_KAFKA_ENDPOINT;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@EnableKafka
@Configuration
public class KafkaProducerConfiguration {

  @Autowired
  protected coinstack.util.Configuration configuration;

  /**
   * .
   * 
   * @return
   */
  @Bean
  public ProducerFactory<String, String> producerFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  /**
   * .
   * 
   * @return
   */
  @Bean
  public Map<String, Object> producerConfigs() {
    Map<String, Object> props = new HashMap<>();
    // props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
    // "PLAINTEXT://192.168.0.191:9092,PLAINTEXT://192.168.0.192:9092");
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
        configuration.getAsString(CONF_KAFKA_ENDPOINT, "localhost:9092"));
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

    return props;
  }

  /**
   * .
   * 
   * @return
   */
  @Bean
  public KafkaTemplate<String, String> kafkaTemplate() {
    KafkaTemplate<String, String> template = new KafkaTemplate<>(producerFactory());
    // template.setMessageConverter(new StringJsonMessageConverter());

    return template;
  }

}
