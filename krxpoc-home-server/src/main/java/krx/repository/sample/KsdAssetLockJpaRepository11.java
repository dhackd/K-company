package krx.repository.sample;

import krx.model.sample.KsdAssetLock11;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository11 extends JpaRepository<KsdAssetLock11, String> {
}
