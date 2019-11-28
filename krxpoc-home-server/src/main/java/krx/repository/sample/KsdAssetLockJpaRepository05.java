package krx.repository.sample;

import krx.model.sample.KsdAssetLock05;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository05 extends JpaRepository<KsdAssetLock05, String> {
}
