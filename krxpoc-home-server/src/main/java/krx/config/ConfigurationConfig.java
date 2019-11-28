package krx.config;

import static coinstack.util.conf.HierachicalConfiguration.create;

import coinstack.util.conf.EnvironmentConfiguration;
import coinstack.util.conf.SpringPropertyConfiguration;
import coinstack.util.conf.SystemPropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SpringPropertyConfiguration.class)
public class ConfigurationConfig {

  @Autowired
  protected SpringPropertyConfiguration springPropertyConfiguration;

  /**
   * Create configuration object.
   *
   * @return Configuration
   */
  @Bean
  public Object configuration() {
    return create(new EnvironmentConfiguration(), new SystemPropertiesConfiguration(),
        springPropertyConfiguration);
  }

}
