package service;

import dao.UserDAO;
import dto.UserDTO;

public class UserService implements UserServiceITF{
	//로그인
	@Override
	public int userSingIn(UserDTO userDTO) {
		UserDAO userDAO = new UserDAO();
		int logInNum = userDAO.UserSignIn(userDTO);
		return logInNum;
	}
	//회원가입
	@Override
	public void userJoin(UserDTO userDTO) {
		UserDAO userDAO = new UserDAO();
		userDAO.UserJoin(userDTO);
	}
	
	// 내정보
	@Override
	public UserDTO myInfo(int userNO) {
		UserDAO userDAO = new UserDAO();
		UserDTO dto = userDAO.myInfo(userNO);
		return dto;
	}
	
	// 예치금 충전
	public void lottoMoneyUpdate(int userNo, int plusPoint) {
		UserDAO userDAO = new UserDAO();
		userDAO.lottoMoneyUpdate(userNo, plusPoint);
		
	}
	
	// 로또 구매 후 예금 수정
	public void lottoMoneyModify(int userNo, int plusPoint) {
		UserDAO userDAO = new UserDAO();
		userDAO.lottoMoneyModify(userNo, plusPoint);
	}

	

}
