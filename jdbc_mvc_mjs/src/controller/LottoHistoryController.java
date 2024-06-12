package controller;

import dto.LottoHistoryDTO;
import service.LottoHistoryService;

public class LottoHistoryController {
	LottoHistoryService lhs = new LottoHistoryService();
	public LottoHistoryDTO lottoNoHistory() {
		LottoHistoryDTO lhDTO = new LottoHistoryDTO(); 
		lhs.lottoNoHistory();
		return lhDTO;
	}
}
