package dto;

public class UserDTO {
	int userNo;
	String userEmail;
	String userPW;
	String userName;
	int userPoint;
	
	public UserDTO() {};
	public UserDTO(int userNo, String userEmail, String userPW, String userName, int userPoint) {
		super();
		this.userNo = userNo;
		this.userEmail = userEmail;
		this.userPW = userPW;
		this.userName = userName;
		this.userPoint = userPoint;
	}
	
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	
	@Override
	public String toString() {
		return "UserDTO [userNo=" + userNo + ", userEmail=" + userEmail + ", userPW=" + userPW + ", userName="
				+ userName + ", userPoint=" + userPoint + "]";
	}
	
	
}
