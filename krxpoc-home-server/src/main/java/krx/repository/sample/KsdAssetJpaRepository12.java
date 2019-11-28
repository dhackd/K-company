package krx.repository.sample;

import krx.model.sample.KsdAsset12;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository12 extends JpaRepository<KsdAsset12, String> {

}
