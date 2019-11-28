package krx.service;

import static krx.ConfigurationConstants.KAFKA_SERVER_DOMAIN;

import krx.model.ResultForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService {

  @Autowired
  RestService restService;

  @Autowired
  protected coinstack.util.Configuration configuration;

  /**
   * get user address.
   * 
   * @param userId userId
   * @return
   */
  public String getUserAddress(String userId) {
    String domain = configuration.getAsString(KAFKA_SERVER_DOMAIN, null);
    String endpoint = domain + "api/v1/users/addresses/" + userId;
    ResultForm resultForm = restService.get(endpoint, null);
    return resultForm.getData().toString();
  }
}
