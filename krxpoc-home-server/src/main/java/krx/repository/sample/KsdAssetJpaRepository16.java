package krx.repository.sample;

import krx.model.sample.KsdAsset16;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository16 extends JpaRepository<KsdAsset16, String> {

}
