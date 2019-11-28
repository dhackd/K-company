package krx.model;

public enum UserCmdType {
  INSERT(0), UPDEATE(1), DELETE(2);

  private int value;

  UserCmdType(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
