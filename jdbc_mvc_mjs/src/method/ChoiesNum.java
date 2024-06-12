package method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import dto.LottoBuyDTO;
import service.UserService;

public class ChoiesNum {
	Scanner sc = new Scanner(System.in);
	UserService us = new UserService();
	
	public ChoiesNum () {};
	
	public LottoBuyDTO lottoChoiesNum(int loginInfo, int userNowPoint) {
		LottoBuyDTO buyDTO = new LottoBuyDTO();
		
		int userPoint  = userNowPoint - 1000;
		boolean tt = true;
		us.lottoMoneyModify(loginInfo, userPoint);
		List<Integer> lottoNum = new ArrayList<>();
		
		System.out.println("### 1~45 숫자 중에서 ###");
		System.out.println("### 6개의 숫자를 골라주세요 ###");
		System.out.println("### 중복은 불가능 합니다. ###");
		
		System.out.println("1번쨰 숫자를 입력해 주세요.");
		int num1 = sc.nextInt();
		while(tt) {
			if(num1 >= 1 && num1 <= 45) {
				lottoNum.add(num1);
				tt = false;
			}
			else {
				System.out.println("다시 입력 해주세요");
				num1 = sc.nextInt();
			}
			
		}
		tt = true;
		
		System.out.println("2번째 숫자를 입력해 주세요.");
		int num2 = sc.nextInt();
		while (tt) {
			if(num1 == num2 || num2 > 45 || num2 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				System.out.println("숫자의 범위를 확인해 주세요");
				num2 = sc.nextInt();
			}
			else {
				lottoNum.add(num2);
				tt = false;
			}
		}
		tt = true;
		
		System.out.println("3번째 숫자를 입력해 주세요.");
		int num3 = sc.nextInt();
		while(tt) {
			if(num1 == num3 || num3 > 45 || num3 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num3 = sc.nextInt();
			}
			else if(num2 == num3 || num3 > 45 || num3 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num3 = sc.nextInt();
			}
			else {
				lottoNum.add(num3);
				tt = false;
			}
		}
		tt = true;
		
		System.out.println("4번째 숫자를 입력해 주세요.");
		int num4 = sc.nextInt();
		while(tt){
			if(num1 == num4 || num4 > 45 || num4 < 1 ) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num4 = sc.nextInt();
			}
			else if(num2 == num4 || num4 > 45 || num4 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num4 = sc.nextInt();
			}
			
			else if(num3 == num4 || num4 > 45 || num4 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num4 = sc.nextInt();
			}
			
			else {
				lottoNum.add(num4);
				tt = false;
			}
		}
		tt = true;
		
		System.out.println("5번째 숫자를 입력해 주세요.");
		int num5 = sc.nextInt();
		while(tt) {
			if(num1 == num5 || num5 > 45 || num5 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num5 = sc.nextInt();
			}
			else if(num2 == num5 || num5 > 45 || num5 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num5 = sc.nextInt();
			}
			
			else if(num3 == num5 || num5 > 45 || num5 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num5 = sc.nextInt();
			}
			
			else if(num4 == num5 || num5 > 45 || num5 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num5 = sc.nextInt();
			}
			
			else {
				lottoNum.add(num5);
				tt = false;
			}
		}
		tt = true;
		
		System.out.println("6번째 숫자를 입력해 주세요.");
		int num6 = sc.nextInt();
		while(tt) {
			if(num1 == num6 || num6 > 45 || num6 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num6 = sc.nextInt();
			}
			else if(num2 == num6 || num6 > 45 || num6 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num6 = sc.nextInt();
			}
			
			else if(num3 == num6 || num6 > 45 || num6 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num6 = sc.nextInt();
			}
			
			else if(num4 == num6 || num6 > 45 || num6 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num6 = sc.nextInt();
			}
			
			else if(num4 == num6 || num6 > 45 || num6 < 1) {
				System.out.println("중복된 숫자는 입력이 불가능 합니다.");
				num6 = sc.nextInt();
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
		 
		 buyDTO.setBuyType("수동");
		 buyDTO.setChoiseNo(lottoNum);
		 buyDTO.setUserNo(loginInfo);
		 
		return buyDTO;
	}
}
