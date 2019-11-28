package krx.exception;

public class NotEnoughToken extends RuntimeException {
  private static final long serialVersionUID = -6781482508268747405L;

  public NotEnoughToken() {
    super("자산이 부족합니다.");
  }
}
