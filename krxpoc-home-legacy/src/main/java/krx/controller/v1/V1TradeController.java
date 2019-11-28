package krx.controller.v1;

import krx.exception.NotEnoughBalance;
import krx.exception.NotEnoughToken;
import krx.model.ResultForm;
import krx.service.facility.AccountService;
import krx.service.facility.TokenService;
import krx.service.trade.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trade")
@CrossOrigin
public class V1TradeController extends V1AbstractController {

  @Autowired
  TradeService tradeService;

  @Autowired
  AccountService accountService;

  @Autowired
  TokenService tokenService;

  /**
   * buy order controller.
   * 
   * @param id user id.
   * @param price price.
   * @param amount amount.
   * @param tokenId token id.
   * @return
   */
  @Deprecated
  @PostMapping("buy")
  public ResultForm buyOrder(String id, int price, int amount, int tokenId)
      throws NotEnoughBalance {
    logger.info("[TC]buy order >>>>>>>> {}, {}, {}", id, price, amount);

    Long totalPrice = Long.valueOf(price * amount);
    String message;

    if (accountService.checkAccounts(id, totalPrice)) {
      String orderNum = tradeService.registerBuyOrder(tokenId, id, price, amount);
      message = "success to register buy order: " + orderNum;
    } else {
      throw new NotEnoughBalance();
    }

    ResultForm resultForm = new ResultForm();
    resultForm.setData(message);
    resultForm.setSuccess(true);
    return resultForm;
  }

  /**
   * sell order controller.
   * 
   * @param id user id.
   * @param price price.
   * @param amount amount.
   * @return
   */
  @Deprecated
  @PostMapping("sell")
  public ResultForm sellOrder(String id, int price, int amount, int tokenId) throws NotEnoughToken {
    logger.info("[TC]sell order >>>>>>>> {}, {}, {}", id, price, amount);

    String message;

    if (tokenService.checkTokens(tokenId, id, amount)) {
      String orderNum = tradeService.registerSellOrder(tokenId, id, price, amount);
      message = "success to register sell order: " + orderNum;
    } else {
      throw new NotEnoughToken();
    }

    ResultForm resultForm = new ResultForm();
    resultForm.setData(message);
    resultForm.setSuccess(true);
    return resultForm;
  }


}
