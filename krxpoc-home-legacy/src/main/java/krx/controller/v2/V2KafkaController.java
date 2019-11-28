package krx.controller.v2;

import krx.model.Buy;
import krx.model.ResultForm;
import krx.model.Sell;
import krx.service.FutureService;
import krx.service.trade.MatchService;
import krx.service.trade.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class V2KafkaController extends V2AbstractController {
  @Autowired
  TradeService tradeService;

  @Autowired
  MatchService matchService;
  
  @Autowired
  FutureService futureService;

  /**
   * finish lock account.
   * @param orderNum order number
   * @return
   */
  @PatchMapping("orders/buys/{orderNum}")
  public ResultForm finishLockAccount(@PathVariable String orderNum) {
    logger.info("[KC]start buy match >>>>>>>> {}", orderNum);
    
    Buy buyOrder = tradeService.getBuyOrder(orderNum);
    
    tradeService.unlockBuyOrder(orderNum);
    futureService.completeFuture(orderNum);
    matchService.buyMatch(orderNum, buyOrder.getPrice(), buyOrder.getAmount());
    
    String message = "success to buy matching";
    ResultForm resultForm = new ResultForm();
    resultForm.setData(message);
    resultForm.setSuccess(true);
    return resultForm;
  }

  /**
   * finish lock token.
   * @param orderNum order number
   * @return
   */
  @PatchMapping("orders/sells/{orderNum}")
  public ResultForm finishLockToken(@PathVariable String orderNum) {
    logger.info("[KC]start sell match >>>>>>>> {}", orderNum);

    Sell sellOrder = tradeService.getSellOrder(orderNum);
    
    tradeService.unlockSellOrder(orderNum);
    futureService.completeFuture(orderNum);
    matchService.sellMatch(orderNum, sellOrder.getPrice(), sellOrder.getAmount());
    
    String message = "success to sell matching";
    ResultForm resultForm = new ResultForm();
    resultForm.setData(message);
    resultForm.setSuccess(true);
    return resultForm;
  }
}
