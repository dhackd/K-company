package krx.model;

import lombok.Getter;
import lombok.Setter;

public class Wallet {
  @Setter
  @Getter
  protected int balance;
  
  @Setter
  @Getter
  protected int token;
}
