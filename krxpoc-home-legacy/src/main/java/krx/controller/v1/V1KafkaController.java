package krx.controller.v1;

import krx.model.Buy;
import krx.model.ResultForm;
import krx.model.Sell;
import krx.service.trade.MatchService;
import krx.service.trade.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class V1KafkaController extends V1AbstractController {
  @Autowired
  TradeService tradeService;

  @Autowired
  MatchService matchService;

  /**
   * finish lock account.
   * @param orderNum order number
   * @return
   */
  @Deprecated
  @PostMapping("accounts")
  public ResultForm finishlockAccount(@RequestBody String orderNum) {
    String cleanOrderNum = cleanSpeicalCharactor(orderNum);
    logger.info("[KC]start buy match >>>>>>>> {}", cleanOrderNum);
    
    Buy buyOrder = tradeService.getBuyOrder(cleanOrderNum);
    
    tradeService.unlockBuyOrder(cleanOrderNum);
    matchService.buyMatch(cleanOrderNum, buyOrder.getPrice(), buyOrder.getAmount());

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
  @Deprecated
  @PostMapping("tokens")
  public ResultForm finishlockToken(@RequestBody String orderNum) {
    String cleanOrderNum = cleanSpeicalCharactor(orderNum);
    logger.info("[KC]start sell match >>>>>>>> {}", cleanOrderNum);

    Sell sellOrder = tradeService.getSellOrder(cleanOrderNum);
    
    tradeService.unlockSellOrder(cleanOrderNum);
    matchService.sellMatch(cleanOrderNum, sellOrder.getPrice(), sellOrder.getAmount());

    String message = "success to sell matching";
    ResultForm resultForm = new ResultForm();
    resultForm.setData(message);
    resultForm.setSuccess(true);
    return resultForm;
  }
  
  private String cleanSpeicalCharactor(String badString) {
    return badString.replaceAll("\"", "");
  }
}
