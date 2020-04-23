package ezone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ezone.vo.Ht_faq_VO;

public class Ht_faq_dao {

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
	
	public ArrayList<Ht_faq_VO> faqList(Ht_faq_VO sch){
		
		ArrayList<Ht_faq_VO> faqList = new ArrayList<Ht_faq_VO>();
		
		try {
			setCon();
			
			String sql = "SELECT * FROM P5FAQ ";
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				faqList.add(new Ht_faq_VO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						));
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
					
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return faqList;
		
	}
	
	public ArrayList<Ht_faq_VO> schFaqList(Ht_faq_VO sch) {
		ArrayList<Ht_faq_VO> schFaqList = new ArrayList<Ht_faq_VO>();
		
		try {
			setCon();
			
			String sql = "SELECT * FROM P5FAQ\r\n" + 
					"WHERE \"faq_cate\"=?\r\n" + 
					"AND (\"faq_title\" LIKE '%'||?||'%' OR \"faq_detail\" LIKE '%'||?||'%') ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getFaq_cate());
			pstmt.setString(2, sch.getKeyword());
			pstmt.setString(3, sch.getKeyword());
			System.out.println(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				schFaqList.add(new Ht_faq_VO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						));
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return schFaqList;
	}
	
}
