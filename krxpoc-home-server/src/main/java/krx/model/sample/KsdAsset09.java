package krx.model.sample;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import krx.model.KsdAsset;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class KsdAsset09 extends KsdAsset {

  @Id
  @Column(name = "CUSTID", length = 30, nullable = false, unique = true)
  protected String custId;

  @Column(name = "QUANTITY")
  protected int quantity;

  @Column(name = "CREATED_AT")
  @CreationTimestamp
  protected LocalDateTime createAt;

  @Column(name = "UPDATED_AT")
  @UpdateTimestamp
  protected LocalDateTime updateAt;
}
