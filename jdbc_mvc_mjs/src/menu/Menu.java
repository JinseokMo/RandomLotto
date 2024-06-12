package menu;

import java.util.Scanner;

import controller.LottoBuyController;
import controller.LottoHistoryController;
import controller.UserController;
import method.MenuMethod;

public class Menu {
	
	public void menuChoise() {	
		int loginInfo = 0;
		int userNowPoint = 0;
		boolean start = true;
		
		MenuMethod mm = new MenuMethod();
		UserController uc = new UserController();
		LottoHistoryController lc = new LottoHistoryController();
		LottoBuyController lbc = new LottoBuyController();
		Scanner sc = new Scanner(System.in);
		
		
		while(start) {
			if(loginInfo > 0) {
				System.out.println("★=========== 동행복권 ===========★");
				System.out.println("메뉴를 선택해 주세요.");
				System.out.println("1. 내 정보");
				System.out.println("2. 로또 구매");
				System.out.println("3. 내 구매 내역");
				System.out.println("4. 이번주 당첨번호 확인");
				System.out.println("5. 로또 당첨 기준 메뉴얼");
				System.out.println("6. 예치금 충전");
				System.out.println("7. 로그아웃");
				System.out.println("★==============================★");
				
				int userMenuChoise = sc.nextInt();
				
				switch(userMenuChoise) {
				case 1 : userNowPoint = uc.myInfo(loginInfo);
					break;
				case 2 : {
					if(userNowPoint >= 1000) {
						lbc.lottoBuy(loginInfo, userNowPoint);
					}
					else {System.out.println("1000원 이상의 예치금이 있어야 합니다.");}
				}
					break;
				case 3 : lbc.findByBuyLotto(loginInfo);
					break;
				case 4 : 
					break;
				case 5 : mm.lottoMenual();
					break;
				case 6 : uc.lottoMoneyUpdate(loginInfo);
					break;
				case 7 : loginInfo = mm.userLogOut();
					break;
				}
			}
			else {
				System.out.println("★=========== 동행복권 ===========★");
				System.out.println("메뉴를 선택해 주세요.");
				System.out.println("1. 로그인");
				System.out.println("2. 역대 당첨번호 확인");
				System.out.println("3. 로또 당첨 기준 메뉴얼");
				System.out.println("4. 회원가입");
				System.out.println("5. 종료");
				System.out.println("★==============================★");
				
				int userMenuChoise = sc.nextInt();
				
				switch(userMenuChoise) {
				case 1 : loginInfo = uc.userSignin();
					break;
				case 2 : lc.lottoNoHistory();
					break;
				case 3 : mm.lottoMenual();
					break;
				case 4 : uc.userJoin();
					break;
				case 5 : start = mm.menuExitMethod();
					break;
				}
				
			}
	
		}
	}
}
