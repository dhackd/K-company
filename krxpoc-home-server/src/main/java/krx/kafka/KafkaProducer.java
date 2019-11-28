package krx.kafka;

import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;

@Slf4j
@Component
public class KafkaProducer {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;
  private String sendResultMsg = null;

  /**
   * Can be transferred to a topic as a partition.
   *
   * @Method 설명:토픽내 파티션별로 전송가능
   ∆* @param topic
   *          krx-bank01 / krx-global / krx-ksd에 한함.
   * @param partitions
   *          0,1 ... {n}
   * @param key
   *          null
   * @param value
   *          jsonString
   * @return Async방식이며 실패건에 대해서만 에러 핸들링하도록 설정
   * @throws InterruptedException
   *           {@link InterruptedException}
   * @throws ExecutionException
   *           {@link ExecutionException}
   */
  public String send(String topic, Integer partitions, String key, String value)
      throws InterruptedException, ExecutionException {
    log.info("===================================================");
    log.info("KRX Producer send key = " + key);
    log.info("KRX Producer send data = " + value);
    log.info("===================================================");
    ListenableFuture<SendResult<String, String>> future =
        kafkaTemplate.send(topic, partitions, key, value);
    future.addCallback(new SuccessCallback<Object>() {

      @Override
      public void onSuccess(Object result) {
        log.info("===================================================");
        log.info("KRX Producer send success");
        log.info("===================================================");

        sendResultMsg = "success";

      }
    }, new ListenableFutureCallback<SendResult<Integer, String>>() {

      @Override
      public void onSuccess(SendResult<Integer, String> result) {
        log.info("On Success : {}", result);

      }

      @Override
      public void onFailure(Throwable ex) {
        sendResultMsg = "failed";
        ex.printStackTrace();
      }
    });
    return sendResultMsg;
  }

}