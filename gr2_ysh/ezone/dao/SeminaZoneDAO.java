package ezone.dao;

import java.sql.*;
import ezone.vo.*;
import java.util.*;

public class SeminaZoneDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	ArrayList<SeminaZone> semiList;
	public void setCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String info="jdbc:oracle:thin:@192.168.4.90:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			System.out.println("Connection완료");
			con.setAutoCommit(false);
		} catch(Exception e) {
			System.out.println("Connection 실패");
		}
	}
	
	public SeminaZone getSeminaZone(int semiCode){
		SeminaZone semizone = new SeminaZone();
		
		try {
			setCon();
			String Query = "select * from p5semizone where sz_code=?";
			System.out.println(semiCode);
			pstmt = con.prepareStatement(Query);
			System.out.println(Query);

			pstmt.setInt(1, semiCode);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				semizone.setZoneCode(rs.getInt(1));
				semizone.setZoneTitle(rs.getString(2));
				semizone.setZoneCapa(rs.getInt(3));
				semizone.setZoneDetail(rs.getString(4));
				semizone.setZonePrice(rs.getInt(5));
				semizone.setZoneIntro(rs.getString(6));
				semizone.setZoneNoctice(rs.getString(7));
				semizone.setZoneRefund(rs.getString(8));
				semizone.setZoneImage(rs.getString(9));

			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return semizone;
	}
	
	public ArrayList<SeminaZone> getMainSemiZone(){
		semiList = new ArrayList<SeminaZone>();
		SeminaZone semi;
		try {
			setCon();
			String Query = "SELECT sz_code, sz_title, sz_capa, sz_img FROM P5semizone pm WHERE ROWNUM <= 4";
			pstmt = con.prepareStatement(Query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				semi = new SeminaZone();
				semi.setZoneCode(rs.getInt(1));
				semi.setZoneTitle(rs.getString(2));
				semi.setZoneCapa(rs.getInt(3));
				semi.setZoneImage(rs.getString(4));
				semiList.add(semi);
				
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return semiList;
	}
	
}
