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
			String info="jdbc:oracle:thin:@192.168.4.19:1521:xe";
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
	public ArrayList<Seminar> getList(String type, int page, String user){
		ArrayList<Seminar> array = new ArrayList<Seminar>();
		try {
			setCon();
			String sql = "";
			if(type.contentEquals("host")) {
				sql="select * from (select a.*, rownum rn from P5SEMIBOOK a where mem_id= ? and rownum<=?) where rn>?";
			} else if(type.contentEquals("cate")) {
				sql="select * from P5SEMIBOOK where semi_cate = ?";
			} else if(type.equals("title")){
				sql="select * from p5semibook where semi_title like %?%";
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setInt(2, page*10);
			pstmt.setInt(3, (page-1)*10);
			
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
				System.out.println("getMemId:"+sem.getMemId());
				pstmt.setInt(2, sem.getZoneCode());
				System.out.println("getZoneCode:"+sem.getZoneCode());
				pstmt.setString(3, sem.getSemiTitle());
				System.out.println("getSemiTitle:"+sem.getSemiTitle());
				pstmt.setString(4, sem.getSemiSubtitle());
				System.out.println("getSemiSubtitle:"+sem.getSemiSubtitle());
				pstmt.setDate(5, sem.getSemiDate());
				System.out.println("SemiDate:"+sem.getSemiDate());
				pstmt.setString(6, sem.getSemiStime());
				System.out.println("SemiStime:"+sem.getSemiStime());
				pstmt.setString(7, sem.getSemiFtime());
				System.out.println("SemiFtime:"+sem.getSemiFtime());
				pstmt.setString(8, sem.getSemiCate());
				System.out.println("getSemiCate:"+sem.getSemiCate());
				pstmt.setString(9, "default");
				System.out.println("getSemiImg:"+sem.getSemiImg());
				pstmt.setString(10, sem.getSemiDetail());
				System.out.println("getSemiDetail:"+sem.getSemiDetail());
				pstmt.setInt(11, sem.getSemiCapa());
				System.out.println("getSemiCapa:"+sem.getSemiCapa());
				pstmt.setInt(12, 0);
				pstmt.setInt(13, sem.getSemiPrice());
				System.out.println("getSemiPrice:"+sem.getSemiPrice());
				pstmt.setString(14, "입금대기");
				System.out.println("getSemiCurr:"+sem.getSemiCurr());
				pstmt.setString(15, "");
				pstmt.setDate(16, null);

				pstmt.executeUpdate();
				System.out.println("인서트성공");
				con.commit();
				pstmt.close();
				con.close();
			} catch(Exception e){
				System.out.println("insertSeminar Error");
				System.out.println(e.getMessage());
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
		
		//세미나 상세페이지 정보 불러오는거 - 서희
		public ArrayList<Seminar> getSeminaInfo(int semiCode){
			ArrayList<Seminar> array = new ArrayList<Seminar>();
			try {
				setCon();
				String sql = "SELECT b.semi_code,b.MEM_ID,b.ZONE_CODE,b.SEMI_TITLE,b.SEMI_SUBTITLE,b.SEMI_DATE, b.SEMI_STIME, b.SEMI_FTIME, b.SEMI_CATE, b.semi_img, b.SEMI_DETAIL, b.SEMI_CAPA, b.SEMI_PRICE, sz_title \r\n" + 
							 "FROM P5SEMIBOOK b \r\n" + 
							 "LEFT JOIN P5SEMIZONE z ON b.ZONE_CODE=z.SZ_CODE WHERE b.SEMI_CODE =?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, semiCode);	
				rs=pstmt.executeQuery();
				Seminar seminar = null;
				while(rs.next()){
					seminar = new Seminar();
					seminar.setSemiCode(rs.getInt(1));
					seminar.setMemId(rs.getString(2));
					seminar.setZoneCode(rs.getInt(3));
					seminar.setSemiTitle(rs.getString(4));
					seminar.setSemiSubtitle(rs.getString(5));
					seminar.setSemiDate(rs.getDate(6));
					java.sql.Timestamp semiStimeTmp=rs.getTimestamp(7);
					String semiStime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiStimeTmp.getTime()));
					seminar.setSemiStime(semiStime);
					java.sql.Timestamp semiFtimeTmp=rs.getTimestamp(8);
					String semiFtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiFtimeTmp.getTime()));
					seminar.setSemiFtime(semiFtime);
					seminar.setSemiCate(rs.getString(9));
					seminar.setSemiImg(rs.getString(10));
					seminar.setSemiDetail(rs.getString(11));
					seminar.setSemiCapa(rs.getInt(12));
					seminar.setSemiPrice(rs.getInt(13));
					seminar.setSzTitle(rs.getString(14));
					array.add(seminar);
					
				}
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				System.out.println("getSeminaInfo 중 에러발생");
			}
			return array;
		}
		
		public int getCount(String user) {
			int cnt=0;
			try {
				setCon();
				String sql="select count(*) cnt from p5semibook where mem_id = ?";
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
		
		public ArrayList<String> getTimeTable(String zoneStr, String date){
			int zone=Integer.parseInt(zoneStr);
			ArrayList<String> arr=new ArrayList<String>();
			System.out.println(date);
			System.out.println(zone);
			try {
				setCon();
				String sql = "SELECT * FROM p5semibook WHERE semi_date=to_date(?) AND zone_code = ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, date);
				pstmt.setInt(2, zone);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					java.sql.Timestamp semiStimeTmp=rs.getTimestamp("SEMI_STIME");
					String semiStime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiStimeTmp.getTime()));
					java.sql.Timestamp semiFtimeTmp=rs.getTimestamp("SEMI_FTIME");
					String semiFtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiFtimeTmp.getTime()));
					arr.add(semiStime);
					arr.add(semiFtime);
				}
				System.out.println("getTimeTable 성공");
			} catch (Exception e) {
				System.out.println("getTimeTable Error");
				System.out.println(e.getMessage());
			}
			return arr;
		}
		
}
