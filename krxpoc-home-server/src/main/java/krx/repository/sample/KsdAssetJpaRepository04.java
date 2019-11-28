package krx.repository.sample;

import krx.model.sample.KsdAsset04;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository04 extends JpaRepository<KsdAsset04, String> {

}
