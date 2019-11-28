package krx.controller.v2;

import krx.exception.NotEnoughBalance;
import krx.exception.NotEnoughToken;
import krx.model.ResultForm;
import krx.service.FutureService;
import krx.service.facility.AccountService;
import krx.service.facility.TokenService;
import krx.service.trade.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class V2TradeController extends V2AbstractController {
  @Autowired
  TradeService tradeService;

  @Autowired
  AccountService accountService;

  @Autowired
  TokenService tokenService;

  @Autowired
  FutureService futureService;

  /**
   * buy order controller.
   * 
   * @param id user id.
   * @param price price.
   * @param amount amount.
   * @param tokenId token id.
   * @return
   */
  @PostMapping("/tokens/registers/buys")
  public ResultForm buyOrder(String id, int price, int amount, int tokenId)
      throws NotEnoughBalance {
    logger.info("[TC]buy order >>>>>>>> {}, {}, {}, {}", id, price, amount, tokenId);

    Long totalPrice = Long.valueOf(price * amount);
    String message;

    if (accountService.checkAccounts(id, totalPrice)) {
      String orderNum = tradeService.registerBuyOrder(tokenId, id, price, amount);

      // start to observer
      futureService.createFuture(orderNum);

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
  @PostMapping("/tokens/registers/sells")
  public ResultForm sellOrder(String id, int price, int amount, int tokenId) throws NotEnoughToken {
    logger.info("[TC]sell order >>>>>>>> {}, {}, {}, {}", id, price, amount, tokenId);

    String message;

    if (tokenService.checkTokens(tokenId, id, amount)) {
      String orderNum = tradeService.registerSellOrder(tokenId, id, price, amount);

      // start to observer
      futureService.createFuture(orderNum);

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
