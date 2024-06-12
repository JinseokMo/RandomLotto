package dto;

import java.sql.Date;
import java.util.Arrays;

public class LottoHistoryDTO {
	int lottoRound;
	int []lottoNum; 
	Date date;
	int money;
	public LottoHistoryDTO() {}
	
	public LottoHistoryDTO(int lottoRound, int[] lottoNum, Date date, int money) {
		super();
		this.lottoRound = lottoRound;
		this.lottoNum = lottoNum;
		this.date = date;
		this.money = money;
	}
	
	public int getLottoRound() {
		return lottoRound;
	}
	public void setLottoRound(int lottoRound) {
		this.lottoRound = lottoRound;
	}
	public int[] getLottoNum() {
		return lottoNum;
	}
	public void setLottoNum(int[] lottoNum) {
		this.lottoNum = lottoNum;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "LottoNoDTO [lottoRound=" + lottoRound + ", lottoNum=" + Arrays.toString(lottoNum) + ", date=" + date
				+ ", money=" + money + "]";
	}
	
	
}
