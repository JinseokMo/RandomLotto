package method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import dto.LottoBuyDTO;
import service.UserService;

public class AutoBuy {
	Random rand = new Random();
	UserService us = new UserService();
	public AutoBuy() {};
	
	public LottoBuyDTO AutoBuyLotto(int loginInfo, int userNowPoint) {
		LottoBuyDTO buyDTO = new LottoBuyDTO();
		int userPoint  = userNowPoint - 1000;
		boolean tt = true;
		us.lottoMoneyModify(loginInfo, userPoint);
		
		List<Integer> lottoNum = new ArrayList<>();
		int num1 = rand.nextInt(45)+1;
		int num2 = rand.nextInt(45)+1;
		int num3 = rand.nextInt(45)+1;
		int num4 = rand.nextInt(45)+1;
		int num5 = rand.nextInt(45)+1;
		int num6 = rand.nextInt(45)+1;
		lottoNum.add(num1);
		
		while (tt) {
			if(num1 == num2) {
				num2 = rand.nextInt(45)+1;
			}
			else {
				lottoNum.add(num2);
				tt = false;
			}
		}
		tt = true;
		
		while(tt) {
			if(num1 == num3) {
				num3 = rand.nextInt(45)+1;
			}
			else if(num2 == num3) {
				num3 = rand.nextInt(45)+1;
			}
			else {
				lottoNum.add(num3);
				tt = false;
			}
		}
		tt = true;
		
		while(tt){
			if(num1 == num4) {
				num4 = rand.nextInt(45)+1;
			}
			else if(num2 == num4) {
				num4 = rand.nextInt(45)+1;
			}
			
			else if(num3 == num4) {
				num4 = rand.nextInt(45)+1;
			}
			
			else {
				lottoNum.add(num4);
				tt = false;
			}
		}
		tt = true;
		
		while(tt) {
			if(num1 == num5) {
				num5 = rand.nextInt(45)+1;
			}
			else if(num2 == num5) {
				num5 = rand.nextInt(45)+1;
			}
			
			else if(num3 == num5) {
				num5 = rand.nextInt(45)+1;
			}
			
			else if(num4 == num5) {
				num5 = rand.nextInt(45)+1;
			}
			
			else {
				lottoNum.add(num5);
				tt = false;
			}
		}
		tt = true;
		
		while(tt) {
			if(num1 == num6) {
				num6 = rand.nextInt(45)+1;
			}
			else if(num2 == num6) {
				num6 = rand.nextInt(45)+1;
			}
			
			else if(num3 == num6) {
				num6 = rand.nextInt(45)+1;
			}
			
			else if(num4 == num6) {
				num6 = rand.nextInt(45)+1;
			}
			
			else if(num4 == num6) {
				num6 = rand.nextInt(45)+1;
			}
			
			else {
				lottoNum.add(num6);
				tt = false;
			}
		}
		 Collections.sort(lottoNum);
		 System.out.println("내 구매 번호");
		 for(Integer bb : lottoNum) {
			 System.out.print(bb +" ");
		 }
		 System.out.println("");
		 
		 buyDTO.setBuyType("자동");
		 buyDTO.setChoiseNo(lottoNum);
		 buyDTO.setUserNo(loginInfo);

		 
		return buyDTO;	 
	} 
}
