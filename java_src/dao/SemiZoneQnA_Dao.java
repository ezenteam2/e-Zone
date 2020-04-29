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
	
	// 형준-내 아이디와, page가 입력되면 내가 세미나 존에 대해 문의한 내역 출력 해당 페이지(10개) 출력
	public ArrayList<SemiZoneQnA> getQnAList(String id, int page){
		ArrayList<SemiZoneQnA> qnaList2 = new ArrayList<SemiZoneQnA>();
		try {
			setCon();
			String Query = "SELECT * FROM (select a.*, rownum rn from p5semiqna a where qna_type ='세미나존' and mem_id=? and rownum<=?) WHERE rn>?";
			pstmt = con.prepareStatement(Query);
			pstmt.setString(1, id);
			pstmt.setInt(2, page*10);
			pstmt.setInt(3, (page-1)*10);
			rs = pstmt.executeQuery();
			SemiZoneQnA semi;
			while(rs.next()) {
				semi = new SemiZoneQnA();
				semi.setQnaCode(rs.getInt(1));
				semi.setQnaType(rs.getString(2));
				semi.setSemiZoneCode(rs.getInt(3));
				semi.setMemId(rs.getString(4));
				semi.setQnaDate(rs.getString(5));
				semi.setQnaContent(rs.getString(6));
				semi.setAdminId(rs.getString(7));
				semi.setQnaAnswContent(rs.getString(8));
				semi.setQnaANswDate(rs.getString(9));
				qnaList2.add(semi);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			System.out.println("getQnAList(String id, int page) 에러");
			System.out.println(e.getMessage());
		}
		
		return qnaList2;
	}
	
	public int getCount(String user) {
		int cnt=0;
		try {
			setCon();
			String sql="SELECT count(*) FROM P5SEMIQNA WHERE qna_type='세미나존' AND mem_id = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			System.out.println("getCount Error");
		}
		return cnt;
	}
}
