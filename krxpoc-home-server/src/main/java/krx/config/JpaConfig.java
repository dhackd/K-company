package krx.config;

import krx.model.BankAccount;
import krx.model.BankOrderLock;
import krx.model.KsdAsset;
import krx.model.KsdAssetLock;
import krx.model.User;
import krx.repository.BankAccountJpaRepository;
import krx.repository.BankOrderLockJpaRepository;
import krx.repository.KsdAssetLockJpaRepository;
import krx.repository.UserJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class, User.class, BankAccount.class,
    KsdAsset.class, BankOrderLock.class, KsdAssetLock.class})
@EnableJpaRepositories(basePackageClasses = {UserJpaRepository.class,
    BankAccountJpaRepository.class, BankOrderLockJpaRepository.class,
    KsdAssetLockJpaRepository.class})
@EnableJpaAuditing
public class JpaConfig {

}
