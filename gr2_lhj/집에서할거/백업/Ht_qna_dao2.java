package ezone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ezone.vo.Ht_qna_VO;

public class Ht_qna_dao2 {

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
	
		String info = "jdbc:oracle:thin:@192.168.4.19:1521:xe";
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
	
	
	public ArrayList<Ht_qna_VO> qnaList(int page){
		ArrayList<Ht_qna_VO> qnaList = new ArrayList<Ht_qna_VO>();
		
		try {
			setCon();
			
			String sql = "SELECT * FROM (SELECT a.*, rownum rn FROM (SELECT b.* FROM P5QNA b ORDER BY QNA_CODE ASC) a ORDER BY QNA_CODE DESC) WHERE rn>? AND rn<=? ";
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setInt(1, (page-1)*10);
			pstmt.setInt(2, page*10);
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
	
	public int getCnt() {
		
		int cnt=0;
		try {
			setCon();
			
			String sql = "SELECT count(*) cnt FROM P5QNA";
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);

			rs = pstmt.executeQuery();
					
			if(rs.next()) {
				cnt=rs.getInt(1);
			}
			
			rs.close();
			pstmt.close();
			con.close();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public int getCnt(String id) {
			
			int cnt=0;
			try {
				setCon();
				
				String sql = "SELECT count(*) cnt FROM P5QNA where mem_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
	
				rs = pstmt.executeQuery();
						
				if(rs.next()) {
					cnt=rs.getInt(1);
				}
				
				rs.close();
				pstmt.close();
				con.close();
							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return cnt;
		}
	
	public void deleteQna(int qnaCode) {
		
		try {
			setCon();
			
			String sql = "DELETE P5QNA WHERE QNA_CODE = ? ";
			
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qnaCode);
			
			pstmt.executeQuery();
			con.commit();
			
			System.out.println("삭제성공");
			
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
		}
	}
	
	public Ht_qna_VO qnaUptDetail(int qnaCode){

		Ht_qna_VO tmp = null;

		try {
			setCon();
			
			String sql = "SELECT * FROM P5QNA WHERE QNA_CODE = ? ";
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setInt(1, qnaCode);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				tmp=new Ht_qna_VO(
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
						);
			}

			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	public void uptQna(Ht_qna_VO upt) {
		
		try {
			setCon();
			
			String sql = "UPDATE P5QNA SET QNA_TITLE = ?, QNA_DETAIL = ?, QNA_DATE = sysdate WHERE QNA_CODE = ? ";
			
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, upt.getQnaTitle());
			pstmt.setString(2, upt.getQnaDetail());
			pstmt.setInt(3, upt.getQnaCode());
			
			System.out.println(sql);
			
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
			System.out.println("수정 완료");
			
			
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
		}
	}
	
	//마이페이지에서 내가 문의한 것 찾기
	public ArrayList<Ht_qna_VO> qnaList(String id, int page){
		ArrayList<Ht_qna_VO> qnaList = new ArrayList<Ht_qna_VO>();
		
		try {
			setCon();
			
			String sql = "SELECT * FROM (SELECT a.*, rownum rn FROM (SELECT * FROM p5qna WHERE mem_id=? ORDER BY qna_date DESC) a WHERE rownum<=?) WHERE rn>?";
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, page*10);
			pstmt.setInt(3, (page-1)*10);
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
			System.out.println("qnaList 완료");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("qnaList 실패");
			System.out.println(e.getMessage());
		}
		
		return qnaList;
	}
	
	//모바일용
		public ArrayList<Map<String, String>> mobileYong(int page){
			ArrayList<Map<String, String>> qnaList = new ArrayList<Map<String, String>>();
			
			try {
				setCon();
				
				String sql = "SELECT qna_title, qna_date FROM (SELECT a.*, rownum rn FROM (SELECT * FROM p5qna) a WHERE rownum<=?) WHERE rn>?";
				pstmt = con.prepareStatement(sql);
				System.out.println(sql);
				pstmt.setInt(1, page*10);
				pstmt.setInt(2, (page-1)*10);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("date", rs.getString(2));
					map.put("title", rs.getString(1));
					qnaList.add(map);
				}
				rs.close();
				pstmt.close();
				con.close();
				System.out.println("qnaList 완료");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("qnaList 실패");
				System.out.println(e.getMessage());
			}
			
			return qnaList;
		}
		
		public ArrayList<Map<String, String>> mobileYong2(int page){
			ArrayList<Map<String, String>> qnaList = new ArrayList<Map<String, String>>();
			
			try {
				setCon();
				
				String sql = "SELECT sq_detail, sq_date FROM (SELECT a.*, rownum rn FROM (SELECT * FROM p5semiqna) a WHERE rownum<=?) WHERE rn>?";
				pstmt = con.prepareStatement(sql);
				System.out.println(sql);
				pstmt.setInt(1, page*10);
				pstmt.setInt(2, (page-1)*10);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("date", rs.getString(2));
					map.put("title", rs.getString(1));
					qnaList.add(map);
				}
				rs.close();
				pstmt.close();
				con.close();
				System.out.println("qnaList 완료");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("qnaList 실패");
				System.out.println(e.getMessage());
			}
			
			return qnaList;
		}
}
	
