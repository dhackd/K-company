package krx.model.form;

import java.util.List;
import krx.model.Buy;
import krx.model.Sell;
import lombok.Getter;
import lombok.Setter;

public class BoardForm {
  @Setter
  @Getter
  List<Sell> sellList;
  
  @Setter
  @Getter
  List<Buy> buyList;
}
