package krx.repository.sample;

import krx.model.sample.KsdAsset02;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository02 extends JpaRepository<KsdAsset02, String> {

}
