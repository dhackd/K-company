package krx.service.trade;

import java.util.List;
import java.util.stream.Collectors;

import krx.model.Buy;
import krx.model.Sell;
import krx.repository.BuyRepository;
import krx.repository.SellRepository;
import krx.service.AbstractService;
import krx.service.KafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MatchService extends AbstractService {
  @Autowired
  SellRepository sellRepository;

  @Autowired
  BuyRepository buyRepository;

  @Autowired
  KafkaService kafkaService;

  /**
   * start buy matching.
   * 
   * @param orderNum order number
   * @param price price
   * @param amount amount
   * @return
   */
  public int buyMatch(String orderNum, int price, int amount) {
    int totalPrice;

    List<Sell> sellList = sellRepository.findByPriceLessThanEqual(price).stream()
        .filter(sell -> !sell.isLock()).collect(Collectors.toList());

    if (sellList.size() != 0) {
      logger.info("[MS]start buy matching");

      totalPrice = startBuyOrder(orderNum, price, amount, sellList);
    } else {
      totalPrice = price * amount;
    }

    return -1 * totalPrice;
  }

  /**
   * start sell matching.
   * 
   * @param orderNum order number.
   * @param price price
   * @param amount amount
   */
  public void sellMatch(String orderNum, int price, int amount) {
    List<Buy> buyList = buyRepository.findByPriceGreaterThanEqual(price).stream()
        .filter(buy -> !buy.isLock()).collect(Collectors.toList());

    if (buyList.size() != 0) {
      logger.info("[MS]start sell matching");

      startSellOrder(orderNum, price, amount, buyList);
    }
  }

  private int startBuyOrder(String orderNum, int price, int amount, List<Sell> sellList) {
    logger.info("[MS]matching buy order : {}, {}", price, amount);

    sellList.forEach(s -> {
      // 시연용(갯수, 금액 매칭 될 경우에만 동작)
      if (s.getAmount() == amount && s.getPrice() == price) {
        settleBuyOrder(orderNum, s.getId(), s.getOrderNum());
      }
    });

    return 0;
  }

  private void startSellOrder(String orderNum, int price, int amount, List<Buy> buyList) {
    logger.info("[MS]matching sell order {}, {}", price, amount);

    buyList.forEach(b -> {
      // 시연용(갯수, 금액 매칭 될 경우에만 동작)
      if (b.getAmount() == amount && b.getPrice() == price) {
        settleSellOrder(orderNum, b.getId(), b.getOrderNum());
      }
    });
  }

  private void settleBuyOrder(String orderNum, String targetId, String targetOrderNum) {
    logger.info("[MS]match buy order {}", orderNum, targetOrderNum);

    Buy buyOrder = buyRepository.findById(orderNum).get();
    buyOrder.setLock(true);
    buyRepository.save(buyOrder);
    
    Sell sellOrder = sellRepository.findById(targetOrderNum).get();
    sellOrder.setLock(true);
    sellRepository.save(sellOrder);
    
    kafkaService.requestSettleBuyOrder(buyOrder, targetId, targetOrderNum);
  }

  private void settleSellOrder(String orderNum, String targetId, String targetOrderNum) {
    logger.info("[MS]match sell order {}", orderNum, targetId);

    Sell sellOrder = sellRepository.findById(orderNum).get();
    sellOrder.setLock(true);
    sellRepository.save(sellOrder);

    Buy buyOrder = buyRepository.findById(targetOrderNum).get();
    buyOrder.setLock(true);
    buyRepository.save(buyOrder);
    
    
    kafkaService.requestSettleSellOrder(sellOrder, targetId, targetOrderNum);
  }
}