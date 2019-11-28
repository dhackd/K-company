package krx.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SessionService extends AbstractService {

  /**
   * make user session.
   * 
   * @param request servlet request
   * @param userid userinfo
   */
  public String makeSession(HttpServletRequest request, String userid) {
    HttpSession session = request.getSession();
    logger.info("session: {}", session.getId());
    session.setAttribute(session.getId(), userid);
    return session.getId();
  }

  public boolean checkSession(HttpSession session) {
    return session.getAttribute(session.getId()) == null;
  }

  /**
   * remove user session.
   * 
   * @param request servlet request
   */
  public void removeSession(HttpServletRequest request) {
    HttpSession session = request.getSession();
    logger.info("remove session : {} ", session.getId());
    session.removeAttribute(session.getId());
  }
}
