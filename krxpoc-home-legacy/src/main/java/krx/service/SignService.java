package krx.service;

import static krx.ConfigurationConstants.CONF_HSM_ENDPOINT;

import io.blocko.bitcoinj.core.Sha256Hash;
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
   * @param userId userId
   * @param ledge ledge to sign
   */
  public String signLedge(String userId, String ledge) {
    String domain = configuration.getAsString(CONF_HSM_ENDPOINT, null);
    String endpoint = domain + "/api/v1/hsm/signatures";
    
    String hashedLedge = Sha256Hash.create(ledge.getBytes()).toString();

    log.info("[SS]sign ledge >>>>>>>> {}, {}, {}", endpoint, userId, ledge);
    log.info("[SS] hash >>>>>>>>>> {}", hashedLedge);
    SignatureForm signatureForm = new SignatureForm();
    signatureForm.setUserId(userId);
    signatureForm.setMessage(hashedLedge);

    ResultForm resultForm = restService.post(endpoint, signatureForm);
    return resultForm.getData().toString();
  }

  public boolean verifySignature(String address, String ledge, String signature) {
    log.info("[SS]verify signature >>>>>>>> {}, {}, {}", address, ledge, signature);
    return ECDSA.verifyMessageSignature(address, ledge, signature);
  }
}