package krx.repository.sample;

import krx.model.sample.KsdAsset10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository10 extends JpaRepository<KsdAsset10, String> {

}
