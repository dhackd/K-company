package krx.smartcontract;

import krx.model.OrderType;
import krx.model.packet.MessageForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LockRequestHandler implements Handler {

  /**
   * Handle data for lock request.
   *
   * @param messageForm
   *          MessageForm
   */
  public void handle(MessageForm messageForm) {
    log.info("Status 0. LockRequest");

    final int orderType = messageForm.getSmartContractForm().getOrderType();

    if (OrderType.SELL.getValue() == orderType) {
      // 매도 주문
      log.info("주문 고객 자산 락 요청.");
    } else {
      // 매수 주문
      log.info("주문 고객계좌 락 요청.");
    }
  }

}
