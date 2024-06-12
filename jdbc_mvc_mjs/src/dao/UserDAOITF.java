package dao;

import dto.UserDTO;

public interface UserDAOITF {
	public int UserSignIn(UserDTO userDTO);
	
	public void UserJoin(UserDTO userDTO);
	
	public UserDTO myInfo(int userNo);
	
	public void lottoMoneyUpdate(int userId, int plusPoint);
	
	public void lottoMoneyModify(int userNo, int plusPoint);
}
