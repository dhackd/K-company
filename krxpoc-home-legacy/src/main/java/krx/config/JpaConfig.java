package krx.config;

import krx.model.Buy;
import krx.model.Scenario;
import krx.model.Sell;
import krx.repository.BuyRepository;
import krx.repository.SellRepository;
import krx.repository.TokenRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class, Buy.class, Sell.class, Scenario.class})
@EnableJpaRepositories(
    basePackageClasses = {BuyRepository.class, SellRepository.class, TokenRepository.class})
@EnableJpaAuditing
public class JpaConfig {

}
