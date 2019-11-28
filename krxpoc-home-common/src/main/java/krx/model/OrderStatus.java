package krx.model;

public enum OrderStatus {
  LOCK_REQUEST(0), LOCK_RESPONSE(1), SETTLE_ACCOUNT_REQUEST(2), SETTLE_ACCOUNT_RESPONSE(
      3), SETTLE_TOKEN_REQUEST(4), SETTLE_TOKEN_RESPONSE(5);

  private int value;

  OrderStatus(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
