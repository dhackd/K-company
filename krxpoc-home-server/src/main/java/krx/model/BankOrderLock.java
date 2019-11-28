package krx.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "BANK_ORDER_LOCK_STATE")
@NoArgsConstructor
@Data
public class BankOrderLock {

  @Column(name = "CUSTID", nullable = false)
  protected String custId;

  @Id
  @Column(name = "ORDER_NUM", nullable = false, unique = true)
  protected String orderNum;

  @Column(name = "PRICE_TOTAL")
  protected int priceTotal;

  @Column(name = "CREATED_AT")
  @CreationTimestamp
  protected LocalDateTime createAt;

  @Column(name = "UPDATED_AT")
  @UpdateTimestamp
  protected LocalDateTime updateAt;
}
