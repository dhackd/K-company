package krx.repository.sample;

import krx.model.sample.KsdAssetLock04;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository04 extends JpaRepository<KsdAssetLock04, String> {
}
