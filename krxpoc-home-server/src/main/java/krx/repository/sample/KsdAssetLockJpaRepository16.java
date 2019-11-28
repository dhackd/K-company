package krx.repository.sample;

import krx.model.sample.KsdAssetLock16;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository16 extends JpaRepository<KsdAssetLock16, String> {
}
