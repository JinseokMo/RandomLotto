package service;

import dto.UserDTO;

public interface UserServiceITF {
	
	public void userJoin(UserDTO userDTO);
	
	public int userSingIn(UserDTO userDTO);
	
	public UserDTO myInfo(int userNo);
	
	public void lottoMoneyUpdate(int userNo, int plusPoint);
	
	public void lottoMoneyModify(int userNo, int plusPoint);
}
