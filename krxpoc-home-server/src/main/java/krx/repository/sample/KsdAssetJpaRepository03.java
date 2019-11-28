package krx.repository.sample;

import krx.model.sample.KsdAsset03;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository03 extends JpaRepository<KsdAsset03, String> {

}
