package krx.model;

public enum OrderType {
  BUY(0), SELL(1), NEW(2);

  private int value;

  OrderType(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

}
