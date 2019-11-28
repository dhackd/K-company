package krx.repository;

import java.util.List;
import krx.model.Sell;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRepository extends JpaRepository<Sell, String> {
  List<Sell> findByLockEqualsAndTokenIdEquals(Pageable pagable, boolean lock, int tokenId);

  List<Sell> findByPriceLessThanEqual(int price);
}
