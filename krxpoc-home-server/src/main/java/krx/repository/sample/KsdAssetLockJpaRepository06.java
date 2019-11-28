package krx.repository.sample;

import krx.model.sample.KsdAssetLock06;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository06 extends JpaRepository<KsdAssetLock06, String> {
}
