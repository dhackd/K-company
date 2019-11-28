package krx.exec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"krx.config", "krx.controller", "krx.service", "krx.repository"})
@EntityScan("krx.model.*")
public class HomeLegacyLauncher {
  /**
   * Entry point for Krx Legacy Server.
   *
   * @param args user arguments
   */
  public static void main(final String[] args) {
    final SpringApplication app = new SpringApplication(HomeLegacyLauncher.class);
    app.setLogStartupInfo(false);
    app.run(args);
  }
}
