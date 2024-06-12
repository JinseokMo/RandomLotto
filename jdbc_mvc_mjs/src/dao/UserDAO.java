package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;

public class UserDAO implements UserDAOITF{
	
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbID = "jdbc"; 			
	String dbPassword = "tiger";	
	
	Connection conn = null;			
	PreparedStatement pstmt = null;	
	ResultSet rs = null;			
	
	//로그인
	@Override
	public int UserSignIn(UserDTO userDTO) {
		String query ="SELECT userNo, userEmail, userPW FROM lotto_user";
		int loginNum = 0;
		try {
			conn = DriverManager.getConnection(dbUrl,dbID,dbPassword);
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(userDTO.getUserEmail().equals(rs.getString(2)) && userDTO.getUserPW().equals(rs.getString(3))) {
					loginNum = rs.getInt(1);
				}
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(loginNum > 0) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
			System.out.println("아이디 및 비밀번호를 확인해 주세요");
		}
		return loginNum;
	}
	
	//회원가입
	@Override
	public void UserJoin(UserDTO userDTO) {
		String query = "INSERT INTO lotto_user(userNo, useremail, userpw, userName, userpoint) "
				+ "VALUES ((SELECT NVL(MAX(userNo)+1, 1) FROM lotto_user), ?, ?, ?, 0)";
		
		try {
			conn = DriverManager.getConnection(dbUrl,dbID,dbPassword);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userDTO.getUserEmail());
			pstmt.setString(2, userDTO.getUserPW());
			pstmt.setString(3, userDTO.getUserName());
			pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				System.out.println("회원가입 완료");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 내정보 조회
	@Override
	public UserDTO myInfo(int userNo) {
		UserDTO userDTO = new UserDTO();
		String query ="SELECT * FROM lotto_user WHERE userNo = " + userNo;
		try {
			conn = DriverManager.getConnection(dbUrl,dbID,dbPassword);
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			userDTO.setUserNo(rs.getInt(1));
			userDTO.setUserEmail(rs.getString(2));
			userDTO.setUserName(rs.getString(4));
			userDTO.setUserPoint(rs.getInt(5));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return userDTO;
	}
	
	//예치금 충전
	@Override
	public void lottoMoneyUpdate(int userNo, int plusPoint) {
		String query ="SELECT * FROM lotto_user WHERE userNo = " + userNo;
		int userPoint = 0;
		try {
			conn = DriverManager.getConnection(dbUrl,dbID,dbPassword);
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				userPoint = rs.getInt(5);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		int sumPoint = userPoint + plusPoint;
		String query2 = "UPDATE lotto_user SET userPoint = ?" + " WHERE userNo = ?"; 
		try {
			conn = DriverManager.getConnection(dbUrl,dbID,dbPassword);
			pstmt = conn.prepareStatement(query2);
			pstmt.setInt(1, sumPoint);
			pstmt.setInt(2, userNo);
			pstmt.executeUpdate();
			
			System.out.println("충전 완료");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void lottoMoneyModify(int userNo, int plusPoint) {
		String query = "UPDATE lotto_user SET userPoint = ?" + " WHERE userNo = ?";
		
		try {
			conn = DriverManager.getConnection(dbUrl,dbID,dbPassword);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, plusPoint);
			pstmt.setInt(2, userNo);
			pstmt.executeUpdate();
			
			System.out.println("구매 완료");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
