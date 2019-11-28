package krx.repository.sample;

import krx.model.sample.KsdAssetLock02;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository02 extends JpaRepository<KsdAssetLock02, String> {
}
