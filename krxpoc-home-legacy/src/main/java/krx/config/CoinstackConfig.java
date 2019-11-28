package krx.config;

import static coinstack.util.ValidationUtils.assertNotNull;
import static krx.ConfigurationConstants.CONF_COINSTACK_ENDPOINT;
import static krx.ConfigurationConstants.CONF_SERVER_PRIVATEKEYS;
import static org.slf4j.LoggerFactory.getLogger;

import coinstack.config.CoinstackClientFactory;
import coinstack.framework.RepositoryFactory;
import coinstack.fsm.SessionFactory;
import coinstack.fsm.session.ThreadBaseSession;
import java.util.Collection;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoinstackConfig {

  protected final Logger logger = getLogger(getClass());

  @Autowired
  protected coinstack.util.Configuration configuration;

  protected Collection<String> getServerPrivateKeys() {
    return configuration.getAsList(CONF_SERVER_PRIVATEKEYS);
  }

  /**
   * Coinstack repository factory.
   *
   * @return factory for {@link coinstack.fsm.CoinstackRepository}
   */
  @Bean
  public RepositoryFactory repositoryFactory() {
    final RepositoryFactory repositoryFactory = new RepositoryFactory();
    repositoryFactory.setPrivateKeys(getServerPrivateKeys());
    repositoryFactory.setClientFactory(coinstackClientFactory());
    repositoryFactory.initialze();
    return repositoryFactory;
  }

  /**
   * Coinstack session factory.
   *
   * @return factory for {@link coinstack.fsm.Session}
   */
  @Bean
  public SessionFactory sessionFactory() {
    return ThreadBaseSession::createNewSession;
  }

  /**
   * Coinstack client factory.
   *
   * @return factory for {@link io.blocko.coinstack.CoinStackClient}
   */
  @Bean
  public CoinstackClientFactory coinstackClientFactory() {
    final String endpointStr = configuration.getAsString(CONF_COINSTACK_ENDPOINT, null);
    assertNotNull(endpointStr, "No coinstack endpoint.");
    logger.debug("Endpoint: {}", endpointStr);

    final CoinstackClientFactory factory = new CoinstackClientFactory();
    factory.setEndpoint(endpointStr);
    return factory;
  }

}
