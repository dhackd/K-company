package krx.service.facility;

import static krx.ConfigurationConstants.KAFKA_SERVER_DOMAIN;

import krx.model.ResultForm;
import krx.service.AbstractService;
import krx.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService extends AbstractService {

  @Autowired
  RestService restService;

  @Autowired
  protected coinstack.util.Configuration configuration;

  /**
   * check token quantity to sell.
   * 
   * @param id user id
   * @param amount amount
   * @return
   */
  public boolean checkTokens(int tokenId, String id, int amount) {
    boolean result = false;
    int quantity = findTokenQuantity(tokenId, id);
    if (quantity > amount) {
      result = true;
    }
    return result;
  }

  /**
   * find user token.
   * 
   * @param userId suer id
   */
  public int findTokenQuantity(int tokenId, String userId) {
    String url = configuration.getAsString(KAFKA_SERVER_DOMAIN, null);
    String endpoint = url + "/api/v1/tokens/";
    logger.info("[TS] find user token >>>>>>>> {}, {}", endpoint, userId);

    ResultForm result = restService.get(endpoint + tokenId + "/properties/" + userId, null);

    int quantity;
    if (result.getData().toString() != null) {
      quantity = Integer.valueOf(result.getData().toString());
    } else {
      quantity = -1;
    }

    return quantity;
  }
}
