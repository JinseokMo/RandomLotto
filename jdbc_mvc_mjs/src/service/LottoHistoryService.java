package service;

import dao.LottoHistoryDAO;
import dto.LottoHistoryDTO;

public class LottoHistoryService implements LottoHistoryServiceITF{
	LottoHistoryDAO lhDAO = new LottoHistoryDAO();
	@Override
	public LottoHistoryDTO lottoNoHistory() {
		lhDAO.LottoHistoryNo();
		return null;
	}

}
