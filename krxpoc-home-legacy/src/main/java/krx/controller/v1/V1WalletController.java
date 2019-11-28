package krx.controller.v1;

import krx.model.ResultForm;
import krx.model.Wallet;
import krx.service.trade.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class V1WalletController extends V1AbstractController {
  @Autowired
  WalletService walletService;

  /**
   * get wallet information. (account & token).
   * 
   * @param userId user id
   * @return
   */
  @GetMapping("tokens/{tokenId}/wallets/{userId}")
  public ResultForm getWalletInfo(@PathVariable int tokenId, @PathVariable String userId) {
    Wallet walletInfo = walletService.getWalletInfo(tokenId, userId);

    ResultForm resultForm = new ResultForm();
    resultForm.setData(walletInfo);
    resultForm.setSuccess(true);
    return resultForm;
  }
}
