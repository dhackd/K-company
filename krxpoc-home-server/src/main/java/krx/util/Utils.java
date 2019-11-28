package krx.util;

import io.blocko.bitcoinj.core.Sha256Hash;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

@Slf4j
public class Utils {

  @DateTimeFormat(pattern = "yyyymmdd")
  private Date date;

  /**
   * return to timestamp.
   * 
   * @Method 설명:return to timestamp
   * @return
   */
  @Deprecated
  public static Timestamp getDate() {
    final Calendar calendar = Calendar.getInstance();
    final Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
    log.debug("currentTimestamp : {}", currentTimestamp);
    return currentTimestamp;
  }

  /**
   * string to sha256.
   * 
   * @Method 설명:string to sha256
   * @param originalString originData
   * @return hash
   */
  public static String sha256hex(String originalString) {
    return Sha256Hash.create(originalString.getBytes()).toString();
  }

  /**
   * return to UniqueKey.
   * 
   * @Method 설명:generator globalIdKey
   * @param srcSysId source systemId
   * @param srcSysCode source systemCode
   * @param dstSysId destination systemId
   * @param dstSysCode destination systemCode
   * @param sequenceNumber order between systems
   * @return
   */
  public static String createGlobalId(String srcSysId, String srcSysCode, String dstSysId,
      String dstSysCode, String sequenceNumber) {
    Date date = new Date();
    SimpleDateFormat sndDateformat = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat sndTimeformat = new SimpleDateFormat("HHmmss");


    StringBuilder sb = new StringBuilder();
    sb.append(leftPad(srcSysId, 4, '0'));
    sb.append(leftPad(srcSysCode, 2, '0'));
    sb.append(leftPad(dstSysId, 4, '0'));
    sb.append(leftPad(dstSysCode, 2, '0'));
    sb.append(sndDateformat.format(date));
    sb.append(sndTimeformat.format(date));
    sb.append("0000");
    sb.append(sequenceNumber);

    return sb.toString();
  }

  /**
   * padding.
   * 
   * @Method 설명:padding
   * @param originalString originalData
   * @param length padding length
   * @param padCharacter padding character
   * @return
   */
  public static String leftPad(String originalString, int length, char padCharacter) {
    String paddedString = originalString;
    while (paddedString.length() < length) {
      paddedString = padCharacter + paddedString;
    }
    return paddedString;
  }
}