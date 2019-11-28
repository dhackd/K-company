package krx.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import krx.model.packet.MessageForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Worker extends Thread {
  private AtomicInteger atomic = new AtomicInteger(0);
  private SmartContractService smartContractService;
  private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
  private ConcurrentHashMap<String, MessageForm> map = new ConcurrentHashMap<String, MessageForm>();
  
  public Worker(SmartContractService smartContractService) {
    this.smartContractService = smartContractService;
  }

  @Override
  public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      String hash = null;
      try {
        log.info("큐 {}", queue);
        log.info("맵 {}", map);
        hash = queue.take();
        log.info("큐 뽑음 - 해시 {}", hash);
        while (!map.containsKey(hash)) {
        } ;
        queue.remove(hash);
        log.info("after 큐 {}", queue);
        final MessageForm messageForm = map.remove(hash);
        log.info("after 맵 {}", map);
        log.info("다음 단계로 데이터 전달 {}, {}", hash, messageForm);

        smartContractService.execute(messageForm);
        atomic.getAndIncrement();
      } catch (InterruptedException e) {
        //log.info("end.");
      }
    }
  }

  /**
   * Add to queue.
   * 
   * @param hash String
   */
  public synchronized void addHash(String hash) {
    if (queue.contains(hash)) {
      log.info("Hash already exists :: {} ", hash);
      return;
    }
    queue.add(hash);
  }

  /**
   * Add to map.
   * 
   * @param hash String
   * @param messageForm MessageForm
   */
  public synchronized void addMessageForm(String hash, MessageForm messageForm) {
    if (map.containsKey(hash)) {
      log.info("Order already exists :: {}", messageForm);
      return;
    }
    map.put(hash, messageForm);
  }

  public int get() {
    return atomic.get();
  }
}