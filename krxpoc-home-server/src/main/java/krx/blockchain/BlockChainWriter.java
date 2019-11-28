package krx.blockchain;

import coinstack.config.CoinstackClientFactory;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.TransactionBuilder;
import io.blocko.coinstack.TransactionUtil;
import io.blocko.coinstack.exception.CoinStackException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BlockChainWriter {

  private final String fee = "0.0001";
  private final String privateKeyWif = "L1dT3mtrtfn8xb9RQhUjPpLepqrjjxfY7fzTfue167ut1skD1jwq";

  // @Autowired
  // private KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  private CoinstackClientFactory coinstackClientFactory;

  /**
   * send to blockchain.
   * 
   * @Method 설명:send to blockchain
   * @param originalString hashData
   * @throws IOException {@link ExecutionException}
   * @throws CoinStackException {@link ExecutionException}
   */
  protected void insertBlock(String originalString) throws IOException, CoinStackException {
    final CoinStackClient client = coinstackClientFactory.get();
    TransactionBuilder txBuilder = new TransactionBuilder();

    txBuilder.allowDustyOutput(true);
    txBuilder.shuffleOutputs(false);
    txBuilder.setFee(io.blocko.coinstack.Math.convertToSatoshi(fee));
    txBuilder.allowLargePayload(true);
    txBuilder.setData(originalString.getBytes());

    String rawTx = txBuilder.buildTransaction(client, privateKeyWif);
    log.info("===================================================");
    log.info("rawTx = " + rawTx);
    String txId = TransactionUtil.getTransactionHash(rawTx);
    log.info("txId = " + txId);
    log.info("===================================================");

    // 트랜잭션 블록체인에 전송
    log.info("===================================================");
    client.sendTransaction(rawTx);
    log.info("sendTransaction completed");
    log.info("===================================================");
  }
}
