package ezone.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				String sql = "SELECT * FROM p5semibook WHERE semi_date=to_date(?) AND zone_code = ? ORDER BY semi_stime asc";
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
		
		//세미나 참여 리스트 가져오기
		public ArrayList<SemiParti> getSeminaReview(String id, int page){
			ArrayList<SemiParti> semiReviewList = new ArrayList<SemiParti>();
			try {
				setCon();
				String sql = "SELECT * FROM (SELECT a.*, rownum rn FROM (SELECT b.parti_code, a.semi_title, b.mem_id, a.semi_date, a.semi_stime, a.semi_ftime, a.semi_img, b.parti_mcnt, b.parti_price, b.parti_curr\r\n" + 
						"FROM p5semibook a, p5semiparti b WHERE a.semi_code = b.SEMI_CODE AND b.mem_id = ?) a WHERE rownum<=?) WHERE rn>?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setInt(2, page*10);
				pstmt.setInt(3, (page-1)*10);
				rs=pstmt.executeQuery();
				SemiParti semiParti = null;
				while(rs.next()){
					
				}
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				System.out.println("getSeminaReview 중 에러발생");
			}
			return semiReviewList;
		}
		
		//서희씨작업물
		//세미나 상세페이지 정보 read - 서희
		public Seminar getSeminaInfo(int semiCode){
			Seminar semina = new Seminar();
			try {
				setCon();
				String sql = "SELECT b.semi_code,b.MEM_ID,b.ZONE_CODE,b.SEMI_TITLE,b.SEMI_SUBTITLE,b.SEMI_DATE, b.SEMI_STIME, b.SEMI_FTIME, b.SEMI_CATE, b.semi_img, b.SEMI_DETAIL, b.SEMI_CAPA, b.SEMI_PRICE, sz_title, b.SEMI_PARNO \r\n" + 
							 "FROM P5SEMIBOOK b \r\n" + 
							 "LEFT JOIN P5SEMIZONE z ON b.ZONE_CODE=z.SZ_CODE WHERE b.SEMI_CODE =?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, semiCode);	
				rs=pstmt.executeQuery();
				semina = null;
				while(rs.next()){
					semina = new Seminar();
					semina.setSemiCode(rs.getInt(1));
					semina.setMemId(rs.getString(2));
					semina.setZoneCode(rs.getInt(3));
					semina.setSemiTitle(rs.getString(4));
				
					semina.setSemiSubtitle(rs.getString(5));
					
					java.sql.Timestamp SemiDateSTmp=rs.getTimestamp(6);
					String SemiDateS=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(SemiDateSTmp.getTime()));
					semina.setSemiDateS(SemiDateS);
					
					java.sql.Timestamp semiStimeTmp=rs.getTimestamp(7);
					String semiStime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiStimeTmp.getTime()));
					semina.setSemiStime(semiStime);
					java.sql.Timestamp semiFtimeTmp=rs.getTimestamp(8);
					String semiFtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(semiFtimeTmp.getTime()));
					semina.setSemiFtime(semiFtime);
					semina.setSemiCate(rs.getString(9));
					semina.setSemiImg(rs.getString(10));
					semina.setSemiDetail(rs.getString(11));
					semina.setSemiCapa(rs.getInt(12));
					semina.setSemiPrice(rs.getInt(13));
					semina.setSzTitle(rs.getString(14));
					semina.setSemiParno(rs.getInt(15));
					
				}
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				System.out.println("getSeminaInfo 중 에러발생");
			}
			return semina;
		}
				
		// 세미나 문의 read - 서희
		public ArrayList<SemiQna> getSeminaQna(int semiCode){
			ArrayList<SemiQna> semiQnaList = new ArrayList<SemiQna>();
			try {
				setCon();
				String sql = "SELECT s.*, m.MEM_NICK, m.MEM_PROF FROM P5SEMIQNA s LEFT JOIN P5MEMBER m ON s.MEM_ID = m.MEM_ID WHERE semi_code = ? order by SQ_DATE desc";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, semiCode);

				rs=pstmt.executeQuery();
				SemiQna semiQna = null;
				while(rs.next()){
					semiQna = new SemiQna();
					semiQna.setSqCode(rs.getInt(1));
					semiQna.setQnatype(rs.getString(2));
					semiQna.setSemiCode(rs.getInt(3));
					semiQna.setMemId(rs.getString(4));

					
					java.sql.Timestamp SqDateTmp=rs.getTimestamp(5);
					String SqDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(SqDateTmp.getTime()));
					semiQna.setSqDate(SqDate);
					
					semiQna.setSqDetail(rs.getString(6));
					semiQna.setQnaAnsId(rs.getString(7));
					semiQna.setSqAnswer(rs.getString(8));

					java.sql.Timestamp QnaAnsdateTmp=rs.getTimestamp(9);

					String QnaAnsdate;
					if(QnaAnsdateTmp==null) {
						QnaAnsdate="1970-01-01 00:00:00";
					} else {
						QnaAnsdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(QnaAnsdateTmp.getTime()));
					}
					
					semiQna.setQnaAnsdate(QnaAnsdate);
					
					semiQna.setMemNick(rs.getString(10));
					semiQna.setMemProf(rs.getString(11));
					semiQnaList.add(semiQna);
				}
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				System.out.println("getSeminaQna 중 에러발생");
			}
			return semiQnaList;
		}
				
