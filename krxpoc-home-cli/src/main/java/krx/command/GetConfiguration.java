package krx.command;

import static coinstack.util.ValidationUtils.assertTrue;

import lombok.Getter;

public class GetConfiguration extends AbstractCommand {
  @Getter
  protected String value;

  @Override
  public void execute() throws Throwable {
    assertTrue(1 == arguments.size());
    final String key = arguments.get(0);
    logger.debug("Key: {}", key);
    value = configuration.getAsString(key, null);
  }
}
