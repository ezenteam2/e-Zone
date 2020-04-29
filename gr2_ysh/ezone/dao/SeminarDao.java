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
