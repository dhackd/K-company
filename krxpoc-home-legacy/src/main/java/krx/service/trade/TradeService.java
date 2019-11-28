package krx.service.trade;

import java.util.UUID;
import krx.model.Buy;
import krx.model.Sell;
import krx.repository.BuyRepository;
import krx.repository.SellRepository;
import krx.service.AbstractService;
import krx.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService extends AbstractService {
  @Autowired
  SellRepository sellRepository;

  @Autowired
  BuyRepository buyRepository;

  @Autowired
  KafkaService kafkaService;

  /**
   * register sell order.
   * 
   * @param id userid
   * @param price price
   * @param amount amount
   * @return
   */
  public String registerSellOrder(int tokenId, String id, int price, int amount) {
    String orderNum = UUID.randomUUID().toString();

    logger.info("[TS]register sell order >>>>>>>> {}, {}, {}, {}, {}", tokenId, orderNum, id, price,
        amount);

    Sell sellOrder = new Sell();
    sellOrder.setOrderNum(orderNum);
    sellOrder.setId(id);
    sellOrder.setTokenId(tokenId);
    sellOrder.setPrice(price);
    sellOrder.setAmount(amount);
    sellOrder.setLock(true);
    sellRepository.save(sellOrder);

    kafkaService.requestLockToken(sellOrder);
    return orderNum;
  }

  /**
   * register buy order.
   * 
   * @param id id
   * @param price price
   * @param amount amount
   * @return
   */
  public String registerBuyOrder(int tokenId, String id, int price, int amount) {
    String orderNum = UUID.randomUUID().toString();
    logger.info("[TS]register buy order >>>>>>>> {}, {}, {}, {}", orderNum, id, price, amount);

    Buy buyOrder = new Buy();
    buyOrder.setOrderNum(orderNum);
    buyOrder.setId(id);
    buyOrder.setTokenId(tokenId);
    buyOrder.setPrice(price);
    buyOrder.setAmount(amount);
    buyOrder.setLock(true);
    buyRepository.save(buyOrder);

    kafkaService.requestLockAccount(buyOrder);
    return orderNum;
  }

  /**
   * unlock buy order.
   * 
   * @param orderNum order number
   */
  public void unlockBuyOrder(String orderNum) {
    Buy buyOrder = getBuyOrder(orderNum);
    buyOrder.setLock(false);
    buyRepository.save(buyOrder);
  }

  /**
   * unlock sell order.
   * 
   * @param orderNum order number
   */
  public void unlockSellOrder(String orderNum) {
    Sell sellOrder = getSellOrder(orderNum);
    sellOrder.setLock(false);
    sellRepository.save(sellOrder);
  }


  public Buy getBuyOrder(String orderNum) {
    return buyRepository.findById(orderNum).get();
  }

  public Sell getSellOrder(String orderNum) {
    return sellRepository.findById(orderNum).get();
  }
}
