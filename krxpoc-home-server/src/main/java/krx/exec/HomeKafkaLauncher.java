package krx.exec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"krx.config", "krx.controller", "krx.service", "krx.smartcontract",
    "krx.repository", "krx.kafka"})
public class HomeKafkaLauncher {
  /**
   * Entry point for Krx Home Server.
   *
   * @param args user arguments
   */
  public static void main(final String[] args) {
    final SpringApplication app = new SpringApplication(HomeKafkaLauncher.class);
    app.setLogStartupInfo(false);
    app.run(args);
  }
}
