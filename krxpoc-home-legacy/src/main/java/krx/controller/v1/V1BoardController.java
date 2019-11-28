package krx.controller.v1;

import krx.model.form.BoardForm;
import krx.service.trade.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("board")
public class V1BoardController extends V1AbstractController {
  
  @Autowired
  BoardService boardService;

  @Deprecated
  @PostMapping("getList")
  public BoardForm getRecentOrderList(int count, int tokenId) {
    return boardService.getRecentOrder(count, tokenId);
  }
}
