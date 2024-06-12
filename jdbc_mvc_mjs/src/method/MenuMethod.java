package method;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.LottoBuyDTO;
import dto.UserDTO;

public class MenuMethod {
	Scanner sc = new Scanner(System.in);
	AutoBuy ab = new AutoBuy();
	ChoiesNum cn = new ChoiesNum();
	
	public MenuMethod() {
	};
	
	//로그인
	public UserDTO userSignin() {
		UserDTO userDTO = new UserDTO();
		System.out.println("====== 로그인 ======");
		System.out.println("이메일을 입력해 주세요.");
		String userEmail = sc.nextLine();
		System.out.println("비밀번호를 입력해 주세요.");
		String userPW = sc.nextLine();
		
		userDTO.setUserEmail(userEmail);
		userDTO.setUserPW(userPW);
		
		return userDTO;
	}
	
	//로그아웃
	public int userLogOut() {
		System.out.println("로그아웃 합니다.");
		return 0;
	}
	
	//회원가입
	public UserDTO userJoin() {
		UserDTO userDTO = new UserDTO();
		System.out.println("======회원가입======");
		System.out.println("Email을 입력해 주세요.");
		String userEmail = sc.nextLine();
		System.out.println("비밀번호를 입력해 주세요.");
		String userPW = sc.nextLine();
		System.out.println("이름을 입력해 주세요.");
		String userName = sc.nextLine();
		
		userDTO.setUserEmail(userEmail);
		userDTO.setUserPW(userPW);
		userDTO.setUserName(userName);
		
		return userDTO;
	}
	
	// 당첨기준 메뉴얼
	public void lottoMenual() {
		System.out.println("당첨 기준");
		System.out.println("추첨 : 기본번호 6개 및 보너스 번호 1개 총 7개 번호");
		System.out.println("1등 : 6개 기본번호 맞추기 (보너스 번호 제외), 상금 : 총 당첨금 중 4등, 5등 금액을 제외한 금액의 75%");
		System.out.println("2등 : 보너스 번호 포함 6개 맞추기, 상금 : 총 당첨금 중 4등, 5등 금액을 제외한 금액의 12.5%");
		System.out.println("3등 : 보너스 번호 포함 5개 맞추기, 상금 : 총 당첨금 중 4등, 5등 금액을 제외한 금액의 12.5%");
		System.out.println("4등 : 보너스 번호 포함 4개 맞추기, 상금 : 50,000원");
		System.out.println("5등 : 보너스 번호 포함 3개 맞추기, 상금 : 5,000원");
	}
	
	// 내정보
	public void myInfo(UserDTO userDTO) {
		System.out.println("유저 이름 : " + userDTO.getUserName());
		System.out.println("유저 이메일(아이디) : " +userDTO.getUserEmail());
		System.out.println("유저 예치금 : " +userDTO.getUserPoint());
	}
	
	// 종료
	public boolean menuExitMethod() {
		System.out.println("종료합니다. 빠잉~");
		return false;
	}
	
	// 예치금 충전
	public int lottoMoneyUpdate() {
		boolean tt = true;
		System.out.println("충전할 금액을 입력해 주세요.(숫자만, 1000보다 큰 숫자를 입력해 주세요)");
		int plusPoint = sc.nextInt();
		if(plusPoint < 1000) {
			while(tt) {
				System.out.println("1000원 보다 큰 값을 입력해 주세요.");
				System.out.println("충전할 금액을 입력해 주세요.(숫자만, 1000보다 큰 숫자를 입력해 주세요)");
				plusPoint = sc.nextInt();
				if(plusPoint >= 1000) {
					tt = false;
				}
			}
		}
		return plusPoint;
	}
	
	// 로또 구매
	public LottoBuyDTO lottoBuy(int loginInfo, int userNowPoint) {
		LottoBuyDTO buyDTO = new LottoBuyDTO();
		boolean tt = true;
		List<Integer> lottoNumber = new ArrayList<>();
		int userChoies;
		while(tt) {
			System.out.println("===== 로또 구매 =====");
			System.out.println("1. 자동");
			System.out.println("2. 수동");
			System.out.println("===================");
			userChoies = sc.nextInt();
			if(userChoies == 1) {
				tt = false;
				buyDTO = ab.AutoBuyLotto(loginInfo, userNowPoint);
			}
			else if (userChoies == 2) {
				tt = false;
				buyDTO = cn.lottoChoiesNum(loginInfo, userNowPoint);
			}
			else {System.out.println("다시 입력해 주세요");}
		}
		
		return buyDTO;
	}
	
	//구매한 로또 번호 확인
	public void findByBuyLotto(List<LottoBuyDTO> list) {
		for(LottoBuyDTO bb : list) {
			System.out.println("구매 아이디 No : "+ bb.getUserNo());
			System.out.println("구매 방법 : "+ bb.getBuyType());
			System.out.println("구매 회차 : " + bb.getLottoRound());
			System.out.print("구매 번호 : ");
			for(Integer cc : bb.getChoiseNo()) {
				System.out.print(cc + " ");
			}
		}
	}
	
}
