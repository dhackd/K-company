package krx.controller;

import static org.slf4j.LoggerFactory.getLogger;

import krx.model.version.V1ApiController;
import org.slf4j.Logger;

@V1ApiController
public class V1AbstractController {
  protected final Logger logger = getLogger(getClass());

}
