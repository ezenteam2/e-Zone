package ezone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ezone.vo.Ht_notice_VO;

public class Ht_notice_dao{

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
	
	public ArrayList<Ht_notice_VO> noticeList(Ht_notice_VO sch){
		ArrayList<Ht_notice_VO> notiList = new ArrayList<Ht_notice_VO>();
		
		try {
			setCon();
			
			String sql = "SELECT * FROM P5NOTICE";
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);

			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				notiList.add(new Ht_notice_VO(
						rs.getInt(1),
						rs.getString(2),
						rs.getDate(3),
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
		
		
		return notiList;
		
	}
	
}
