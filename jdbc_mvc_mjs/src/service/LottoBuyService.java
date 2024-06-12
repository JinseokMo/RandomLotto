package service;

import java.util.List;

import dao.LottoBuyDAO;
import dto.LottoBuyDTO;

public class LottoBuyService implements LottoBuyServiceITF{
	LottoBuyDTO buyDTO = new LottoBuyDTO();
	LottoBuyDAO buyDAO = new LottoBuyDAO();
	
	@Override
	public void buyLottoNum(LottoBuyDTO buyDTO) {
		buyDAO.lottoBuyInsert(buyDTO);
	}

	@Override
	public List<LottoBuyDTO> findByBuyLotto(int loginInfo) {
		List <LottoBuyDTO> list = buyDAO.findByBuyLotto(loginInfo);
		return list;
	}

}
