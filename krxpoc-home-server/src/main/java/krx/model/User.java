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
@Table(name = "USERS")
@NoArgsConstructor
@Data
public class User {

  @Id
  @Column(name = "CUSTID", unique = true, length = 30, nullable = false)
  protected String custId;

  @Column(name = "ADDR", length = 34, nullable = false)
  protected String addr;

  @Column(name = "CREATED_AT")
  @CreationTimestamp
  protected LocalDateTime createAt;

  @Column(name = "UPDATED_AT")
  @UpdateTimestamp
  protected LocalDateTime updateAt;
}