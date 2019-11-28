package krx.service;

import java.util.Optional;
import krx.model.BankAccount;
import krx.model.KsdAsset;
import krx.model.User;
import krx.repository.BankAccountJpaRepository;
import krx.repository.UserJpaRepository;
import krx.repository.sample.KsdAssetJpaRepository01;
import krx.repository.sample.KsdAssetJpaRepository02;
import krx.repository.sample.KsdAssetJpaRepository03;
import krx.repository.sample.KsdAssetJpaRepository04;
import krx.repository.sample.KsdAssetJpaRepository05;
import krx.repository.sample.KsdAssetJpaRepository06;
import krx.repository.sample.KsdAssetJpaRepository07;
import krx.repository.sample.KsdAssetJpaRepository08;
import krx.repository.sample.KsdAssetJpaRepository09;
import krx.repository.sample.KsdAssetJpaRepository10;
import krx.repository.sample.KsdAssetJpaRepository11;
import krx.repository.sample.KsdAssetJpaRepository12;
import krx.repository.sample.KsdAssetJpaRepository13;
import krx.repository.sample.KsdAssetJpaRepository14;
import krx.repository.sample.KsdAssetJpaRepository15;
import krx.repository.sample.KsdAssetJpaRepository16;
import krx.repository.sample.KsdAssetJpaRepository17;
import krx.repository.sample.KsdAssetJpaRepository18;
import krx.repository.sample.KsdAssetJpaRepository19;
import krx.repository.sample.KsdAssetJpaRepository20;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

  @Autowired
  UserJpaRepository userJpaRepository;
  @Autowired
  BankAccountJpaRepository bankAccountJpaRepository;
  @Autowired
  private KsdAssetJpaRepository01 ksdAssetJpaRepository1;
  @Autowired
  private KsdAssetJpaRepository02 ksdAssetJpaRepository2;
  @Autowired
  private KsdAssetJpaRepository03 ksdAssetJpaRepository3;
  @Autowired
  private KsdAssetJpaRepository04 ksdAssetJpaRepository4;
  @Autowired
  private KsdAssetJpaRepository05 ksdAssetJpaRepository5;
  @Autowired
  private KsdAssetJpaRepository06 ksdAssetJpaRepository6;
  @Autowired
  private KsdAssetJpaRepository07 ksdAssetJpaRepository7;
  @Autowired
  private KsdAssetJpaRepository08 ksdAssetJpaRepository8;
  @Autowired
  private KsdAssetJpaRepository09 ksdAssetJpaRepository9;
  @Autowired
  private KsdAssetJpaRepository10 ksdAssetJpaRepository10;
  @Autowired
  private KsdAssetJpaRepository11 ksdAssetJpaRepository11;
  @Autowired
  private KsdAssetJpaRepository12 ksdAssetJpaRepository12;
  @Autowired
  private KsdAssetJpaRepository13 ksdAssetJpaRepository13;
  @Autowired
  private KsdAssetJpaRepository14 ksdAssetJpaRepository14;
  @Autowired
  private KsdAssetJpaRepository15 ksdAssetJpaRepository15;
  @Autowired
  private KsdAssetJpaRepository16 ksdAssetJpaRepository16;
  @Autowired
  private KsdAssetJpaRepository17 ksdAssetJpaRepository17;
  @Autowired
  private KsdAssetJpaRepository18 ksdAssetJpaRepository18;
  @Autowired
  private KsdAssetJpaRepository19 ksdAssetJpaRepository19;
  @Autowired
  private KsdAssetJpaRepository20 ksdAssetJpaRepository20;

  /**
   * register user.
   * 
   * @param userId user id
   * @param address address
   */
  public void registerUser(String userId, String address) {
    log.info("[UC] register user account: {}", userId);

    User user = new User();
    user.setCustId(userId);
    user.setAddr(address);
    userJpaRepository.save(user);
  }

  /**
   * Load user.
   *
   * @param userId user id
   * @return user
   */
  public Optional<User> loadUser(String userId) {
    log.info("[UC] load user account : {}", userId);

    return userJpaRepository.findById(userId);
  }

  /**
   * Update user.
   * 
   * @param userId user id
   * @param address address
   */
  public void updateUser(String userId, String address) {
    log.info("[UC] update user account: {}", userId);

    User user = userJpaRepository.findById(userId).get();
    user.setAddr(address);
    userJpaRepository.save(user);
  }

  public void removeUser(String userId) {
    log.info("[UC] delete user account: {}", userId);
    userJpaRepository.deleteById(userId);
  }

  /**
   * execute smart contract - register bank account state DB.
   * 
   * @param newAccountUserId userId
   * @param initBalance initBalance
   */
  public void registerBankAccount(String newAccountUserId, int initBalance) {
    log.info("[BC] register bank account : {}", newAccountUserId);

    BankAccount user = new BankAccount();
    user.setCustId(newAccountUserId);
    user.setBalance(initBalance);
    bankAccountJpaRepository.save(user);
  }

  /**
   * find token by token id & user id.
   * @param tokenId token id
   * @param userId user id
   * @return
   */
  public Optional<? extends KsdAsset> getToken(String tokenId, String userId) {
    Optional<? extends KsdAsset> token = null;
    switch (tokenId) {
      case "1":
        token = ksdAssetJpaRepository1.findById(userId);
        break;
      case "2":
        token = ksdAssetJpaRepository2.findById(userId);
        break;
      case "3":
        token = ksdAssetJpaRepository3.findById(userId);
        break;
      case "4":
        token = ksdAssetJpaRepository4.findById(userId);
        break;
      case "5":
        token = ksdAssetJpaRepository5.findById(userId);
        break;
      case "6":
        token = ksdAssetJpaRepository6.findById(userId);
        break;
      case "7":
        token = ksdAssetJpaRepository7.findById(userId);
        break;
      case "8":
        token = ksdAssetJpaRepository8.findById(userId);
        break;
      case "9":
        token = ksdAssetJpaRepository9.findById(userId);
        break;
      case "10":
        token = ksdAssetJpaRepository10.findById(userId);
        break;
      case "11":
        token = ksdAssetJpaRepository11.findById(userId);
        break;
      case "12":
        token = ksdAssetJpaRepository12.findById(userId);
        break;
      case "13":
        token = ksdAssetJpaRepository13.findById(userId);
        break;
      case "14":
        token = ksdAssetJpaRepository14.findById(userId);
        break;
      case "15":
        token = ksdAssetJpaRepository15.findById(userId);
        break;
      case "16":
        token = ksdAssetJpaRepository16.findById(userId);
        break;
      case "17":
        token = ksdAssetJpaRepository17.findById(userId);
        break;
      case "18":
        token = ksdAssetJpaRepository18.findById(userId);
        break;
      case "19":
        token = ksdAssetJpaRepository19.findById(userId);
        break;
      case "20":
        token = ksdAssetJpaRepository20.findById(userId);
        break;

      default:
        break;
    }
    return token;
  }

}
