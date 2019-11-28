package krx.blockchain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import krx.model.User;
import krx.repository.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BlockChainGatewayImpl implements BlockChainGateway {

  @Autowired
  private UserJpaRepository userJpaRepository;

  // @Autowired
  // private BlockChainWriter blockChainWriter;

  private final ObjectMapper mapper = new ObjectMapper();
  private String jsonData;

  /**
   * getAllUsers().
   */
  public String getAllUsers() {
    try {
      List<User> list = userJpaRepository.findAll();
      if (!list.isEmpty()) {
        jsonData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        log.info("user info = " + jsonData);
        return jsonData;
      }
      log.info("No data found");
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * .
   */
  public long getBalance(String custId) {
    Optional<User> user = userJpaRepository.findById(custId);
    log.info("user data -> " + user);

    return 0;
  }

  /**
   * .
   */
  @Override
  public long getBalance(String custId, Object object) {
    // TODO Auto-generated method stub
    return 0;
  }

  /**
   * .
   */
  @Override
  @Deprecated
  public String blockChainWriter(String topic, Integer partitionNumber, String key, Object object) {
    // TODO Auto-generated method stub
    return null;
  }



}