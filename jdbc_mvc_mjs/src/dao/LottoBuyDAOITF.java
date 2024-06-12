package dao;

import java.util.List;

import dto.LottoBuyDTO;

public interface LottoBuyDAOITF {
	public void lottoBuyInsert (LottoBuyDTO buyDTO);
	
	public List<LottoBuyDTO> findByBuyLotto(int loginInfo);
}
