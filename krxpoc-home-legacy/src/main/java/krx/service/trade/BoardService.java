package krx.service.trade;

import java.util.List;
import krx.model.Buy;
import krx.model.Sell;
import krx.model.form.BoardForm;
import krx.repository.BuyRepository;
import krx.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  @Autowired
  SellRepository sellRepository;

  @Autowired
  BuyRepository buyRepository;

  /**
   * get order data to render.
   * 
   * @param count count to view.
   * @return
   */
  public BoardForm getRecentOrder(int count, int tokenId) {
    PageRequest sellRequest = PageRequest.of(0, count, Direction.DESC, "price");
    List<Sell> sellList =
        sellRepository.findByLockEqualsAndTokenIdEquals(sellRequest, false, tokenId);
    PageRequest buyRequest = PageRequest.of(0, count, Direction.DESC, "price");
    List<Buy> buyList = buyRepository.findByLockEqualsAndTokenIdEquals(buyRequest, false, tokenId);

    BoardForm boardForm = new BoardForm();
    boardForm.setBuyList(buyList);
    boardForm.setSellList(sellList);
    return boardForm;
  }

}
