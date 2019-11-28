package krx.repository.sample;

import krx.model.sample.KsdAssetLock09;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository09 extends JpaRepository<KsdAssetLock09, String> {
}
