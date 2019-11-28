package krx.smartcontract;

import static krx.util.Utils.sha256hex;

import io.blocko.json.JSONObject;
import java.util.Optional;
import krx.model.BankAccount;
import krx.model.BankOrderLock;
import krx.model.OrderType;
import krx.model.User;
import krx.model.packet.MessageForm;
import krx.model.packet.OrderForm;
import krx.model.packet.SmartContractForm;
import krx.model.sample.KsdAsset01;
import krx.model.sample.KsdAsset02;
import krx.model.sample.KsdAsset03;
import krx.model.sample.KsdAsset04;
import krx.model.sample.KsdAsset05;
import krx.model.sample.KsdAsset06;
import krx.model.sample.KsdAsset07;
import krx.model.sample.KsdAsset08;
import krx.model.sample.KsdAsset09;
import krx.model.sample.KsdAsset10;
import krx.model.sample.KsdAsset11;
import krx.model.sample.KsdAsset12;
import krx.model.sample.KsdAsset13;
import krx.model.sample.KsdAsset14;
import krx.model.sample.KsdAsset15;
import krx.model.sample.KsdAsset16;
import krx.model.sample.KsdAsset17;
import krx.model.sample.KsdAsset18;
import krx.model.sample.KsdAsset19;
import krx.model.sample.KsdAsset20;
import krx.model.sample.KsdAssetLock01;
import krx.model.sample.KsdAssetLock02;
import krx.model.sample.KsdAssetLock03;
import krx.model.sample.KsdAssetLock04;
import krx.model.sample.KsdAssetLock05;
import krx.model.sample.KsdAssetLock06;
import krx.model.sample.KsdAssetLock07;
import krx.model.sample.KsdAssetLock08;
import krx.model.sample.KsdAssetLock09;
import krx.model.sample.KsdAssetLock10;
import krx.model.sample.KsdAssetLock11;
import krx.model.sample.KsdAssetLock12;
import krx.model.sample.KsdAssetLock13;
import krx.model.sample.KsdAssetLock14;
import krx.model.sample.KsdAssetLock15;
import krx.model.sample.KsdAssetLock16;
import krx.model.sample.KsdAssetLock17;
import krx.model.sample.KsdAssetLock18;
import krx.model.sample.KsdAssetLock19;
import krx.model.sample.KsdAssetLock20;
import krx.repository.BankAccountJpaRepository;
import krx.repository.BankOrderLockJpaRepository;
import krx.repository.UserJpaRepository;
import krx.repository.sample.KsdAssetJpaRepository01;
import krx.repository.sample.KsdAssetJpaRepository02;
import krx.repository.sample.KsdAssetJpaRepository03;
import krx.repository.sample.KsdAssetJpaRepository04;
import krx.repository.sample.KsdAssetJpaRepository05;
import krx.repository.sample.KsdAssetJpaRepository06;
import krx.repository.sample.KsdAssetJpaRepository07;
import krx.repository.sample.KsdAssetJpaRepository08;
import krx.repository.sample.KsdAssetJpaRepository09;
import krx.repository.sample.KsdAssetJpaRepository10;
import krx.repository.sample.KsdAssetJpaRepository11;
import krx.repository.sample.KsdAssetJpaRepository12;
import krx.repository.sample.KsdAssetJpaRepository13;
import krx.repository.sample.KsdAssetJpaRepository14;
import krx.repository.sample.KsdAssetJpaRepository15;
import krx.repository.sample.KsdAssetJpaRepository16;
import krx.repository.sample.KsdAssetJpaRepository17;
import krx.repository.sample.KsdAssetJpaRepository18;
import krx.repository.sample.KsdAssetJpaRepository19;
import krx.repository.sample.KsdAssetJpaRepository20;
import krx.service.KafkaService;
import krx.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LockResponseHandler implements Handler {

  @Autowired
  private UserJpaRepository userJpaRepository;
  @Autowired
  private KsdAssetJpaRepository01 ksdAssetJpaRepository1;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository01 ksdAssetLockJpaRepository1;
  @Autowired
  private KsdAssetJpaRepository02 ksdAssetJpaRepository2;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository02 ksdAssetLockJpaRepository2;
  @Autowired
  private KsdAssetJpaRepository03 ksdAssetJpaRepository3;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository03 ksdAssetLockJpaRepository3;
  @Autowired
  private KsdAssetJpaRepository04 ksdAssetJpaRepository4;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository04 ksdAssetLockJpaRepository4;
  @Autowired
  private KsdAssetJpaRepository05 ksdAssetJpaRepository5;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository05 ksdAssetLockJpaRepository5;
  @Autowired
  private KsdAssetJpaRepository06 ksdAssetJpaRepository6;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository06 ksdAssetLockJpaRepository6;
  @Autowired
  private KsdAssetJpaRepository07 ksdAssetJpaRepository7;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository07 ksdAssetLockJpaRepository7;
  @Autowired
  private KsdAssetJpaRepository08 ksdAssetJpaRepository8;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository08 ksdAssetLockJpaRepository8;
  @Autowired
  private KsdAssetJpaRepository09 ksdAssetJpaRepository9;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository09 ksdAssetLockJpaRepository9;
  @Autowired
  private KsdAssetJpaRepository10 ksdAssetJpaRepository10;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository10 ksdAssetLockJpaRepository10;
  @Autowired
  private KsdAssetJpaRepository11 ksdAssetJpaRepository11;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository11 ksdAssetLockJpaRepository11;
  @Autowired
  private KsdAssetJpaRepository12 ksdAssetJpaRepository12;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository12 ksdAssetLockJpaRepository12;
  @Autowired
  private KsdAssetJpaRepository13 ksdAssetJpaRepository13;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository13 ksdAssetLockJpaRepository13;
  @Autowired
  private KsdAssetJpaRepository14 ksdAssetJpaRepository14;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository14 ksdAssetLockJpaRepository14;
  @Autowired
  private KsdAssetJpaRepository15 ksdAssetJpaRepository15;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository15 ksdAssetLockJpaRepository15;
  @Autowired
  private KsdAssetJpaRepository16 ksdAssetJpaRepository16;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository16 ksdAssetLockJpaRepository16;
  @Autowired
  private KsdAssetJpaRepository17 ksdAssetJpaRepository17;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository17 ksdAssetLockJpaRepository17;
  @Autowired
  private KsdAssetJpaRepository18 ksdAssetJpaRepository18;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository18 ksdAssetLockJpaRepository18;
  @Autowired
  private KsdAssetJpaRepository19 ksdAssetJpaRepository19;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository19 ksdAssetLockJpaRepository19;
  @Autowired
  private KsdAssetJpaRepository20 ksdAssetJpaRepository20;
  @Autowired
  private krx.repository.sample.KsdAssetLockJpaRepository20 ksdAssetLockJpaRepository20;
  @Autowired
  private BankAccountJpaRepository bankAccountJpaRepository;
  @Autowired
  private BankOrderLockJpaRepository bankOrderLockJpaRepository;
  @Autowired
  private KafkaService kafkaService;
  @Autowired
  private SignService signService;

  /**
   * Handle data for lock response.
   *
   * @param messageForm
   *          MessageForm
   */
  public void handle(MessageForm messageForm) {
    log.info(this.getClass().getName());
    log.info("Status 1. LockResponse");

    final SmartContractForm smartContractForm = messageForm.getSmartContractForm();
    final OrderForm orderForm = smartContractForm.getOrderform();
    final int orderType = smartContractForm.getOrderType();
    final String signature = smartContractForm.getSignature();
    final String facility = messageForm.getGlobalId().substring(1, 6);

    Optional<User> user = userJpaRepository.findById(orderForm.getCustId());
    if (!user.isPresent()) {
      log.info("유저가 존재하지 않음");
      return;
    }

    // 사인 검증
    final boolean signCheck = signService.verifySignature(user.get().getAddr(),
        sha256hex(new JSONObject(orderForm).toString()), signature);
    if (!signCheck) {
      log.info("사인이 다름");
      return;
    }

    if (OrderType.SELL.getValue() == orderType) {
      // 매도 주문
      log.info("주문 고객자산 상태 변경 (락 생성)");

      // 주문정보 업데이트
      orderInfoUpdate(facility, user, orderForm);
      // 레거시 이벤트 콜
//      kafkaService.v2FinishlockToken(orderForm.getOrderNum());

    } else {
      // 매수 주문
      log.info("주문 고객계좌 상태 변경 (락 생성)");

      // 주문정보 업데이트
      Optional<BankAccount> bankAccount = bankAccountJpaRepository.findById(user.get().getCustId());
      if (bankAccount.isPresent()) {
        final int remains =
            bankAccount.get().getBalance() - (orderForm.getQuantity() * orderForm.getOrderPrice());
        if (remains >= 0) {
          bankAccount.get().setBalance(remains);
          bankAccountJpaRepository.save(bankAccount.get());

          // 주문 락 원장 생성
          BankOrderLock bankOrderLock = new BankOrderLock();
          bankOrderLock.setCustId(user.get().getCustId());
          bankOrderLock.setOrderNum(orderForm.getOrderNum());
          bankOrderLock.setPriceTotal(orderForm.getQuantity() * orderForm.getOrderPrice());
          bankOrderLockJpaRepository.save(bankOrderLock);
          
//          kafkaService.v2FinishlockAccount(orderForm.getOrderNum());

          log.info("정상 처리");
        } else {
          log.info("잔고 부족");
        }
      } else {
        log.info("계좌가 존재하지 않음");
      }
    }
  }

  private void createAssetLockData_1(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset01> ksdAsset = ksdAssetJpaRepository1.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository1.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock01 ksdAssetLock = new KsdAssetLock01();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository1.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }

  private void createAssetLockData_2(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset02> ksdAsset = ksdAssetJpaRepository2.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository2.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock02 ksdAssetLock = new KsdAssetLock02();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository2.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_3(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset03> ksdAsset = ksdAssetJpaRepository3.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository3.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock03 ksdAssetLock = new KsdAssetLock03();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository3.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_4(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset04> ksdAsset = ksdAssetJpaRepository4.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository4.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock04 ksdAssetLock = new KsdAssetLock04();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository4.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_5(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset05> ksdAsset = ksdAssetJpaRepository5.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository5.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock05 ksdAssetLock = new KsdAssetLock05();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository5.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_6(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset06> ksdAsset = ksdAssetJpaRepository6.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository6.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock06 ksdAssetLock = new KsdAssetLock06();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository6.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_7(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset07> ksdAsset = ksdAssetJpaRepository7.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository7.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock07 ksdAssetLock = new KsdAssetLock07();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository7.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_8(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset08> ksdAsset = ksdAssetJpaRepository8.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository8.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock08 ksdAssetLock = new KsdAssetLock08();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository8.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_9(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset09> ksdAsset = ksdAssetJpaRepository9.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository9.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock09 ksdAssetLock = new KsdAssetLock09();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository9.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_10(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset10> ksdAsset = ksdAssetJpaRepository10.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository10.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock10 ksdAssetLock = new KsdAssetLock10();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository10.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_11(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset11> ksdAsset = ksdAssetJpaRepository11.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository11.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock11 ksdAssetLock = new KsdAssetLock11();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository11.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_12(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset12> ksdAsset = ksdAssetJpaRepository12.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository12.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock12 ksdAssetLock = new KsdAssetLock12();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository12.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_13(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset13> ksdAsset = ksdAssetJpaRepository13.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository13.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock13 ksdAssetLock = new KsdAssetLock13();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository13.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_14(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset14> ksdAsset = ksdAssetJpaRepository14.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository14.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock14 ksdAssetLock = new KsdAssetLock14();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository14.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_15(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset15> ksdAsset = ksdAssetJpaRepository15.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository15.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock15 ksdAssetLock = new KsdAssetLock15();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository15.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_16(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset16> ksdAsset = ksdAssetJpaRepository16.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository16.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock16 ksdAssetLock = new KsdAssetLock16();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository16.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_17(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset17> ksdAsset = ksdAssetJpaRepository17.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository17.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock17 ksdAssetLock = new KsdAssetLock17();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository17.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_18(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset18> ksdAsset = ksdAssetJpaRepository18.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository18.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock18 ksdAssetLock = new KsdAssetLock18();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository18.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_19(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset19> ksdAsset = ksdAssetJpaRepository19.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository19.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock19 ksdAssetLock = new KsdAssetLock19();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository19.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void createAssetLockData_20(Optional<User> user, OrderForm orderForm) {
    // 주문정보 업데이트
    Optional<KsdAsset20> ksdAsset = ksdAssetJpaRepository20.findById(user.get().getCustId());

    if (ksdAsset.isPresent()) {
      log.info(ksdAsset.toString());

      final int remains = ksdAsset.get().getQuantity() - orderForm.getQuantity();
      if (remains >= 0) {
        ksdAsset.get().setQuantity(remains);
        ksdAssetJpaRepository20.save(ksdAsset.get());

        // 주문 락 원장 생성
        KsdAssetLock20 ksdAssetLock = new KsdAssetLock20();
        ksdAssetLock.setCustId(user.get().getCustId());
        ksdAssetLock.setOrderNum(orderForm.getOrderNum());
        ksdAssetLock.setQuantity(orderForm.getQuantity());
        ksdAssetLockJpaRepository20.save(ksdAssetLock);

        log.info("정상 처리");
      } else {
        log.info("개수 부족");
      }
    } else {
      log.info("자산 존재하지 않음");
    }
  }


  private void orderInfoUpdate(String facility, Optional<User> user, OrderForm orderForm) {
    switch (facility) {
      case "ksd01":
        createAssetLockData_1(user, orderForm);
        break;
      case "ksd02":
        createAssetLockData_2(user, orderForm);
        break;
      case "ksd03":
        createAssetLockData_3(user, orderForm);
        break;
      case "ksd04":
        createAssetLockData_4(user, orderForm);
        break;
      case "ksd05":
        createAssetLockData_5(user, orderForm);
        break;
      case "ksd06":
        createAssetLockData_6(user, orderForm);
        break;
      case "ksd07":
        createAssetLockData_7(user, orderForm);
        break;
      case "ksd08":
        createAssetLockData_8(user, orderForm);
        break;
      case "ksd09":
        createAssetLockData_9(user, orderForm);
        break;
      case "ksd10":
        createAssetLockData_10(user, orderForm);
        break;
      case "ksd11":
        createAssetLockData_11(user, orderForm);
        break;
      case "ksd12":
        createAssetLockData_12(user, orderForm);
        break;
      case "ksd13":
        createAssetLockData_13(user, orderForm);
        break;
      case "ksd14":
        createAssetLockData_14(user, orderForm);
        break;
      case "ksd15":
        createAssetLockData_15(user, orderForm);
        break;
      case "ksd16":
        createAssetLockData_16(user, orderForm);
        break;
      case "ksd17":
        createAssetLockData_17(user, orderForm);
        break;
      case "ksd18":
        createAssetLockData_18(user, orderForm);
        break;
      case "ksd19":
        createAssetLockData_19(user, orderForm);
        break;
      case "ksd20":
        createAssetLockData_20(user, orderForm);
        break;

      default:
        break;
    }

  }
}
