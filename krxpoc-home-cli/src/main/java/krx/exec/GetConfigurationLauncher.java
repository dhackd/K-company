package krx.exec;

import static java.lang.System.exit;
import static java.util.Arrays.asList;
import static java.util.Optional.ofNullable;
import static org.springframework.boot.Banner.Mode.OFF;
import static org.springframework.boot.WebApplicationType.NONE;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

import java.util.List;
import krx.command.GetConfiguration;
import krx.exception.ProcessExitException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

@SpringBootConfiguration
@ComponentScan(basePackageClasses = GetConfiguration.class,
    includeFilters = @Filter(type = ASSIGNABLE_TYPE, value = GetConfiguration.class))
public class GetConfigurationLauncher extends AbstractLauncher<GetConfiguration> {

  /**
   * Entry point to start to get configuration value.
   *
   * @param args user arguments
   */
  public static void main(final String[] args) {
    try {
      new SpringApplicationBuilder(GetConfigurationLauncher.class).web(NONE).bannerMode(OFF)
          .run(args);
    } catch (final ProcessExitException e) {
      exit(e.getExitCode());
    }
  }

  @Override
  protected List<Object> getArguments() {
    return asList(command);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    super.run(args);
    System.out
        .println(ofNullable(command.getValue()).orElseThrow(() -> new ProcessExitException(1)));
  }

}
