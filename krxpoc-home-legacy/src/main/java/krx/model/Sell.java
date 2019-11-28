package krx.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "SELL")
public class Sell extends Order {
  @Id
  @Column(name = "ORDERNUM")
  protected String orderNum;
  
  @Column(name = "TOKEN_ID")
  protected int tokenId;

  @Column(name = "PRICE")
  protected int price;

  @Column(name = "AMOUNT")
  protected int amount;

  @Column(name = "ID")
  protected String id;

  @Column(name = "LOCK")
  protected boolean lock;

  @CreationTimestamp
  @Column(name = "CREATED_AT")
  protected Timestamp time;
}
