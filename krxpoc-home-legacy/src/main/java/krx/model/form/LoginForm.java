package krx.model.form;

import lombok.Getter;
import lombok.Setter;

public class LoginForm {
  @Setter
  @Getter
  protected String id;
  
  @Setter
  @Getter
  protected String sessionId;
}
