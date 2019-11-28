package krx.repository.sample;

import krx.model.sample.KsdAsset05;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository05 extends JpaRepository<KsdAsset05, String> {

}
