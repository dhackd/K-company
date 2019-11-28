package krx.controller.v1;

import static krx.ConfigurationConstants.AUTH_SERVER_DOMAIN;

import javassist.NotFoundException;
import krx.model.ResultForm;
import krx.service.RestService;
import krx.service.SessionService;
import krx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class V1UserController extends V1AbstractController {

  @Autowired
  UserService userService;

  @Autowired
  RestService postService;

  @Autowired
  SessionService sessionService;

  @Autowired
  protected coinstack.util.Configuration configuration;

  /**
   * user login.
   * 
   * @param id user id
   * @return
   */
  @PostMapping("users")
  public ResultForm signup(String id) throws NotFoundException {
    String domain = configuration.getAsString(AUTH_SERVER_DOMAIN, null);
    String endpoint = domain + "/api/v1/users";

    logger.info("request register user : {}", id);
    ResultForm result = postService.post(endpoint, id);

    return result;
  }
}
