package ezone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ezone.vo.Ht_notice_VO;
import ezone.vo.Ht_qna_VO;

public class Ht_qna_dao {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void setCon() throws SQLException{
		
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info, "scott", "tiger");
		System.out.println("접속 성공");
	}
	
	public ArrayList<Ht_qna_VO> qnaList(Ht_qna_VO sch){
		ArrayList<Ht_qna_VO> qnaList = new ArrayList<Ht_qna_VO>();
		
		try {
			setCon();
			
			String sql = "SELECT * FROM P5QNA ORDER BY QNA_CODE DESC";
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);

			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				qnaList.add(new Ht_qna_VO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDate(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getDate(9),
						rs.getString(10)
						));
			}
			
			rs.close();
			pstmt.close();
			con.close();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return qnaList;
	}
	
	public void insertQna(Ht_qna_VO ins) {
		
		try {
			setCon();
			
			String sql = "INSERT INTO P5QNA VALUES (qna_code_seq.nextval, ?, ?, sysdate, ?, ?, ?, '', '', '') ";
			System.out.println(sql);
			
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
					
			pstmt.setString(1, ins.getQnaCate());	
			pstmt.setString(2, ins.getMemId());	
			pstmt.setString(3, ins.getQnaTitle());	
			pstmt.setString(4, ins.getQnaDetail());	
			pstmt.setString(5, ins.getQnaOpen());	
			
			pstmt.executeUpdate();
			con.commit();
			
			System.out.println("등록 성공");
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
	