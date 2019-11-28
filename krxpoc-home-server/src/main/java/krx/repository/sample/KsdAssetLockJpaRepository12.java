package krx.repository.sample;

import krx.model.sample.KsdAssetLock12;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository12 extends JpaRepository<KsdAssetLock12, String> {
}
