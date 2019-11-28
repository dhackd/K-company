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
@Table(name = "BANK_ACCOUNT_STATE")
@NoArgsConstructor
@Data
public class BankAccount {

  @Id
  @Column(name = "CUSTID", length = 30, nullable = false, unique = true)
  protected String custId;

  @Column(name = "BALANCE")
  protected int balance;

  @Column(name = "CREATED_AT")
  @CreationTimestamp
  protected LocalDateTime createAt;

  @Column(name = "UPDATED_AT")
  @UpdateTimestamp
  protected LocalDateTime updateAt;
}