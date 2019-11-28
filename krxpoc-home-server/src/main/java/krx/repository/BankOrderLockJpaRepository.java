package krx.repository;

import krx.model.BankOrderLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankOrderLockJpaRepository extends JpaRepository<BankOrderLock, String> {

}
