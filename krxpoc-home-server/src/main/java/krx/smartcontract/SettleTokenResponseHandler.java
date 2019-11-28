package krx.smartcontract;

import static krx.util.Utils.sha256hex;

import io.blocko.json.JSONObject;
import javassist.NotFoundException;
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
import krx.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SettleTokenResponseHandler implements Handler {

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
  private SignService signService;

  /**
   * Handle data for settle token response.
   *
   * @param messageForm MessageForm
   */
  public void handle(MessageForm messageForm) {
    try {
      log.info("Status 5 : SettleTokenResponse");
      log.info("자산 정보 변경 완료 확인");

      final SmartContractForm smartContractForm = messageForm.getSmartContractForm();
      final OrderForm orderForm = smartContractForm.getOrderform();
      final JSONObject json = new JSONObject(orderForm);
      final User user = userJpaRepository.findById(orderForm.getCustId())
          .orElseThrow(() -> new NotFoundException("해당 유저 없음 : " + orderForm.getCustId()));

      final int orderType = smartContractForm.getOrderType();
      final String facility = messageForm.getGlobalId().substring(1, 6);

      if (signService.verifySignature(user.getAddr(), sha256hex(json.toString()),
          smartContractForm.getSignature())) {
        final String result = settleToTokenExecution(orderForm, orderType, facility);
        log.info("settleToTokenExecution complete : {}", result);
      } else {
        throw new NotFoundException("일치하는 사인을 찾을 수 없습니다.");
      }
    } catch (NotFoundException e) {
      e.printStackTrace();
    }
  }

  private String settleToTokenExecution(OrderForm orderForm, int orderType, String facility)
      throws NotFoundException {
    if (OrderType.BUY.getValue() == orderType) {
      settleToBuyBranch(facility, orderForm);
    } else if (OrderType.SELL.getValue() == orderType) {
      settleToSellBranch(facility, orderForm);
    } else {
      log.info("not exists orderType");
      return "failed";
    }

    return "success";
  }

  private void settleToBuy_1(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock01 targetKsdAssetLock =
        ksdAssetLockJpaRepository1.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository1.delete(targetKsdAssetLock);

    final KsdAsset01 ksdAsset01 =
        ksdAssetJpaRepository1.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset01 newKsdAsset = new KsdAsset01();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository1.save(ksdAsset01);
  }

  private void settleToSell_1(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock01 ksdAssetLock =
        ksdAssetLockJpaRepository1.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository1.delete(ksdAssetLock);

    final KsdAsset01 targetKsdAsset01 =
        ksdAssetJpaRepository1.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset01 newKsdAsset = new KsdAsset01();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository1.save(targetKsdAsset01);
  }

  private void settleToBuy_2(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock02 targetKsdAssetLock =
        ksdAssetLockJpaRepository2.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository2.delete(targetKsdAssetLock);

    final KsdAsset02 ksdAsset02 =
        ksdAssetJpaRepository2.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset02 newKsdAsset = new KsdAsset02();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository2.save(ksdAsset02);
  }

  private void settleToSell_2(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock02 ksdAssetLock =
        ksdAssetLockJpaRepository2.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository2.delete(ksdAssetLock);

    final KsdAsset02 targetKsdAsset02 =
        ksdAssetJpaRepository2.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset02 newKsdAsset = new KsdAsset02();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository2.save(targetKsdAsset02);
  }

  private void settleToBuy_3(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock03 targetKsdAssetLock =
        ksdAssetLockJpaRepository3.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository3.delete(targetKsdAssetLock);

    final KsdAsset03 ksdAsset03 =
        ksdAssetJpaRepository3.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset03 newKsdAsset = new KsdAsset03();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository3.save(ksdAsset03);
  }

  private void settleToSell_3(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock03 ksdAssetLock =
        ksdAssetLockJpaRepository3.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository3.delete(ksdAssetLock);

    final KsdAsset03 targetKsdAsset03 =
        ksdAssetJpaRepository3.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset03 newKsdAsset = new KsdAsset03();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository3.save(targetKsdAsset03);
  }

  private void settleToBuy_4(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock04 targetKsdAssetLock =
        ksdAssetLockJpaRepository4.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository4.delete(targetKsdAssetLock);

    final KsdAsset04 ksdAsset04 =
        ksdAssetJpaRepository4.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset04 newKsdAsset = new KsdAsset04();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository4.save(ksdAsset04);
  }

  private void settleToSell_4(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock04 ksdAssetLock =
        ksdAssetLockJpaRepository4.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository4.delete(ksdAssetLock);

    final KsdAsset04 targetKsdAsset04 =
        ksdAssetJpaRepository4.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset04 newKsdAsset = new KsdAsset04();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository4.save(targetKsdAsset04);
  }

  private void settleToBuy_5(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock05 targetKsdAssetLock =
        ksdAssetLockJpaRepository5.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository5.delete(targetKsdAssetLock);

    final KsdAsset05 ksdAsset05 =
        ksdAssetJpaRepository5.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset05 newKsdAsset = new KsdAsset05();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository5.save(ksdAsset05);
  }

  private void settleToSell_5(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock05 ksdAssetLock =
        ksdAssetLockJpaRepository5.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository5.delete(ksdAssetLock);

    final KsdAsset05 targetKsdAsset05 =
        ksdAssetJpaRepository5.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset05 newKsdAsset = new KsdAsset05();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository5.save(targetKsdAsset05);
  }

  private void settleToBuy_6(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock06 targetKsdAssetLock =
        ksdAssetLockJpaRepository6.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository6.delete(targetKsdAssetLock);

    final KsdAsset06 ksdAsset06 =
        ksdAssetJpaRepository6.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset06 newKsdAsset = new KsdAsset06();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository6.save(ksdAsset06);
  }

  private void settleToSell_6(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock06 ksdAssetLock =
        ksdAssetLockJpaRepository6.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository6.delete(ksdAssetLock);

    final KsdAsset06 targetKsdAsset06 =
        ksdAssetJpaRepository6.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset06 newKsdAsset = new KsdAsset06();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository6.save(targetKsdAsset06);
  }

  private void settleToBuy_7(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock07 targetKsdAssetLock =
        ksdAssetLockJpaRepository7.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository7.delete(targetKsdAssetLock);

    final KsdAsset07 ksdAsset07 =
        ksdAssetJpaRepository7.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset07 newKsdAsset = new KsdAsset07();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository7.save(ksdAsset07);
  }

  private void settleToSell_7(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock07 ksdAssetLock =
        ksdAssetLockJpaRepository7.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository7.delete(ksdAssetLock);

    final KsdAsset07 targetKsdAsset07 =
        ksdAssetJpaRepository7.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset07 newKsdAsset = new KsdAsset07();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository7.save(targetKsdAsset07);
  }

  private void settleToBuy_8(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock08 targetKsdAssetLock =
        ksdAssetLockJpaRepository8.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository8.delete(targetKsdAssetLock);

    final KsdAsset08 ksdAsset08 =
        ksdAssetJpaRepository8.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset08 newKsdAsset = new KsdAsset08();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository8.save(ksdAsset08);
  }

  private void settleToSell_8(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock08 ksdAssetLock =
        ksdAssetLockJpaRepository8.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository8.delete(ksdAssetLock);

    final KsdAsset08 targetKsdAsset08 =
        ksdAssetJpaRepository8.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset08 newKsdAsset = new KsdAsset08();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository8.save(targetKsdAsset08);
  }

  private void settleToBuy_9(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock09 targetKsdAssetLock =
        ksdAssetLockJpaRepository9.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository9.delete(targetKsdAssetLock);

    final KsdAsset09 ksdAsset09 =
        ksdAssetJpaRepository9.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset09 newKsdAsset = new KsdAsset09();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository9.save(ksdAsset09);
  }

  private void settleToSell_9(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock09 ksdAssetLock =
        ksdAssetLockJpaRepository9.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository9.delete(ksdAssetLock);

    final KsdAsset09 targetKsdAsset09 =
        ksdAssetJpaRepository9.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset09 newKsdAsset = new KsdAsset09();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository9.save(targetKsdAsset09);
  }

  private void settleToBuy_10(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock10 targetKsdAssetLock =
        ksdAssetLockJpaRepository10.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository10.delete(targetKsdAssetLock);

    final KsdAsset10 ksdAsset10 =
        ksdAssetJpaRepository10.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset10 newKsdAsset = new KsdAsset10();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository10.save(ksdAsset10);
  }

  private void settleToSell_10(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock10 ksdAssetLock =
        ksdAssetLockJpaRepository10.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository10.delete(ksdAssetLock);

    final KsdAsset10 targetKsdAsset10 =
        ksdAssetJpaRepository10.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset10 newKsdAsset = new KsdAsset10();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository10.save(targetKsdAsset10);
  }

  private void settleToBuy_11(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock11 targetKsdAssetLock =
        ksdAssetLockJpaRepository11.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository11.delete(targetKsdAssetLock);

    final KsdAsset11 ksdAsset11 =
        ksdAssetJpaRepository11.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset11 newKsdAsset = new KsdAsset11();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository11.save(ksdAsset11);
  }

  private void settleToSell_11(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock11 ksdAssetLock =
        ksdAssetLockJpaRepository11.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository11.delete(ksdAssetLock);

    final KsdAsset11 targetKsdAsset11 =
        ksdAssetJpaRepository11.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset11 newKsdAsset = new KsdAsset11();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository11.save(targetKsdAsset11);
  }

  private void settleToBuy_12(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock12 targetKsdAssetLock =
        ksdAssetLockJpaRepository12.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository12.delete(targetKsdAssetLock);

    final KsdAsset12 ksdAsset12 =
        ksdAssetJpaRepository12.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset12 newKsdAsset = new KsdAsset12();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository12.save(ksdAsset12);
  }

  private void settleToSell_12(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock12 ksdAssetLock =
        ksdAssetLockJpaRepository12.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository12.delete(ksdAssetLock);

    final KsdAsset12 targetKsdAsset12 =
        ksdAssetJpaRepository12.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset12 newKsdAsset = new KsdAsset12();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository12.save(targetKsdAsset12);
  }

  private void settleToBuy_13(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock13 targetKsdAssetLock =
        ksdAssetLockJpaRepository13.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository13.delete(targetKsdAssetLock);

    final KsdAsset13 ksdAsset13 =
        ksdAssetJpaRepository13.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset13 newKsdAsset = new KsdAsset13();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository13.save(ksdAsset13);
  }

  private void settleToSell_13(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock13 ksdAssetLock =
        ksdAssetLockJpaRepository13.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository13.delete(ksdAssetLock);

    final KsdAsset13 targetKsdAsset13 =
        ksdAssetJpaRepository13.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset13 newKsdAsset = new KsdAsset13();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository13.save(targetKsdAsset13);
  }

  private void settleToBuy_14(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock14 targetKsdAssetLock =
        ksdAssetLockJpaRepository14.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository14.delete(targetKsdAssetLock);

    final KsdAsset14 ksdAsset14 =
        ksdAssetJpaRepository14.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset14 newKsdAsset = new KsdAsset14();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository14.save(ksdAsset14);
  }

  private void settleToSell_14(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock14 ksdAssetLock =
        ksdAssetLockJpaRepository14.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository14.delete(ksdAssetLock);

    final KsdAsset14 targetKsdAsset14 =
        ksdAssetJpaRepository14.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset14 newKsdAsset = new KsdAsset14();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository14.save(targetKsdAsset14);
  }

  private void settleToBuy_15(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock15 targetKsdAssetLock =
        ksdAssetLockJpaRepository15.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository15.delete(targetKsdAssetLock);

    final KsdAsset15 ksdAsset15 =
        ksdAssetJpaRepository15.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset15 newKsdAsset = new KsdAsset15();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository15.save(ksdAsset15);
  }

  private void settleToSell_15(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock15 ksdAssetLock =
        ksdAssetLockJpaRepository15.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository15.delete(ksdAssetLock);

    final KsdAsset15 targetKsdAsset15 =
        ksdAssetJpaRepository15.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset15 newKsdAsset = new KsdAsset15();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository15.save(targetKsdAsset15);
  }

  private void settleToBuy_16(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock16 targetKsdAssetLock =
        ksdAssetLockJpaRepository16.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository16.delete(targetKsdAssetLock);

    final KsdAsset16 ksdAsset16 =
        ksdAssetJpaRepository16.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset16 newKsdAsset = new KsdAsset16();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository16.save(ksdAsset16);
  }

  private void settleToSell_16(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock16 ksdAssetLock =
        ksdAssetLockJpaRepository16.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository16.delete(ksdAssetLock);

    final KsdAsset16 targetKsdAsset16 =
        ksdAssetJpaRepository16.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset16 newKsdAsset = new KsdAsset16();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository16.save(targetKsdAsset16);
  }

  private void settleToBuy_17(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock17 targetKsdAssetLock =
        ksdAssetLockJpaRepository17.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository17.delete(targetKsdAssetLock);

    final KsdAsset17 ksdAsset17 =
        ksdAssetJpaRepository17.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset17 newKsdAsset = new KsdAsset17();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository17.save(ksdAsset17);
  }

  private void settleToSell_17(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock17 ksdAssetLock =
        ksdAssetLockJpaRepository17.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository17.delete(ksdAssetLock);

    final KsdAsset17 targetKsdAsset17 =
        ksdAssetJpaRepository17.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset17 newKsdAsset = new KsdAsset17();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository17.save(targetKsdAsset17);
  }

  private void settleToBuy_18(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock18 targetKsdAssetLock =
        ksdAssetLockJpaRepository18.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository18.delete(targetKsdAssetLock);

    final KsdAsset18 ksdAsset18 =
        ksdAssetJpaRepository18.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset18 newKsdAsset = new KsdAsset18();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository18.save(ksdAsset18);
  }

  private void settleToSell_18(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock18 ksdAssetLock =
        ksdAssetLockJpaRepository18.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository18.delete(ksdAssetLock);

    final KsdAsset18 targetKsdAsset18 =
        ksdAssetJpaRepository18.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset18 newKsdAsset = new KsdAsset18();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository18.save(targetKsdAsset18);
  }

  private void settleToBuy_19(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock19 targetKsdAssetLock =
        ksdAssetLockJpaRepository19.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository19.delete(targetKsdAssetLock);

    final KsdAsset19 ksdAsset19 =
        ksdAssetJpaRepository19.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset19 newKsdAsset = new KsdAsset19();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository19.save(ksdAsset19);
  }

  private void settleToSell_19(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock19 ksdAssetLock =
        ksdAssetLockJpaRepository19.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository19.delete(ksdAssetLock);

    final KsdAsset19 targetKsdAsset19 =
        ksdAssetJpaRepository19.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset19 newKsdAsset = new KsdAsset19();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository19.save(targetKsdAsset19);
  }

  private void settleToBuy_20(OrderForm buyOrderForm) throws NotFoundException {
    final KsdAssetLock20 targetKsdAssetLock =
        ksdAssetLockJpaRepository20.findById(buyOrderForm.getTargetOrderNum()).orElseThrow(
            () -> new NotFoundException("잠금 정보 없음 : " + buyOrderForm.getTargetOrderNum()));

    log.info("자산 락 해제 : {}", targetKsdAssetLock);
    ksdAssetLockJpaRepository20.delete(targetKsdAssetLock);

    final KsdAsset20 ksdAsset20 =
        ksdAssetJpaRepository20.findById(buyOrderForm.getCustId()).map(ksdAsset -> {
          ksdAsset.setQuantity(ksdAsset.getQuantity() + buyOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", buyOrderForm.getTargetId(), buyOrderForm.getCustId(),
              ksdAsset.getQuantity());
          return ksdAsset;
        }).orElseGet(() -> {
          final KsdAsset20 newKsdAsset = new KsdAsset20();
          newKsdAsset.setCustId(buyOrderForm.getCustId());
          newKsdAsset.setQuantity(buyOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", buyOrderForm.getCustId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository20.save(ksdAsset20);
  }

  private void settleToSell_20(OrderForm sellOrderForm) throws NotFoundException {
    final KsdAssetLock20 ksdAssetLock =
        ksdAssetLockJpaRepository20.findById(sellOrderForm.getOrderNum())
            .orElseThrow(() -> new NotFoundException("잠금 정보 없음 : " + sellOrderForm.getOrderNum()));

    log.info("자산 락 해제 : {}", ksdAssetLock);
    ksdAssetLockJpaRepository20.delete(ksdAssetLock);

    final KsdAsset20 targetKsdAsset20 =
        ksdAssetJpaRepository20.findById(sellOrderForm.getTargetId()).map(targetKsdAsset -> {
          targetKsdAsset.setQuantity(targetKsdAsset.getQuantity() + sellOrderForm.getQuantity());
          log.info("{} 가 {} 에게 {} 만큼 입금", sellOrderForm.getCustId(), sellOrderForm.getCustId(),
              sellOrderForm.getQuantity());
          return targetKsdAsset;
        }).orElseGet(() -> {
          final KsdAsset20 newKsdAsset = new KsdAsset20();
          newKsdAsset.setCustId(sellOrderForm.getCustId());
          newKsdAsset.setQuantity(sellOrderForm.getQuantity());
          log.info("신규 자산 등록 : {} - {}", sellOrderForm.getTargetId(), newKsdAsset);
          return newKsdAsset;
        });
    ksdAssetJpaRepository20.save(targetKsdAsset20);
  }

  private void settleToBuyBranch(String facility, OrderForm buyOrderForm) throws NotFoundException {
    switch (facility) {
      case "ksd01":
        settleToBuy_1(buyOrderForm);
        break;
      case "ksd02":
        settleToBuy_2(buyOrderForm);
        break;
      case "ksd03":
        settleToBuy_3(buyOrderForm);
        break;
      case "ksd04":
        settleToBuy_4(buyOrderForm);
        break;
      case "ksd05":
        settleToBuy_5(buyOrderForm);
        break;
      case "ksd06":
        settleToBuy_6(buyOrderForm);
        break;
      case "ksd07":
        settleToBuy_7(buyOrderForm);
        break;
      case "ksd08":
        settleToBuy_8(buyOrderForm);
        break;
      case "ksd09":
        settleToBuy_9(buyOrderForm);
        break;
      case "ksd10":
        settleToBuy_10(buyOrderForm);
        break;
      case "ksd11":
        settleToBuy_11(buyOrderForm);
        break;
      case "ksd12":
        settleToBuy_12(buyOrderForm);
        break;
      case "ksd13":
        settleToBuy_13(buyOrderForm);
        break;
      case "ksd14":
        settleToBuy_14(buyOrderForm);
        break;
      case "ksd15":
        settleToBuy_15(buyOrderForm);
        break;
      case "ksd16":
        settleToBuy_16(buyOrderForm);
        break;
      case "ksd17":
        settleToBuy_17(buyOrderForm);
        break;
      case "ksd18":
        settleToBuy_18(buyOrderForm);
        break;
      case "ksd19":
        settleToBuy_19(buyOrderForm);
        break;
      case "ksd20":
        settleToBuy_20(buyOrderForm);
        break;

      default:
        break;
    }
  }

  private void settleToSellBranch(String facility, OrderForm sellOrderForm)
      throws NotFoundException {
    switch (facility) {
      case "ksd01":
        settleToSell_1(sellOrderForm);
        break;
      case "ksd02":
        settleToSell_2(sellOrderForm);
        break;
      case "ksd03":
        settleToSell_3(sellOrderForm);
        break;
      case "ksd04":
        settleToSell_4(sellOrderForm);
        break;
      case "ksd05":
        settleToSell_5(sellOrderForm);
        break;
      case "ksd06":
        settleToSell_6(sellOrderForm);
        break;
      case "ksd07":
        settleToSell_7(sellOrderForm);
        break;
      case "ksd08":
        settleToSell_8(sellOrderForm);
        break;
      case "ksd09":
        settleToSell_9(sellOrderForm);
        break;
      case "ksd10":
        settleToSell_10(sellOrderForm);
        break;
      case "ksd11":
        settleToSell_11(sellOrderForm);
        break;
      case "ksd12":
        settleToSell_12(sellOrderForm);
        break;
      case "ksd13":
        settleToSell_13(sellOrderForm);
        break;
      case "ksd14":
        settleToSell_14(sellOrderForm);
        break;
      case "ksd15":
        settleToSell_15(sellOrderForm);
        break;
      case "ksd16":
        settleToSell_16(sellOrderForm);
        break;
      case "ksd17":
        settleToSell_17(sellOrderForm);
        break;
      case "ksd18":
        settleToSell_18(sellOrderForm);
        break;
      case "ksd19":
        settleToSell_19(sellOrderForm);
        break;
      case "ksd20":
        settleToSell_20(sellOrderForm);
        break;

      default:
        break;
    }
  }
}
