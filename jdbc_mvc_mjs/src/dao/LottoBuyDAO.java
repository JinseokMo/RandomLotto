package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.LottoBuyDTO;
import dto.LottoHistoryDTO;

public class LottoBuyDAO implements LottoBuyDAOITF{
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbID = "jdbc"; 			
	String dbPassword = "tiger";	
	
	Connection conn = null;			
	PreparedStatement pstmt = null;	
	ResultSet rs = null;
	LocalDate today = LocalDate.now();
	
	@Override
	public void lottoBuyInsert(LottoBuyDTO buyDTO) {
		String query = "INSERT INTO lotto_buy(buyNo, userNo, lottoRound, choiseNo1, choiseNo2, choiseNo3, choiseNo4, choiseNo5, choiseNo6, buyType, buyDate)"
				+ "VALUES ((SELECT NVL(MAX(buyNo)+1, 1) FROM lotto_buy), ?, ?, ?, ?, ? ,? ,? ,? ,?, ?)";
		
		try {
			conn = DriverManager.getConnection(dbUrl,dbID,dbPassword);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, buyDTO.getUserNo()); // userNo
			pstmt.setInt(2, 1124); // lottoRound
			pstmt.setInt(3, buyDTO.getChoiseNo().get(0));
			pstmt.setInt(4, buyDTO.getChoiseNo().get(1));
			pstmt.setInt(5, buyDTO.getChoiseNo().get(2));
			pstmt.setInt(6, buyDTO.getChoiseNo().get(3));
			pstmt.setInt(7, buyDTO.getChoiseNo().get(4));
			pstmt.setInt(8, buyDTO.getChoiseNo().get(5));
			pstmt.setString(9, buyDTO.getBuyType());
			pstmt.setString(10, today.toString());
			pstmt.executeUpdate();
			
			
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

	@Override
	public List<LottoBuyDTO> findByBuyLotto(int loginInfo) {
		String query = "SELECT * FROM lotto_buy WHERE userNo = " + loginInfo;
		LottoBuyDTO buyDTO = new LottoBuyDTO();
		List<LottoBuyDTO> buyList = new ArrayList<>();
		List<Integer> setNo = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(dbUrl,dbID,dbPassword);
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(query);

			while(rs.next()) {
				buyDTO.setUserNo(rs.getInt(2));
				buyDTO.setBuyType(rs.getString(10));
				buyDTO.setLottoRound(rs.getInt(3));
				setNo.add(rs.getInt(4));
				setNo.add(rs.getInt(5));
				setNo.add(rs.getInt(6));
				setNo.add(rs.getInt(7));
				setNo.add(rs.getInt(8));
				setNo.add(rs.getInt(9));
				buyDTO.setChoiseNo(setNo);
				buyList.add(buyDTO);
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
		
		return buyList;
	}
	
	
}
