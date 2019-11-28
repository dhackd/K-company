package krx.controller.view;

import javax.servlet.http.HttpServletRequest;
import krx.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
  @Autowired
  SessionService sessionService;

  /**
   * default page.
   * @param req HttpServletRequest
   * @return
   */
  @GetMapping("/")
  public String main(HttpServletRequest req) {
    if (sessionService.checkSession(req.getSession())) {
      return "home/login";
    } else {
      return "home/keys";
    }
  }
}
