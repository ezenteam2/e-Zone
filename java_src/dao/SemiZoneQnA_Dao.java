package ezone.dao;

import java.sql.*;
import java.text.SimpleDateFormat;

import ezone.vo.*;
import java.util.*;
public class SemiZoneQnA_Dao {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	ArrayList<SemiZoneQnA> qnaList;
	public void setCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String info="jdbc:oracle:thin:@192.168.4.19:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			System.out.println("Connection완료");
			con.setAutoCommit(false);
		} catch(Exception e) {
			System.out.println("Connection 실패");
		}
	}
	
	public ArrayList<SemiZoneQnA> getQnAList(int zoneCode){
		qnaList = new ArrayList<SemiZoneQnA>();
		try {
			setCon();
			String Query = "SELECT mem_id, to_char(sq_date, 'yyyy-mm-dd'), sq_detail, qna_ansid, sq_answer, "
					+ "to_char(qna_ansdate,'yyyy-mm-dd') FROM P5SEMIQNA ps \r\n" + 
					"WHERE QNA_TYPE ='세미나존' AND SEMI_CODE = ? AND rownum <= 3 ORDER BY sq_code desc";
			pstmt = con.prepareStatement(Query);
			pstmt.setInt(1, zoneCode);
			rs = pstmt.executeQuery();
			SemiZoneQnA semi;
			while(rs.next()) {
				semi = new SemiZoneQnA();
				semi.setMemId(rs.getString(1));
				semi.setQnaDate(rs.getString(2));
				semi.setQnaContent(rs.getString(3));
				semi.setAdminId(rs.getString(4));
				semi.setQnaAnswContent(rs.getString(5));
				semi.setQnaANswDate(rs.getString(6));
				qnaList.add(semi);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return qnaList;
	}
	
	public void insertZoneQnA(int zoneCode, String user, String Content) {

		try {
			setCon();
			String Query = "INSERT INTO P5SEMIQNA values(sq_code_seq.nextval, '세미나존',?,?,sysdate, ?, NULL, NULL, null)";
			pstmt = con.prepareStatement(Query);
			pstmt.setInt(1,  zoneCode);
			pstmt.setString(2,  user);
			pstmt.setString(3,  Content);
			con.setAutoCommit(false);
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch(Exception el) {
				el.printStackTrace();
			}
		}
		

	}
	
	
}
