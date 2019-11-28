package krx.repository;

import krx.model.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Scenario, Integer> {
}
