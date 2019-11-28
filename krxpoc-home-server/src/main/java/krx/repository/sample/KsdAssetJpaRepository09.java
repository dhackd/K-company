package krx.repository.sample;

import krx.model.sample.KsdAsset09;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository09 extends JpaRepository<KsdAsset09, String> {

}
