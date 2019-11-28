package krx.repository.sample;

import krx.model.sample.KsdAssetLock07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository07 extends JpaRepository<KsdAssetLock07, String> {
}
