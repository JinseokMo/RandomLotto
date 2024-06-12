package service;

import java.util.List;


import dto.LottoBuyDTO;

public interface LottoBuyServiceITF {
	public void buyLottoNum(LottoBuyDTO buyDTO);
	
	public List<LottoBuyDTO> findByBuyLotto(int loginInfo);
}
