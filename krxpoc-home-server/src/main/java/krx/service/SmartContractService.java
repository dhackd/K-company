package krx.service;

import krx.model.OrderStatus;
import krx.model.OrderType;
import krx.model.packet.MessageForm;
import krx.smartcontract.LockRequestHandler;
import krx.smartcontract.LockResponseHandler;
import krx.smartcontract.SettleAccountRequestHandler;
import krx.smartcontract.SettleAccountResponseHandler;
import krx.smartcontract.SettleTokenRequestHandler;
import krx.smartcontract.SettleTokenResponseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmartContractService {

  @Autowired
  private LockRequestHandler lockRequestHandler;
  @Autowired
  private LockResponseHandler lockResponseHandler;
  @Autowired
  private SettleAccountRequestHandler settleAccountRequestHandler;
  @Autowired
  private SettleAccountResponseHandler settleAccountResponseHandler;
  @Autowired
  private SettleTokenRequestHandler settleTokenRequestHandler;
  @Autowired
  private SettleTokenResponseHandler settleTokenResponseHandler;
  @Autowired
  private UserService userService;

  /**
   * execute smart contract - synchronize with state DB.
   *
   * @param messageForm
   *          MessageForm
   */
  public void execute(MessageForm messageForm) {
    log.debug("[sc] execute method call");
    final int orderStatus = messageForm.getSmartContractForm().getOrderStatus();
    final int orderType = messageForm.getSmartContractForm().getOrderType();

    if (OrderType.NEW.getValue() == orderType) {
      final String newAccountUserId =
          messageForm.getSmartContractForm().getMemberForm().getCustId();
      final int initBalance = 50000;
      log.debug("[sc] bankTransaction method entry");
      bankTransaction(newAccountUserId, initBalance);
      log.debug("[sc] bankTransaction method exit");
    } else {
      log.debug("[sc] orderTransaction method entry");
      orderTransaction(messageForm, orderStatus, orderType);
      log.debug("[sc] orderTransation method exit");
    }
  }

  /**
   * execute smart contract - order transaction.
   * 
   * @param messageForm
   *          messageForm
   * @param orderStatus
   *          orderStatus
   * @param orderType
   *          orderType
   */
  private void orderTransaction(MessageForm messageForm, int orderStatus, int orderType) {
    log.debug("[sc] orderTransaction method call");
    log.debug("[sc] messageForm : {}, orderStatus : {}, orderType : {}", messageForm.toString(),
        orderStatus, orderType);
    if (orderStatus == OrderStatus.LOCK_REQUEST.getValue()) {
      lockRequestHandler.handle(messageForm);
    } else if (orderStatus == OrderStatus.LOCK_RESPONSE.getValue()) {
      lockResponseHandler.handle(messageForm);
    } else if (orderStatus == OrderStatus.SETTLE_ACCOUNT_REQUEST.getValue()) {
      settleAccountRequestHandler.handle(messageForm);
    } else if (orderStatus == OrderStatus.SETTLE_ACCOUNT_RESPONSE.getValue()) {
      settleAccountResponseHandler.handle(messageForm);
    } else if (orderStatus == OrderStatus.SETTLE_TOKEN_REQUEST.getValue()) {
      settleTokenRequestHandler.handle(messageForm);
    } else if (orderStatus == OrderStatus.SETTLE_TOKEN_RESPONSE.getValue()) {
      settleTokenResponseHandler.handle(messageForm);
    }
  }

  /**
   * execute smart contract - register bank account state DB.
   * 
   * @param custId
   *          custId
   * @param balance
   *          init balance
   */
  private void bankTransaction(String newAccountUserId, int initBalance) {
    log.debug("[sc] bankTransaction method call");
    log.debug("[sc] newAccountUserId : {}, initBalance : {}", newAccountUserId, initBalance);
    userService.registerBankAccount(newAccountUserId, initBalance);
  }

}
