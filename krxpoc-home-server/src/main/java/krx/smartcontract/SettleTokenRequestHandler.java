package krx.smartcontract;

import krx.model.OrderType;
import krx.model.packet.MessageForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SettleTokenRequestHandler implements Handler {

  /**
   * Handle data for settle token request.
   *
   * @param messageForm
   *          MessageForm
   */
  public void handle(MessageForm messageForm) {
    log.info(this.getClass().getName());
    log.info("Status 4 : SettleTokenRequest");

    final int orderType = messageForm.getSmartContractForm().getOrderType();

    // 매수자 자산 입금
    if (OrderType.BUY.getValue() == orderType) {
      log.info("매수자 자산 입금");
    } else { // 매도자 자산 잠금 해제
      log.info("매도자 자산 잠금 해제");
    }
  }
}
