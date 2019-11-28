package krx.repository;

import java.util.List;
import krx.model.Buy;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyRepository extends JpaRepository<Buy, String> {
  List<Buy> findByLockEqualsAndTokenIdEquals(Pageable pagable, boolean lock, int tokenId);

  List<Buy> findByPriceGreaterThanEqual(int price);
}
