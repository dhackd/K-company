package krx.repository.sample;

import krx.model.sample.KsdAssetLock20;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository20 extends JpaRepository<KsdAssetLock20, String> {
}
