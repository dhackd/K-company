package krx.exception;

import lombok.Getter;
import org.springframework.boot.ExitCodeGenerator;

/**
 * Exception when process accidently exited.
 */
@SuppressWarnings("serial")
public class ProcessExitException extends RuntimeException implements ExitCodeGenerator {
  @Getter
  private final int exitCode;

  public ProcessExitException(final int exitCode) {
    this(exitCode, null);
  }

  public ProcessExitException(final int exitCode, final Throwable cause) {
    super(cause);
    this.exitCode = exitCode;
  }
}
