package krx.model;

import lombok.Data;

@Data
public class Order {
  protected int tokenId;
  
  protected String orderNum;

  protected int price;

  protected int amount;

  protected String id;

  protected boolean lock;
}