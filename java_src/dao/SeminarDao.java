package ezone.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import ezone.vo.*;	

public class SeminarDao {
	
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
	
	//모든 리스트를 가져오는 메서드!! 카테고리별, 페이지별, 작성자별 메소드는 오버로딩하여 작성 예정
	public ArrayList<Seminar> getList(){
		ArrayList<Seminar> array = new ArrayList<Seminar>();
		try {
			setCon();
			String sql = "select * from P5SEMIBOOK";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				int semiCode=rs.getInt(1);
				String memId=rs.getString(2);
				int zoneCode=rs.getInt(3);
				java.sql.Date semiBookdate = rs.getDate(4);
				String semiTitle=rs.getString(5);
				String semiSubtitle=rs.getString(6);
				java.sql.Date semiDate=rs.getDate(7);
				java.sql.Timestamp semiStimeTmp=rs.getTimestamp(8);
				String semiStime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiStimeTmp.getTime()));
				System.out.println("semiStime:"+semiStime);
				java.sql.Timestamp semiFtimeTmp=rs.getTimestamp(9);
				String semiFtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiFtimeTmp.getTime()));
				System.out.println("semiFtime:"+semiFtime);
				String semiCate = rs.getString(10);
				String semiImg = rs.getString(11);
				String semiDetail = rs.getString(12);
				int semiCapa = rs.getInt(13);
				int semiParno = rs.getInt(14);
				int semiPrice = rs.getInt(15);
				String semiCurr = rs.getString(16);
				String zoneComm = rs.getString(17);
				java.sql.Date zoneCommdate = rs.getDate(18);
				
				Seminar tmp = new Seminar();
				tmp.setSemiCode(semiCode);
				tmp.setMemId(memId);
				tmp.setZoneCode(zoneCode);
				tmp.setSemiBookdate(semiBookdate);
				tmp.setSemiTitle(semiTitle);
				tmp.setSemiSubtitle(semiSubtitle);
				tmp.setSemiDate(semiDate);
				tmp.setSemiStime(semiStime);
				tmp.setSemiFtime(semiFtime);
				tmp.setSemiCate(semiCate);
				tmp.setSemiImg(semiImg);
				tmp.setSemiDetail(semiDetail);
				tmp.setSemiCapa(semiCapa);
				tmp.setSemiParno(semiParno);
				tmp.setSemiPrice(semiPrice);
				tmp.setSemiCurr(semiCurr);
				tmp.setZoneComm(zoneComm);
				tmp.setZoneCommdate(zoneCommdate);
				
				array.add(tmp);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			System.out.println("getList 중 에러발생");
		}
		return array;
	}
	
	//카테고리, 작성자별, 검색어별로 가져오는 리스트
	public ArrayList<Seminar> getList(String keyword, String type){
		ArrayList<Seminar> array = new ArrayList<Seminar>();
		try {
			setCon();
			String sql = "";
			if(type.contentEquals("host")) {
				sql="select * from P5SEMIBOOK where mem_id = ?";
			} else if(type.contentEquals("cate")) {
				sql="select * from P5SEMIBOOK where semi_cate = ?";
			} else if(type.equals("title")){
				sql="select * from p5semibook where semi_title like %?%";
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				int semiCode=rs.getInt(1);
				String memId=rs.getString(2);
				int zoneCode=rs.getInt(3);
				java.sql.Date semiBookdate = rs.getDate(4);
				String semiTitle=rs.getString(5);
				String semiSubtitle=rs.getString(6);
				java.sql.Date semiDate=rs.getDate(7);
				java.sql.Timestamp semiStimeTmp=rs.getTimestamp(8);
				String semiStime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiStimeTmp.getTime()));
				System.out.println("semiStime:"+semiStime);
				java.sql.Timestamp semiFtimeTmp=rs.getTimestamp(9);
				String semiFtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiFtimeTmp.getTime()));
				System.out.println("semiFtime:"+semiFtime);
				String semiCate = rs.getString(10);
				String semiImg = rs.getString(11);
				String semiDetail = rs.getString(12);
				int semiCapa = rs.getInt(13);
				int semiParno = rs.getInt(14);
				int semiPrice = rs.getInt(15);
				String semiCurr = rs.getString(16);
				String zoneComm = rs.getString(17);
				java.sql.Date zoneCommdate = rs.getDate(18);
				
				Seminar tmp = new Seminar();
				tmp.setSemiCode(semiCode);
				tmp.setMemId(memId);
				tmp.setZoneCode(zoneCode);
				tmp.setSemiBookdate(semiBookdate);
				tmp.setSemiTitle(semiTitle);
				tmp.setSemiSubtitle(semiSubtitle);
				tmp.setSemiDate(semiDate);
				tmp.setSemiStime(semiStime);
				tmp.setSemiFtime(semiFtime);
				tmp.setSemiCate(semiCate);
				tmp.setSemiImg(semiImg);
				tmp.setSemiDetail(semiDetail);
				tmp.setSemiCapa(semiCapa);
				tmp.setSemiParno(semiParno);
				tmp.setSemiPrice(semiPrice);
				tmp.setSemiCurr(semiCurr);
				tmp.setZoneComm(zoneComm);
				tmp.setZoneCommdate(zoneCommdate);
				
				array.add(tmp);
				
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			System.out.println("getList 중 에러발생");
		}
		return array;
	}
	
	//페이지별로 가져오는 리스트
		public ArrayList<Seminar> getList(int page){
			ArrayList<Seminar> array = new ArrayList<Seminar>();
			try {
				setCon();
				String sql = "select * from (select rownum, * from P5SEMIBOOK where rownum<=?) where rownum>?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, page*10);
				pstmt.setInt(2, ((page-1)*10)+1);
							
				rs=pstmt.executeQuery();
				while(rs.next()){
					int semiCode=rs.getInt(1);
					String memId=rs.getString(2);
					int zoneCode=rs.getInt(3);
					java.sql.Date semiBookdate = rs.getDate(4);
					String semiTitle=rs.getString(5);
					String semiSubtitle=rs.getString(6);
					java.sql.Date semiDate=rs.getDate(7);
					java.sql.Timestamp semiStimeTmp=rs.getTimestamp(8);
					String semiStime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiStimeTmp.getTime()));
					System.out.println("semiStime:"+semiStime);
					java.sql.Timestamp semiFtimeTmp=rs.getTimestamp(9);
					String semiFtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiFtimeTmp.getTime()));
					System.out.println("semiFtime:"+semiFtime);
					String semiCate = rs.getString(10);
					String semiImg = rs.getString(11);
					String semiDetail = rs.getString(12);
					int semiCapa = rs.getInt(13);
					int semiParno = rs.getInt(14);
					int semiPrice = rs.getInt(15);
					String semiCurr = rs.getString(16);
					String zoneComm = rs.getString(17);
					java.sql.Date zoneCommdate = rs.getDate(18);
					
					Seminar tmp = new Seminar();
					tmp.setSemiCode(semiCode);
					tmp.setMemId(memId);
					tmp.setZoneCode(zoneCode);
					tmp.setSemiBookdate(semiBookdate);
					tmp.setSemiTitle(semiTitle);
					tmp.setSemiSubtitle(semiSubtitle);
					tmp.setSemiDate(semiDate);
					tmp.setSemiStime(semiStime);
					tmp.setSemiFtime(semiFtime);
					tmp.setSemiCate(semiCate);
					tmp.setSemiImg(semiImg);
					tmp.setSemiDetail(semiDetail);
					tmp.setSemiCapa(semiCapa);
					tmp.setSemiParno(semiParno);
					tmp.setSemiPrice(semiPrice);
					tmp.setSemiCurr(semiCurr);
					tmp.setZoneComm(zoneComm);
					tmp.setZoneCommdate(zoneCommdate);
					
					array.add(tmp);
					
				}
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				System.out.println("getList 중 에러발생");
			}
			return array;
		}
		
		public void insertSeminar(Seminar sem) {
			try{
				setCon();
				String sql = "insert into p5semibook values(semi_code_seq.nextval, ?, ?, sysdate, ?,"+
				"?, ?, to_date(?, 'YYYY-MM-DD HH24:MI:SS'), to_date(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, sem.getMemId());
				pstmt.setInt(2, sem.getZoneCode());
				pstmt.setString(3, sem.getSemiTitle());
				pstmt.setString(4, sem.getSemiSubtitle());
				pstmt.setDate(5, sem.getSemiDate());
				pstmt.setString(6, sem.getSemiStime());
				pstmt.setString(7, sem.getSemiFtime());
				pstmt.setString(8, sem.getSemiCate());
				pstmt.setString(9, sem.getSemiImg());
				pstmt.setString(10, sem.getSemiDetail());
				pstmt.setInt(11, sem.getSemiCapa());
				pstmt.setInt(12, sem.getSemiParno());
				pstmt.setInt(13, sem.getSemiPrice());
				pstmt.setString(14, sem.getSemiCurr());
				pstmt.setString(15, sem.getZoneComm());
				pstmt.setDate(16, sem.getZoneCommdate());

				pstmt.executeUpdate();
				con.commit();
				pstmt.close();
				con.close();
			} catch(Exception e){
				System.out.println("insertSeminar Error");
				try{
					con.rollback();
					System.out.println("롤백시도");
				} catch(Exception e2){
					System.out.println("롤백에러");
				}
			}
		}
		
		public boolean deleteSeminar(int code) {
			boolean result=false;
			try{
				setCon();
				String sql = "delete from p5semibook where semi_code = ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, code);
				

				pstmt.executeUpdate();
				con.commit();
				pstmt.close();
				con.close();
				result=true;
			} catch(Exception e){
				System.out.println("deleteSeminar Error");
				try{
					con.rollback();
					System.out.println("롤백시도");
				} catch(Exception e2){
					System.out.println("롤백에러");
				}
			}
			return result;
		}
		
}
