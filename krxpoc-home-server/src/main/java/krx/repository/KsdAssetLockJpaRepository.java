package krx.repository;

import krx.model.KsdAssetLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetLockJpaRepository extends JpaRepository<KsdAssetLock, String> {
}
