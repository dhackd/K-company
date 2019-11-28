package krx.exec;

import static java.util.Arrays.asList;
import static org.slf4j.LoggerFactory.getLogger;

import coinstack.util.conf.EnvironmentConfiguration;
import coinstack.util.conf.HierachicalConfiguration;
import coinstack.util.conf.SpringPropertyConfiguration;
import coinstack.util.conf.SystemPropertiesConfiguration;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander.Builder;
import com.beust.jcommander.ParameterException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import io.blocko.coinstack.exception.MalformedInputException;
import java.io.Closeable;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.List;
import krx.Command;
import krx.exception.ProcessExitException;
import lombok.Getter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackageClasses = SpringPropertyConfiguration.class, useDefaultFilters = false,
    includeFilters = {
        @Filter(type = FilterType.ASSIGNABLE_TYPE, value = SpringPropertyConfiguration.class)})
public abstract class AbstractLauncher<CommandT extends Command> implements ApplicationRunner {
  protected final Logger logger = getLogger(getClass());

  protected void buildCommand() {}

  protected abstract List<Object> getArguments();

  @Autowired
  protected ApplicationContext applicationContext;

  @Autowired
  protected SpringPropertyConfiguration springPropertyConfiguration;

  @Getter
  @Autowired(required = false)
  protected CommandT command;

  @Bean
  public coinstack.util.Configuration configuration() {
    return HierachicalConfiguration.create(new EnvironmentConfiguration(),
        new SystemPropertiesConfiguration(), springPropertyConfiguration);
  }

  protected static Throwable getInitialCause(final Throwable e) {
    Throwable cause = e;
    while (cause.getCause() != null) {
      cause = cause.getCause();
    }
    return cause;
  }

  /**
   * Parsing arguments.
   *
   * @param args arguments
   *
   * @throws ProcessExitException on failure to execute, instruct to exit
   */
  public void run(final ApplicationArguments args) throws Exception {
    try {
      logger.info("Executing {}...", this);

      final List<Object> arguments = getArguments();
      logger.debug("Argument definitions: {}", arguments);

      logger.info("Parsing arguments: {}", asList(args));
      final Builder builder = JCommander.newBuilder();
      arguments.stream().forEach(builder::addObject);
      builder.build().parse(args.getSourceArgs());
      buildCommand();

      final Command command = getCommand();
      command.execute();

      logger.info("Done {}", this);
    } catch (final ParameterException e) {
      System.err.println(e.getMessage());
      throw new ProcessExitException(1, e);
    } catch (final MalformedInputException e) {
      System.err.println(e.getMessage());
      throw new ProcessExitException(1, e);
    } catch (final MismatchedInputException e) {
      System.err.println("Mismatched Input, please check your json key");
      System.err.println("cause: " + e.getMessage());
      throw new ProcessExitException(1, e);
    } catch (final JsonProcessingException e) {
      System.err.println("Malformed JSON Input, please check your json format");
      System.err.println("cause: " + e.getMessage());
      throw new ProcessExitException(1, e);
    } catch (final ConnectException | MalformedURLException | UnknownHostException e) {
      System.err.println("Connection refused. Check server endpoint.");
      throw new ProcessExitException(1, e);
    } catch (final Throwable e) {
      Throwable initialCause = getInitialCause(e);
      System.err.println(initialCause.getMessage());
      e.printStackTrace();
      throw new ProcessExitException(1, e);
    } finally {
      logger.debug("Command: {}", command);
      if (command instanceof Closeable) {
        ((Closeable) command).close();
      } else if (command instanceof AutoCloseable) {
        ((AutoCloseable) command).close();
      }
    }

  }
}
