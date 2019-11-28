package krx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "SCENARIO")
public class Scenario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "NUM")
  int num;

  @Column(name = "TOKEN_NAME")
  String tokenName;

  @Column(name = "TOPIC")
  String topic;

  @Column(name = "GLOBAL_ID")
  String globalId;
}
