package krx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import krx.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaService {

  private final ObjectMapper om = new ObjectMapper();

  @Autowired
  private UserService userService;

  @Autowired
  private RestService postService;

  @Autowired
  private coinstack.util.Configuration configuration;

  @Autowired
  private KafkaProducer kafkaProducer;

  @Autowired
  private SignService signService;

  /**
   * Handle Message.
   *
   * @param value PlainText.
   * @param key GlobalId.
   */
  public boolean handleMessage(String topic,String value) throws Exception {
    log.info("KEY : {} VALUE : {}", value);

    return true;
  }
}
