package krx.repository.sample;

import krx.model.sample.KsdAsset06;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository06 extends JpaRepository<KsdAsset06, String> {

}
