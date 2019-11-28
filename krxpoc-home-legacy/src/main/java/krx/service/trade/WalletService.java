package krx.service.trade;

import krx.model.Wallet;
import krx.service.facility.AccountService;
import krx.service.facility.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
  @Autowired
  AccountService accountService;

  @Autowired
  TokenService tokenService;

  /**
   * get account&token information.
   * 
   * @param id user id
   * @return
   */
  public Wallet getWalletInfo(int tokenId, String id) {
    int balance = accountService.findAccountBalance(id);
    int quantity = tokenService.findTokenQuantity(tokenId, id);
    
    if (quantity < 0) {
      quantity = 0;
    }

    Wallet wallet = new Wallet();
    wallet.setBalance(balance);
    wallet.setToken(quantity);
    return wallet;
  }
}
