//package krx.service.trade;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import krx.model.Buy;
//import krx.model.Sell;
//import krx.repository.local.BuyRepository;
//import krx.repository.local.SellRepository;
//import krx.service.AbstractService;
//import krx.service.KafkaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MatchService_back extends AbstractService {
//  @Autowired
//  SellRepository sellRepository;
//
//  @Autowired
//  BuyRepository buyRepository;
//
//  @Autowired
//  KafkaService kafkaService;
//
//  /**
//   * start buy matching.
//   * 
//   * @param orderNum order number
//   * @param price price
//   * @param amount amount
//   * @return
//   */
//  public int buyMatch(String orderNum, int price, int amount) {
//    int totalPrice;
//
//    List<Sell> sellList = sellRepository.findByPriceLessThanEqual(price).stream()
//        .filter(sell -> !sell.isLock()).collect(Collectors.toList());
//
//    if (sellList.size() != 0) {
//      logger.info("[MS]start buy matching");
//
//      totalPrice = startBuyOrder(orderNum, price, amount, sellList);
//    } else {
//      totalPrice = price * amount;
//    }
//
//    return -1 * totalPrice;
//  }
//
//  /**
//   * start sell matching.
//   * 
//   * @param orderNum order number.
//   * @param price price
//   * @param amount amount
//   */
//  public void sellMatch(String orderNum, int price, int amount) {
//    List<Buy> buyList = buyRepository.findByPriceGreaterThanEqual(price).stream()
//        .filter(buy -> !buy.isLock()).collect(Collectors.toList());
//
//    if (buyList.size() != 0) {
//      logger.info("[MS]start sell matching");
//
//      startSellOrder(orderNum, price, amount, buyList);
//    }
//  }
//
//  private int startBuyOrder(String orderNum, int price, int amount, List<Sell> sellList) {
//    logger.info("[MS]matching buy order : {}, {}", price, amount);
//
//    // int tempAmount = amount;
//    // int totalPrice = 0;
//    // Iterator<Sell> list = sellList.iterator();
//
//    lockBuyOrder(orderNum, 0, true);
//    lockSellOrder(sellList.get(0).getOrderNum(), false);
//
//    // // trading
//    // while (list.hasNext()) {
//    // Sell sell = list.next();
//    //
//    // // buy amount > sell amount
//    // if (tempAmount > sell.getAmount()) {
//    // lockSellOrder(sell.getOrderNum(), true);
//    // tempAmount = tempAmount - sell.getAmount();
//    // totalPrice += sell.getAmount() * sell.getPrice();
//    // } else {
//    // // buy amount < sell amount
//    // lockBuyOrder(orderNum, totalPrice, true);
//    // lockSellOrder(sell.getOrderNum(), false);
//    // totalPrice += (sell.getAmount() - tempAmount) * sell.getPrice();
//    // break;
//    // }
//    // }
//
//    // 결과 값 갱신
//
//    sellList.stream().forEach(sell -> {
//
//      System.err.println(sell.getPrice() + ", " + sell.getTime());
//    });
//
//    // lock 로직
//    // Sell sell = sellList.get(0);
//    // sell.setLock(true);
//    // sellRepository.save(sell);
//
//    // return totalPrice;
//    return 0;
//  }
//
//  private void startSellOrder(String orderNum, int price, int amount, List<Buy> buyList) {
//    logger.info("[MS]matching sell order {}, {}", price, amount);
//
//
//    lockSellOrder(orderNum, true);
//    lockBuyOrder(buyList.get(0).getOrderNum(), 0, false);
//    // int tempAmount = amount;
//    // Iterator<Buy> list = buyList.iterator();
//    //
//    // // trading
//    // while (list.hasNext()) {
//    // Buy buy = list.next();
//    //
//    // // buy amount > sell amount
//    // if (tempAmount > buy.getAmount()) {
//    // lockBuyOrder(orderNum, 0, true);
//    // tempAmount = tempAmount - buy.getAmount();
//    // } else {
//    // // buy amount < sell amount
//    // lockSellOrder(buy.getOrderNum(), true);
//    // lockSellOrder(buy.getOrderNum(), false);
//    // break;
//    // }
//    // }
//    //
//    // buyList.stream().forEach(buy -> {
//    // System.err.println(buy.getTime());
//    // });
//  }
//
//  private void lockBuyOrder(String orderNum, int amount, boolean lockAll) {
//    logger.info("[MS]lock buy order {}", orderNum);
//    // 완전 소모
//    // if (lockAll) {
//    Buy buyOrder = buyRepository.findById(orderNum).get();
//    buyOrder.setLock(true);
//    buyRepository.save(buyOrder);
//    kafkaService.requestSettleBuyOrder(buyOrder);
//    // }
//
//    // else {
//    //
//    // }
//    // 부분 소모
//  }
//
//  private void lockSellOrder(String orderNum, boolean lockAll) {
//    logger.info("[MS]lock sell order {}", orderNum);
//    // 완전 소모
//    // if (lockAll) {
//    Sell sellOrder = sellRepository.findById(orderNum).get();
//    sellOrder.setLock(true);
//    sellRepository.save(sellOrder);
//    kafkaService.requestSettleSellOrder(sellOrder);
//
//    // 부분 소모
//    // } else {
//    // Sell sellOrder = sellRepository.findById(orderNum).get();
//    // kafkaService.requestSettleAccount(sellOrder);
//    // sellOrder.setLock(true);
//    // sellRepository.save(sellOrder);
//
//  }
//}
