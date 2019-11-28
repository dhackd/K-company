package krx.smartcontract;

import static krx.util.Utils.sha256hex;

import io.blocko.json.JSONObject;
import javassist.NotFoundException;
import krx.model.BankAccount;
import krx.model.BankOrderLock;
import krx.model.OrderType;
import krx.model.User;
import krx.model.packet.MessageForm;
import krx.model.packet.OrderForm;
import krx.model.packet.SmartContractForm;
import krx.repository.BankAccountJpaRepository;
import krx.repository.BankOrderLockJpaRepository;
import krx.repository.UserJpaRepository;
import krx.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SettleAccountResponseHandler implements Handler {

  @Autowired
  private UserJpaRepository userJpaRepository;
  @Autowired
  private BankAccountJpaRepository bankAccountJpaRepository;
  @Autowired
  private BankOrderLockJpaRepository bankOrderLockJpaRepository;
  @Autowired
  private SignService signService;

  /**
   * Handle data for settle account response.
   *
   * @param messageForm MessageForm
   */
  public void handle(MessageForm messageForm) {
    try {
      log.info("Status 3. SettleAccountResponse");
      final SmartContractForm smartContractForm = messageForm.getSmartContractForm();
      final OrderForm orderForm = smartContractForm.getOrderform();
      final JSONObject json = new JSONObject(orderForm);
      final User user = userJpaRepository.findById(orderForm.getCustId())
          .orElseThrow(() -> new NotFoundException("해당 유저 없음 : " + orderForm.getCustId()));

      if (signService.verifySignature(user.getAddr(), sha256hex(json.toString()),
          smartContractForm.getSignature())) {
        final String result = settleToAccountExecution(orderForm, smartContractForm.getOrderType());
        log.info("settleToAccountExecution complete : {}", result);
      } else {
        throw new NotFoundException("일치하는 사인을 찾을 수 없습니다.");
      }

    } catch (NotFoundException e) {
      e.printStackTrace();
    }
  }

  private String settleToAccountExecution(OrderForm orderForm, int orderType)
      throws NotFoundException {
    if (OrderType.BUY.getValue() == orderType) {
      settleToBuy(orderForm);
    } else if (OrderType.SELL.getValue() == orderType) {
      settleToSell(orderForm);
    } else {
      log.info("not exists orderType");
      return "failed";
    }
    return "success";
  }

  private void settleToBuy(OrderForm buyOrderForm) throws NotFoundException {
    final BankOrderLock bankOrderLock =
        bankOrderLockJpaRepository.findById(buyOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getOrderNum()));
    final BankAccount targetBankAccount =
        bankAccountJpaRepository.findById(buyOrderForm.getTargetId())
            .orElseThrow(() -> new NotFoundException("계좌 정보 없음 : " + buyOrderForm.getTargetId()));

    log.info("계좌 락 해제 : {}", bankOrderLock);
    bankOrderLockJpaRepository.delete(bankOrderLock);

    final int balance = buyOrderForm.getQuantity() * buyOrderForm.getOrderPrice();
    targetBankAccount.setBalance(targetBankAccount.getBalance() + balance);
    log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getCustId(), buyOrderForm.getTargetId(), balance);
    bankAccountJpaRepository.save(targetBankAccount);
  }

  private void settleToSell(OrderForm sellOrderForm) throws NotFoundException {
    final BankOrderLock targetBankOrderLock =
        bankOrderLockJpaRepository.findById(sellOrderForm.getTargetOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));
    final BankAccount bankAccount = bankAccountJpaRepository.findById(sellOrderForm.getCustId())
        .orElseThrow(() -> new NotFoundException("계좌 정보 없음 : " + sellOrderForm.getCustId()));

    log.info("계좌 락 해제 : {}", targetBankOrderLock);
    bankOrderLockJpaRepository.delete(targetBankOrderLock);

    final int balance = sellOrderForm.getQuantity() * sellOrderForm.getOrderPrice();
    bankAccount.setBalance(bankAccount.getBalance() + balance);
    log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getTargetId(), sellOrderForm.getCustId(),
        balance);
    bankAccountJpaRepository.save(bankAccount);
  }
}
