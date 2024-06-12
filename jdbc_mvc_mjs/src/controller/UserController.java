package controller;

import dto.UserDTO;
import method.MenuMethod;
import service.UserService;

public class UserController {
	UserService us = new UserService();
	MenuMethod mm = new MenuMethod();
	
	//로그인
	public int userSignin() {
		int a = us.userSingIn(mm.userSignin());
		
		return a;
	}
	
	//회원가입
	public void userJoin() {
		us.userJoin(mm.userJoin());
	}
	
	//내정보
	public int myInfo(int userNo) {
		mm.myInfo(us.myInfo(userNo));
		int a = us.myInfo(userNo).getUserPoint();
		return a;
	}
	
	//예치금 충전
	public void lottoMoneyUpdate(int userNo) {
		us.lottoMoneyUpdate(userNo, mm.lottoMoneyUpdate());
	}
}
