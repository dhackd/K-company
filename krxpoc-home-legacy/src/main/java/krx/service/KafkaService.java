package krx.service;

import static krx.ConfigurationConstants.KAFKA_CHANNEL_BANK01;
import static krx.ConfigurationConstants.KAFKA_GLOBALID_BANK01;
import static krx.ConfigurationConstants.KAFKA_SERVER_DOMAIN;

import io.blocko.json.JSONObject;
import java.util.concurrent.CompletableFuture;
import krx.model.Buy;
import krx.model.Order;
import krx.model.OrderStatus;
import krx.model.OrderType;
import krx.model.Scenario;
import krx.model.Sell;
import krx.model.packet.MessageForm;
import krx.model.packet.OrderForm;
import krx.model.packet.SmartContractForm;
import krx.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaService extends AbstractService {
  CompletableFuture<String> future;

  @Autowired
  RestService restService;

  @Autowired
  SignService signService;

  @Autowired
  TokenRepository tokenRepository;

  @Autowired
  protected coinstack.util.Configuration configuration;

  /**
   * requst lock account to kafka.
   * 
   * @param buyOrder buyOrder
   */
  public void requestLockAccount(Buy buyOrder) {
    final String globalId = configuration.getAsString(KAFKA_GLOBALID_BANK01, null);
    final String channel = configuration.getAsString(KAFKA_CHANNEL_BANK01, null);

    String endpoint = getEndpoint(channel);
    logger.info("[KS] lock user account >>>>>>>> {}", endpoint, buyOrder.getOrderNum());

    OrderForm orderForm = new OrderForm();
    orderForm.setCustId(buyOrder.getId());
    orderForm.setOrderNum(buyOrder.getOrderNum());
    orderForm.setOrderPrice(buyOrder.getPrice());
    orderForm.setQuantity(buyOrder.getAmount());

    String orderString = new JSONObject(orderForm).toString();
    String userSignature = signService.signLedge(buyOrder.getId(), orderString);

    SmartContractForm smartContractForm = new SmartContractForm();
    smartContractForm.setOrderform(orderForm);
    smartContractForm.setOrderType(OrderType.BUY.getValue());
    smartContractForm.setOrderStatus(OrderStatus.LOCK_REQUEST.getValue());
    smartContractForm.setSignature(userSignature);

    MessageForm messageForm = createMessageForm(channel, globalId, smartContractForm);

    restService.post(endpoint, messageForm);
  }

  /**
   * requst lock token to kafka.
   * 
   * @param sellOrder sellOrder
   */
  public void requestLockToken(Sell sellOrder) {
    Scenario token = tokenRepository.findById(Integer.valueOf(sellOrder.getTokenId())).get();
    final String globalId = token.getGlobalId();
    final String channel = token.getTopic();

    String endpoint = getEndpoint(channel);
    logger.info("[KS] lock user token >>>>>>>> {}, {}", endpoint, sellOrder.getOrderNum());

    OrderForm orderForm = new OrderForm();
    orderForm.setCustId(sellOrder.getId());
    orderForm.setOrderNum(sellOrder.getOrderNum());
    orderForm.setQuantity(sellOrder.getPrice());
    orderForm.setOrderPrice(sellOrder.getAmount());

    String orderString = new JSONObject(orderForm).toString();
    String userSignature = signService.signLedge(sellOrder.getId(), orderString);

    SmartContractForm smartContractForm = new SmartContractForm();
    smartContractForm.setOrderform(orderForm);
    smartContractForm.setOrderType(OrderType.SELL.getValue());
    smartContractForm.setOrderStatus(OrderStatus.LOCK_REQUEST.getValue());
    smartContractForm.setSignature(userSignature);

    MessageForm messageForm = createMessageForm(channel, globalId, smartContractForm);

    restService.post(endpoint, messageForm);
  }

  // 구매 정산
  public void requestSettleBuyOrder(Buy buyOrder, String targetId, String targetOrderNum) {
    requestSettleToken(buyOrder, targetId, targetOrderNum, OrderType.BUY.getValue());
    requestSettleAccount(buyOrder, targetId, targetOrderNum, OrderType.BUY.getValue());
  }

  // 판매 정산
  public void requestSettleSellOrder(Sell sellOrder, String targetId, String targetOrderNum) {
    requestSettleAccount(sellOrder, targetId, targetOrderNum, OrderType.SELL.getValue());
    requestSettleToken(sellOrder, targetId, targetOrderNum, OrderType.SELL.getValue());
  }

  /**
   * request settle account to kafka.
   * 
   * @param sellOrder sell Order
   */
  private void requestSettleAccount(Order sellOrder, String targetId, String targetOrderNum,
      int orderType) {
    final String globalId = configuration.getAsString(KAFKA_GLOBALID_BANK01, null);
    final String channel = configuration.getAsString(KAFKA_CHANNEL_BANK01, null);

    String endpoint = getEndpoint(channel);
    logger.info("[KS] settle user acount >>>>>>>> {}, {}", endpoint, sellOrder.getOrderNum());

    OrderForm orderForm = new OrderForm();
    orderForm.setCustId(sellOrder.getId());
    orderForm.setOrderNum(sellOrder.getOrderNum());
    orderForm.setOrderPrice(sellOrder.getPrice());
    orderForm.setQuantity(sellOrder.getAmount());
    orderForm.setTargetId(targetId);
    orderForm.setTargetOrderNum(targetOrderNum);

    String orderString = new JSONObject(orderForm).toString();
    String userSignature = signService.signLedge(sellOrder.getId(), orderString);

    SmartContractForm smartContractForm = new SmartContractForm();
    smartContractForm.setOrderform(orderForm);
    smartContractForm.setOrderType(orderType);
    smartContractForm.setOrderStatus(OrderStatus.SETTLE_ACCOUNT_REQUEST.getValue());
    smartContractForm.setSignature(userSignature);

    MessageForm messageForm = createMessageForm(channel, globalId, smartContractForm);

    restService.post(endpoint, messageForm);
  }

  /**
   * request settle token to kafka.
   * 
   * @param buyOrder buy order
   */
  private void requestSettleToken(Order buyOrder, String targetId, String targetOrderNum,
      int orderType) {
    Scenario token = tokenRepository.findById(Integer.valueOf(buyOrder.getTokenId())).get();
    final String globalId = token.getGlobalId();
    final String channel = token.getTopic();

    String endpoint = getEndpoint(channel);
    logger.info("[KS] settle user token >>>>>>>> {}, {}", endpoint, buyOrder.getOrderNum());

    OrderForm orderForm = new OrderForm();
    orderForm.setCustId(buyOrder.getId());
    orderForm.setOrderNum(buyOrder.getOrderNum());
    orderForm.setOrderPrice(buyOrder.getPrice());
    orderForm.setQuantity(buyOrder.getAmount());
    orderForm.setTargetId(targetId);
    orderForm.setTargetOrderNum(targetOrderNum);

    String orderString = new JSONObject(orderForm).toString();
    String userSignature = signService.signLedge(buyOrder.getId(), orderString);

    SmartContractForm smartContractForm = new SmartContractForm();
    smartContractForm.setOrderform(orderForm);
    smartContractForm.setOrderType(orderType);
    smartContractForm.setOrderStatus(OrderStatus.SETTLE_TOKEN_REQUEST.getValue());
    smartContractForm.setSignature(userSignature);

    MessageForm messageForm = createMessageForm(channel, globalId, smartContractForm);

    restService.post(endpoint, messageForm);
  }

  private MessageForm createMessageForm(String channel, String globalId,
      SmartContractForm smartContractForm) {
    MessageForm messageForm = new MessageForm();
    messageForm.setChannel(channel);
    messageForm.setGlobalId(globalId);
    messageForm.setSmartContractForm(smartContractForm);

    return messageForm;
  }

  private String getEndpoint(String globalId) {
    String domain = configuration.getAsString(KAFKA_SERVER_DOMAIN, null);
    String apiVersion = "api/v1";

    StringBuffer sb = new StringBuffer();
    sb.append(domain);
    sb.append(apiVersion);
    sb.append("/channels/");
    sb.append(globalId);
    sb.append("/ledges");
    return sb.toString();
  }
}
