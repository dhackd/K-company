package krx.service.facility;

import static krx.ConfigurationConstants.KAFKA_SERVER_DOMAIN;

import krx.model.ResultForm;
import krx.service.AbstractService;
import krx.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService {

  @Autowired
  RestService restService;

  @Autowired
  protected coinstack.util.Configuration configuration;

  /**
   * check user account balance.
   * 
   * @param id user id
   * @param totalPrice total price to buy
   * @return
   */
  public boolean checkAccounts(String id, long totalPrice) {
    boolean result = false;
    int balance = findAccountBalance(id);
    if (balance > totalPrice) {
      result = true;
    }

    return result;
  }

  /**
   * find user account userId.
   * 
   * @param userId user id
   */
  public int findAccountBalance(String userId) {
    String url = configuration.getAsString(KAFKA_SERVER_DOMAIN, null);
    String endpoint = url + "/api/v1/accounts";
    logger.info("[KS] find user account >>>>>>>> {}, {}", endpoint, userId);

    ResultForm result = restService.get(endpoint + "/" + userId, null);

    int balance;
    if (result.getData().toString() != null) {
      balance = Integer.valueOf(result.getData().toString());
    } else {
      balance = -1;
    }

    return balance;
  }
}
