package krx.smartcontract;

import krx.model.OrderType;
import krx.model.packet.MessageForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SettleAccountRequestHandler implements Handler {

  /**
   * Handle data for settle account request.
   *
   * @param messageForm
   *          MessageForm
   */
  public void handle(MessageForm messageForm) {
    log.info(this.getClass().getName());
    log.info("Status 2. SettleAccountRequest");

    final int orderType = messageForm.getSmartContractForm().getOrderType();

    if (OrderType.SELL.getValue() == orderType) {
      // 매도 주문
      log.info("입금 요청 확인");
    } else {
      // 매수 주문
      log.info("출금 요청 확인");
    }
  }
}
