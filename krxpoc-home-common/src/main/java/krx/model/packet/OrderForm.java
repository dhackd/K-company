package krx.model.packet;

import lombok.Data;

@Data
public class OrderForm {
  protected String orderNum;

  protected String custId;
  
  protected String targetId;
  
  protected String targetOrderNum;

  protected int quantity;

  protected int orderPrice;
}
