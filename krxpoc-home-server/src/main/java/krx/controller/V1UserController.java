package krx.controller;

import java.util.Optional;
import krx.model.BankAccount;
import krx.model.KsdAsset;
import krx.model.ResultForm;
import krx.repository.BankAccountJpaRepository;
import krx.repository.UserJpaRepository;
import krx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class V1UserController extends V1AbstractController {

  @Autowired
  UserJpaRepository userJpaRepository;
  
  @Autowired
  UserService userService;

  @Autowired
  BankAccountJpaRepository bankAccountJpaRepository;

  /**
   * find user addr.
   * 
   * @param userId user id
   * @return
   */
  @GetMapping("/users/addresses/{userId}")
  public ResultForm findUserAddress(@PathVariable String userId) {
    log.info("[UC] find user request: {}", userId);

    String address = userJpaRepository.findById(userId).get().getAddr();

    ResultForm resultFrom = new ResultForm();
    resultFrom.setData(address);
    resultFrom.setSuccess(true);
    return resultFrom;
  }

  /**
   * find user token.
   * 
   * @param userId user id
   * @return
   */
  @GetMapping("/tokens/{tokenId}/properties/{userId}")
  public ResultForm findUserToken(@PathVariable String tokenId, @PathVariable String userId) {
    log.info("[UC] find user token request: {}", tokenId, userId);

    int quantity;
    //여기 부분에서 각각 토큰가지고 찾아주는 로직 필요
    
    Optional<? extends KsdAsset> token = userService.getToken(tokenId, userId);
    if (token.isPresent()) {
      quantity = token.get().getQuantity();
    } else {
      quantity = 0;
    }

    ResultForm resultFrom = new ResultForm();
    resultFrom.setData(quantity);
    resultFrom.setSuccess(true);
    return resultFrom;
  }

  /**
   * find user account.
   * 
   * @param userId user id
   * @return
   */
  @GetMapping("/accounts/{userId}")
  public ResultForm findUserAccount(@PathVariable String userId) {
    log.info("[UC] find user account request: {}", userId);

    int balance = -1;
    boolean checkAccount = false;
    Optional<BankAccount> account = bankAccountJpaRepository.findById(userId);

    if (account.isPresent()) {
      balance = account.get().getBalance();
      checkAccount = true;
    }

    ResultForm resultFrom = new ResultForm();
    resultFrom.setData(balance);
    resultFrom.setSuccess(checkAccount);
    return resultFrom;
  }
}
