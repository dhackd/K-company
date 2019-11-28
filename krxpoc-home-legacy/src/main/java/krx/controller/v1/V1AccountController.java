package krx.controller.v1;

import krx.model.ResultForm;
import krx.service.facility.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class V1AccountController extends V1AbstractController {

  @Autowired
  AccountService accountService;

  /**
   * get Account information.
   * 
   * @param userId userid
   * @return
   */
  @GetMapping("accounts/{userId}")
  public ResultForm getAccountInfo(@PathVariable String userId) {
    logger.info("[TC]get account info >>>>>>>> {}", userId);
    ResultForm resultForm = new ResultForm();
    Boolean isPresent = false;
    int balance = accountService.findAccountBalance(userId);

    if (balance > 0) {
      resultForm.setData(balance);
      isPresent = true;
    }

    resultForm.setSuccess(isPresent);
    return resultForm;
  }
}
