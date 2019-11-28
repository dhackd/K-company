package krx.service;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class FutureService {
  HashMap<String, CompletableFuture<String>> futureMap = new HashMap<>();
  
  /**
   * create future.
   * @param orderNum order number
   * @return
   */
  public void createFuture(String orderNum) {
    CompletableFuture<String> future = new CompletableFuture<>();
    futureMap.put(orderNum, future);
    
    // start to observer
    Observable<String> source = Observable.from(future);
    source.subscribe();
  }
  
  /**
   * complete future.
   * @param orderNum order number
   */
  public void completeFuture(String orderNum) {
    CompletableFuture<String> future = futureMap.get(orderNum);
    futureMap.remove(orderNum);
    future.complete(orderNum);
  }
}
