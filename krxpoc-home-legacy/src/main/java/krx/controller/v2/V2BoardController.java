package krx.controller.v2;

import krx.model.form.BoardForm;
import krx.service.trade.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class V2BoardController extends V2AbstractController {
  
  @Autowired 
  BoardService boardService;

  @GetMapping("tokens/{tokenId}/boards")
  public BoardForm getRecentOrderList(int count, @PathVariable int tokenId) {
    return boardService.getRecentOrder(count, tokenId);
  }
}
