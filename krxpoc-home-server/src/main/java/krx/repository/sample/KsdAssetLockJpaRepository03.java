package krx.repository.sample;

import krx.model.sample.KsdAssetLock03;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository03 extends JpaRepository<KsdAssetLock03, String> {
}
