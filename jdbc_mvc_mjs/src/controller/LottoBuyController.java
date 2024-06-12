package controller;

import java.util.ArrayList;
import java.util.List;

import dto.LottoBuyDTO;
import method.MenuMethod;
import service.LottoBuyService;

public class LottoBuyController {
	MenuMethod mm = new MenuMethod();
	LottoBuyDTO buyDTO = new LottoBuyDTO();
	LottoBuyService ls = new LottoBuyService();
	
	public void lottoBuy(int loginInfo, int userNowPoint) {
		List<Integer> buyLotto = new ArrayList<>();
		buyDTO = mm.lottoBuy(loginInfo, userNowPoint);
		
		ls.buyLottoNum(buyDTO);
		
	}
	
	public void findByBuyLotto(int loginInfo) {
		mm.findByBuyLotto(ls.findByBuyLotto(loginInfo));
	}
}
