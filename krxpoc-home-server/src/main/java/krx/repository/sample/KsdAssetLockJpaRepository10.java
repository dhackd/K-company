package krx.repository.sample;

import krx.model.sample.KsdAssetLock10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository10 extends JpaRepository<KsdAssetLock10, String> {
}
