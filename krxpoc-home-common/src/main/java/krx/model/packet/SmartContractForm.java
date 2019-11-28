package krx.model.packet;

import lombok.Data;

@Data
public class SmartContractForm {
  protected String signature;

  protected OrderForm orderform;

  protected int orderStatus;

  protected int orderType;

  protected MemberForm memberForm;

  protected int cmdType;

  protected boolean isFacility;
}
