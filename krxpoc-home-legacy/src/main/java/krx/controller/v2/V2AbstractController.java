package krx.controller.v2;

import static org.slf4j.LoggerFactory.getLogger;

import krx.model.version.V2ApiController;
import org.slf4j.Logger;

@V2ApiController
public class V2AbstractController {
  protected final Logger logger = getLogger(getClass());
}