// 세미나 이용후기 read -- 서희
		public ArrayList<SemiParti> getSeminaReview(int semiCode){
			ArrayList<SemiParti> semiReviewList = new ArrayList<SemiParti>();
			try {
				setCon();
				String sql = "SELECT p.*, m.MEM_NICK, m.MEM_PROF FROM P5SEMIPARTI p LEFT JOIN P5MEMBER m ON p.MEM_ID = m.MEM_ID WHERE semi_code = ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, semiCode);	
				rs=pstmt.executeQuery();
				SemiParti semiParti = null;
				while(rs.next()){
					semiParti = new SemiParti();
					semiParti.setPartiCode(rs.getInt(1));
					semiParti.setSemiCode(rs.getInt(2));
				
					java.sql.Timestamp PartiBookDateTmp=rs.getTimestamp(9);
					
					String PartiBookDate;
					if(PartiBookDateTmp==null) {
						PartiBookDate="1970-01-01 00:00:00";
					} else {
						PartiBookDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(PartiBookDateTmp.getTime()));
					}
					
					
					semiParti.setPartiBookDate(PartiBookDate);

					semiParti.setMemId(rs.getString(4));
					semiParti.setPartiMcnt(rs.getInt(5));
					semiParti.setPartiPrice(rs.getInt(6));
					semiParti.setPartiCurr(rs.getString(7));
					semiParti.setPartiComm(rs.getString(8));
		
					java.sql.Timestamp PartiCommDateTmp=rs.getTimestamp(9);
					
					String PartiCommDate;
					if(PartiCommDateTmp==null) {
						PartiCommDate="1970-01-01 00:00:00";
					} else {
						PartiCommDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(PartiCommDateTmp.getTime()));
					}
					
					semiParti.setPartiCommDate(PartiCommDate);

					semiParti.setMemNick(rs.getString(10));
					semiParti.setMemProf(rs.getString(11));
					semiReviewList.add(semiParti);
				}
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				System.out.println("getSeminaReview 중 에러발생");
			}
			return semiReviewList;
		}
		// 세미나 참가 예약 insert --서희
		public void insertSemiParti(SemiParti ins) {
			try {
				setCon();
				String sql = "INSERT INTO P5SEMIPARTI values(parti_code_seq.nextval,?,sysdate,?,?,?,'입금대기',NULL,NULL)";
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ins.getSemiCode());
				pstmt.setString(2, ins.getMemId());
				pstmt.setInt(3, ins.getPartiMcnt());
				pstmt.setInt(4, ins.getPartiPrice());
				pstmt.executeUpdate();
				con.commit();
				pstmt.close();
				con.close();
		
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// 세미나 문의 insert
		public void insertSemiQna(SemiQna ins) {
			try {
				setCon();
				String sql = "INSERT INTO P5SEMIQNA values(sq_code_seq.nextval,'세미나',?,?,sysdate,?,NULL,NULL,null)";
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ins.getSemiCode());
				pstmt.setString(2, ins.getMemId());
				pstmt.setString(3, ins.getSqDetail());
				pstmt.executeUpdate();
				con.commit();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("insertSemiQna 중 에러 발생");
			}
		}
		// 세미나 후기 insert
		public void insertReview(SemiParti ins) {
			try {
				setCon();
				String sql = "UPDATE P5SEMIPARTI SET PARTI_COMM=?, PARTI_COMM_DATE=SYSDATE WHERE SEMI_CODE = ? AND MEM_ID = ?";
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ins.getPartiComm());
				pstmt.setInt(2, ins.getSemiCode());
				pstmt.setString(3, ins.getMemId());
				pstmt.executeUpdate();
				con.commit();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("insertReview 중 에러 발생");
			}
		}		
	
		
}
