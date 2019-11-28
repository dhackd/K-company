package krx.blockchain;

public interface BlockChainGateway {

  /**
   * getAllUsers.
   *
   * @Method 설명:getAllUsers
   * @return .
   */
  public String getAllUsers();

  /**
   * getBalance.
   *
   * @Method 설명:getBalance
   * @param custId custId
   * @return .
   */
  public long getBalance(String custId);

  /**
   * getBalance.
   *
   * @Method 설명:getBalance
   * @param custId custId
   * @param object object
   * @return .
   */
  abstract long getBalance(String custId, Object object);

  @Deprecated
  abstract String blockChainWriter(String topic, Integer partitionNumber, String key,
      Object object);
}