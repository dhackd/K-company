package krx.controller.v1;

import static krx.ConfigurationConstants.TOKEN_COUNT;

import java.util.ArrayList;
import java.util.List;
import krx.model.ResultForm;
import krx.model.Scenario;
import krx.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class V1TokenController extends V1AbstractController {

  @Autowired
  TokenRepository tokenRepository;

  @Autowired
  protected coinstack.util.Configuration configuration;

  /**
   * get token list.
   * @return
   */
  @GetMapping("tokens")
  public ResultForm getTokenList() {
    final int tokenCount = configuration.getAsInt(TOKEN_COUNT, 1);
    List<Scenario> tokenList = new ArrayList<>();

    tokenRepository.findAll().stream().filter(t -> t.getNum() <= tokenCount).forEach(t -> {
      tokenList.add(t);
    });

    ResultForm resultForm = new ResultForm();
    resultForm.setData(tokenList);
    resultForm.setSuccess(true);
    return resultForm;
  }

}
