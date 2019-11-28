package krx.repository.sample;

import krx.model.sample.KsdAssetLock08;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository08 extends JpaRepository<KsdAssetLock08, String> {
}
