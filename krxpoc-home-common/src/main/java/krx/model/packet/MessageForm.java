package krx.model.packet;

import lombok.Data;

@Data
public class MessageForm {
  protected String globalId;

  protected String channel;
  
  protected String signature;

  protected SmartContractForm smartContractForm;
}
