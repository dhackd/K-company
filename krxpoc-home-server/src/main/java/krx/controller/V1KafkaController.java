package krx.controller;

import krx.controller.V1AbstractController;
import krx.model.ResultForm;
import krx.model.packet.MessageForm;
import krx.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class V1KafkaController extends V1AbstractController {
  @Autowired
  KafkaService kafkaService;

//  /**
//   * get ledge info from legacy.
//   * 
//   * @param channel channel name
//   * @param messageForm message format
//   * @return
//   */
//  @PostMapping("channels/{channel}/ledges")
//  public ResultForm getLedgeInfo(@PathVariable String channel,
//      @RequestBody MessageForm messageForm) {
//    log.info("[KC] get ledge: {}, {}", channel, messageForm.getGlobalId());
//
//    kafkaService.sendLedge(messageForm);
//    ResultForm resultFrom = new ResultForm();
//    resultFrom.setSuccess(true);
//    return resultFrom;
//  }
//
//  /**
//   * get member info from user admin.
//   * 
//   * @param messageForm message format
//   * @return
//   */
//  @PostMapping("members")
//  public ResultForm getUserInfo(@RequestBody MessageForm messageForm) {
//    log.info("[KC] get member info: {}",
//        messageForm.getSmartContractForm().getMemberForm().getCustId());
//
//    kafkaService.sendMember(messageForm);
//    ResultForm resultFrom = new ResultForm();
//    resultFrom.setSuccess(true);
//    return resultFrom;
//  }
}
