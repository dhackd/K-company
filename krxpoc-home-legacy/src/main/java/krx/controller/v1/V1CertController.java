package krx.controller.v1;

import static krx.ConfigurationConstants.AUTH_SERVER_DOMAIN;

import krx.model.ResultForm;
import krx.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class V1CertController extends V1AbstractController {

  @Autowired
  RestService restService;

  @Autowired
  protected coinstack.util.Configuration configuration;

  /**
   * get user certification.
   * 
   * @param userId user id
   * @return
   */
  @GetMapping("certifications/{userId}")
  public ResultForm getUserCert(@PathVariable String userId) {
    logger.info("[CC]request now certification >>>>>>>> {}", userId);
    String domain = configuration.getAsString(AUTH_SERVER_DOMAIN, null);
    String endpoint = domain + "/api/v1/certifications/";

    return restService.get(endpoint + userId, null);
  }

  /**
   * update user certification.
   * 
   * @param userId user Id
   * @return
   */
  @PatchMapping("certifications/{userId}")
  public ResultForm updateUserCert(@PathVariable String userId) {
    logger.info("[CC]request update certification >>>>>>>> {}", userId);
    String domain = configuration.getAsString(AUTH_SERVER_DOMAIN, null);
    String endpoint = domain + "/api/v1/certifications/";

    return restService.patch(endpoint + userId, userId);
  }

  // @DeleteMapping("certifications/{userId}")
  // public ResultForm deleteUserCert(@PathVariable String userId) {
  // logger.info("[CC]request delete certification >>>>>>>> {}", userId);
  // String domain = configuration.getAsString(AUTH_SERVER_DOMAIN, null);
  // String endpoint = domain + "/api/v1/certifications/";
  //
  // restService.delete(endpoint + userId);
  //
  // ResultForm resultForm = new ResultForm();
  // resultForm.setSuccess(true);
  // return resultForm;
  // }
}
