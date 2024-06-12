package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LottoHistoryDTO;

public class LottoHistoryDAO implements LottoHistoryDAOITF{
	
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbID = "jdbc"; 			
	String dbPassword = "tiger";	
	
	Connection conn = null;			
	PreparedStatement pstmt = null;	
	ResultSet rs = null;
	
	@Override
	public LottoHistoryDTO LottoHistoryNo() {
		String query = "SELECT * FROM lotto_history";
		
		System.out.println("실행");
		try {
			conn = DriverManager.getConnection(dbUrl,dbID,dbPassword);
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "회 : ");
				System.out.print(rs.getInt(2)+ ", ");
				System.out.print(rs.getInt(3)+ ", ");
				System.out.print(rs.getInt(4)+ ", ");
				System.out.print(rs.getInt(5)+ ", ");
				System.out.print(rs.getInt(6)+ ", ");
				System.out.print(rs.getInt(7));
				System.out.println("보너스 번호 : "+ rs.getInt(8));				
				System.out.print("당첨 날짜 : " + rs.getDate(9));
				System.out.println(", 당첨금 : " + rs.getLong(10)+ "원");
				System.out.println();
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
		return null;
	}

}
