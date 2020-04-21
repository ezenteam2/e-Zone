package ezone.vo;

import java.sql.Date;

public class SemiQna {
	private int sqCode; // 세미나 문의 코드
	private String qnatype; // 문의 종류
	private int semiCode; // 세미나 코드
	private String memId; // 문의자 아이디
	private Date sqDate; // 문의 날짜
	private String sqDetail; // 문의 내용
	private String qnaAnsId; // 답변자 아이디
	private String sqAnswer; // 답변 내용
	private Date qnaAnsdate; // 답변 날짜
	private String memNick; // 문의자 닉네임
	private String memProf; // 문의자 프로필 이미지
	
	public SemiQna() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SemiQna(int sqCode, String qnatype, int semiCode, String memId, Date sqDate, String sqDetail,
			String qnaAnsId, String sqAnswer, Date qnaAnsdate, String memNick, String memProf) {
		super();
		this.sqCode = sqCode;
		this.qnatype = qnatype;
		this.semiCode = semiCode;
		this.memId = memId;
		this.sqDate = sqDate;
		this.sqDetail = sqDetail;
		this.qnaAnsId = qnaAnsId;
		this.sqAnswer = sqAnswer;
		this.qnaAnsdate = qnaAnsdate;
		this.memNick = memNick;
		this.memProf = memProf;
	}
	
	public int getSqCode() {
		return sqCode;
	}
	public void setSqCode(int sqCode) {
		this.sqCode = sqCode;
	}
	public String getQnatype() {
		return qnatype;
	}
	public void setQnatype(String qnatype) {
		this.qnatype = qnatype;
	}
	public int getSemiCode() {
		return semiCode;
	}
	public void setSemiCode(int semiCode) {
		this.semiCode = semiCode;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public Date getSqDate() {
		return sqDate;
	}
	public void setSqDate(Date sqDate) {
		this.sqDate = sqDate;
	}
	public String getSqDetail() {
		return sqDetail;
	}
	public void setSqDetail(String sqDetail) {
		this.sqDetail = sqDetail;
	}
	public String getQnaAnsId() {
		return qnaAnsId;
	}
	public void setQnaAnsId(String qnaAnsId) {
		this.qnaAnsId = qnaAnsId;
	}
	public String getSqAnswer() {
		return sqAnswer;
	}
	public void setSqAnswer(String sqAnswer) {
		this.sqAnswer = sqAnswer;
	}
	public Date getQnaAnsdate() {
		return qnaAnsdate;
	}
	public void setQnaAnsdate(Date qnaAnsdate) {
		this.qnaAnsdate = qnaAnsdate;
	}
	public String getMemNick() {
		return memNick;
	}
	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}
	public String getMemProf() {
		return memProf;
	}
	public void setMemProf(String memProf) {
		this.memProf = memProf;
	}
}
