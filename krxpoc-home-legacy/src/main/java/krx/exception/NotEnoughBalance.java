package krx.exception;

public class NotEnoughBalance extends RuntimeException {
  private static final long serialVersionUID = -3176504954164631613L;

  public NotEnoughBalance() {
    super("잔고가 부족합니다.");
  }
}
