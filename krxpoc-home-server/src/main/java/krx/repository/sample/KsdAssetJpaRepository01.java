package krx.repository.sample;

import krx.model.sample.KsdAsset01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository01 extends JpaRepository<KsdAsset01, String> {

}
