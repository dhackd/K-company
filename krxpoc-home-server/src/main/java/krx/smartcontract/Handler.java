package krx.smartcontract;

import krx.model.packet.MessageForm;

public interface Handler {

  /**
   * Handle data for different status.
   *
   * @param messageForm MessageForm
   */
  void handle(MessageForm messageForm);
}
