package dto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class LottoBuyDTO {
	public LottoBuyDTO () {};
	
	public LottoBuyDTO(int buyNo, int userNo, int lottoRound, List<Integer> choiseNo, LocalDate buyDate, 
			String buyType) {
		super();
		this.buyNo = buyNo;
		this.userNo = userNo;
		this.lottoRound = lottoRound;
		this.choiseNo = choiseNo;
		this.buyDate = buyDate;
		this.buyType = buyType;
	}
	int buyNo;
	int userNo;
	int lottoRound;
	List<Integer> choiseNo;
	LocalDate buyDate;
	int buySum;
	String buyType;
	
	public int getBuyNo() {
		return buyNo;
	}
	public void setBuyNo(int buyNo) {
		this.buyNo = buyNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getLottoRound() {
		return lottoRound;
	}
	public void setLottoRound(int lottoRound) {
		this.lottoRound = lottoRound;
	}
	public List<Integer> getChoiseNo() {
		return choiseNo;
	}
	public void setChoiseNo(List<Integer> choiseNo) {
		this.choiseNo = choiseNo;
	}
	public LocalDate getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(LocalDate buyDate) {
		this.buyDate = buyDate;
	}
	public String getBuyType() {
		return buyType;
	}
	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}
	
	@Override
	public String toString() {
		return "LottoBuyDTO [buyNo=" + buyNo + ", userNo=" + userNo + ", lottoRound=" + lottoRound + ", choiseNo="
				+ choiseNo + ", buyDate=" + buyDate + ", buyType=" + buyType + "]";
	}
	
}
