package ezone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import ezone.vo.*;
public class MemberDao {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
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
	public void insertMember(Member m1) {
		try {
			setCon();
			String sql="insert into p5Member values(?, ?, ?, ?, ?, ?, ?, ?, ?, null)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, m1.getMemId());
			pstmt.setString(2, m1.getMemPw());
			pstmt.setString(3, m1.getMemName());
			pstmt.setString(4, m1.getMemEmail());
			pstmt.setString(5, m1.getMemNick());
			pstmt.setString(6, m1.getMemPhone());
			pstmt.setString(7, m1.getMemAddr());
			pstmt.setString(8, m1.getMemCate());
			pstmt.setString(9, m1.getMemProf());
			pstmt.executeUpdate();
			System.out.println("멤버정보 삽입완료");
			con.commit();
			System.out.println("멤버정보 삽입 후 커밋완료");
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("업데이트 도중 예외발생 롤백시도");
			try {
				con.rollback();
				System.out.println("롤백완료");
			} catch (Exception e2) {
				System.out.println("롤백 도중 에러");
			}
		}
	}
	
	public boolean idChk(String id) {
		boolean chk=false;
		try {
			setCon();
			String sql="select * from p5Member where MEM_ID = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			System.out.println("아이디중복체크");
			if(rs.next()) {
				chk=true;
			}
		} catch (Exception e) {
			System.out.println("아이디중복체크에러");
		}
		
		return  chk;
	}
}
