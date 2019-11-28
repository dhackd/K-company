package krx.repository.sample;

import krx.model.sample.KsdAsset08;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KsdAssetJpaRepository08 extends JpaRepository<KsdAsset08, String> {

}
