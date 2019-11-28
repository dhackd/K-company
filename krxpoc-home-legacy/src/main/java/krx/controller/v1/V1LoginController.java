package krx.controller.v1;

import static krx.ConfigurationConstants.AUTH_SERVER_DOMAIN;

import javassist.NotFoundException;
import javax.servlet.http.HttpServletRequest;
import krx.model.ResultForm;
import krx.model.form.LoginForm;
import krx.service.RestService;
import krx.service.SessionService;
import krx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class V1LoginController extends V1AbstractController {

  @Autowired
  UserService userService;

  @Autowired
  RestService restService;

  @Autowired
  SessionService sessionService;

  @Autowired
  protected coinstack.util.Configuration configuration;

  /**
   * user login.
   * 
   * @param userId userId
   * @return
   */
  @GetMapping("login/{userId}")
  public ResultForm signin(HttpServletRequest request, @PathVariable String userId)
      throws NotFoundException {
    logger.info("[LC]user login >>>>>>>> {}", userId);
    String domain = configuration.getAsString(AUTH_SERVER_DOMAIN, null);
    String endpoint = domain + "/api/v1/auth/addresses/";

    // check database
    logger.info("[LC]check register >>>>>>>> {}", userId);
    String address = userService.getUserAddress(userId);
    if (address != null) {
      logger.info("[LC]check blockchain >>>>>>>> {}", endpoint);
      logger.info("ADDRESS {}", address);

      ResultForm result = restService.get(endpoint + address, null);
      logger.info("result : {}", result);

      if (result.getData() == null) {
        throw new NotFoundException("unregistered user (blockchain)");
      }
    } else {
      throw new NotFoundException("unregistered user (database)");
    }

    String sessionId = sessionService.makeSession(request, userId);

    // login response
    LoginForm loginForm = new LoginForm();
    loginForm.setId(userId);
    loginForm.setSessionId(sessionId);

    ResultForm resultForm = new ResultForm();
    resultForm.setSuccess(true);
    resultForm.setData(loginForm);

    return resultForm;
  }
  
  /**
   * user logout.
   * @param request HttpServletRequest
   * @return
   */
  @GetMapping("logout")
  public ResultForm signin(HttpServletRequest request) {
    logger.info("[LC]user logout >>>>>>>> {}", request.getSession().getId());
    sessionService.removeSession(request);
    
    ResultForm resultForm = new ResultForm();
    resultForm.setSuccess(true);
    return resultForm;
  }
}
