package krx.model;

import lombok.Getter;
import lombok.Setter;

public class ResultForm {
  @Setter
  @Getter
  boolean success;

  @Setter
  @Getter
  Object data;
}
