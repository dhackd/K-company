package krx.service;

import static krx.ConfigurationConstants.CONF_HSM_ENDPOINT;

import io.blocko.coinstack.ECDSA;
import krx.model.ResultForm;
import krx.model.SignatureForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SignService {

  @Autowired
  protected coinstack.util.Configuration configuration;
  @Autowired
  RestService restService;

  /**
   * sign ledge.
   *
   * @param facilityId userId
   * @param ledge ledge to sign
   */
  public String signLedge(String facilityId, String ledge) {
    String domain = configuration.getAsString(CONF_HSM_ENDPOINT, null);
    String endpoint = domain + "/api/v1/hsm/signatures";

    log.info("[SS]sign ledge >>>>>>>> {}, {}", endpoint, facilityId);
    SignatureForm signatureForm = new SignatureForm();
    signatureForm.setUserId(facilityId);
    signatureForm.setMessage(ledge);

    ResultForm resultForm = restService.post(endpoint, signatureForm);
    return resultForm.getData().toString();
  }

  /**
   * verify signature.
   *
   * @param address address
   * @param ledge ledge
   * @param signature signature
   */
  public boolean verifySignature(String address, String ledge, String signature) {
    log.info("[SS]verify signature >>>>>>>> {}, {}, {}", address, ledge, signature);
    return ECDSA.verifyMessageSignature(address, ledge, signature);
  }
}