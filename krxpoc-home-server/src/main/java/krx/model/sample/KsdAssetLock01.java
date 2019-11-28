package krx.model.sample;

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
@Table
@NoArgsConstructor
@Data
public class KsdAssetLock01 {

  @Column(name = "CUSTID")
  protected String custId;

  @Column(name = "QUANTITY")
  protected int quantity;

  @Id
  @Column(name = "ORDER_NUM", unique = true)
  protected String orderNum;

  @Column(name = "CREATED_AT")
  @CreationTimestamp
  protected LocalDateTime createAt;

  @Column(name = "UPDATED_AT")
  @UpdateTimestamp
  protected LocalDateTime updateAt;

}
