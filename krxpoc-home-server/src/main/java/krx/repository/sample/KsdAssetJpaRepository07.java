package krx.repository.sample;

import krx.model.sample.KsdAsset07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository07 extends JpaRepository<KsdAsset07, String> {

}
