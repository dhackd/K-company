package krx.command;

import static org.slf4j.LoggerFactory.getLogger;

import coinstack.util.Configuration;
import coinstack.util.conf.DummyConfiguration;
import com.beust.jcommander.Parameter;
import java.util.ArrayList;
import java.util.List;
import krx.Command;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractCommand implements Command {
  protected final Logger logger = getLogger(getClass());

  @Getter
  @Setter
  @Parameter(description = "Arguments")
  protected List<String> arguments = new ArrayList<>();
  
  @Autowired
  @Getter
  @Setter
  protected Configuration configuration = DummyConfiguration.getInstance();
}
