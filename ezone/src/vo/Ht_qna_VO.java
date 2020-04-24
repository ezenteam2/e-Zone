package ezone.vo;

import java.sql.Date;

public class Ht_qna_VO {
	private int qnaCode;
	private String qnaCate;
	private String memId;
	private Date qnaDate;
	private String qnaTitle;
	private String qnaDetail;
	private String qnaOpen;
	private String qnaAnsw;
	private Date qndAdate;
	private String adId;

	public Ht_qna_VO() {
		super();
	}

	public Ht_qna_VO(int qnaCode, String qnaCate, String memId, Date qnaDate, String qnaTitle, String qnaDetail,
			String qnaOpen, String qnaAnsw, Date qndAdate, String adId) {
		super();
		this.qnaCode = qnaCode;
		this.qnaCate = qnaCate;
		this.memId = memId;
		this.qnaDate = qnaDate;
		this.qnaTitle = qnaTitle;
		this.qnaDetail = qnaDetail;
		this.qnaOpen = qnaOpen;
		this.qnaAnsw = qnaAnsw;
		this.qndAdate = qndAdate;
		this.adId = adId;
	}
	
	

	public Ht_qna_VO(String qnaCate, String memId, String qnaTitle, String qnaDetail, String qnaOpen) {
		super();
		this.qnaCate = qnaCate;
		this.memId = memId;
		this.qnaTitle = qnaTitle;
		this.qnaDetail = qnaDetail;
		this.qnaOpen = qnaOpen;
	}
	
	

	public Ht_qna_VO(String qnaTitle, String qnaDetail, int qnaCode) {
		super();
		this.qnaTitle = qnaTitle;
		this.qnaDetail = qnaDetail;
		this.qnaCode = qnaCode;
	}

	public int getQnaCode() {
		return qnaCode;
	}

	public void setQnaCode(int qnaCode) {
		this.qnaCode = qnaCode;
	}

	public String getQnaCate() {
		return qnaCate;
	}

	public void setQnaCate(String qnaCate) {
		this.qnaCate = qnaCate;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaDetail() {
		return qnaDetail;
	}

	public void setQnaDetail(String qnaDetail) {
		this.qnaDetail = qnaDetail;
	}

	public String getQnaOpen() {
		return qnaOpen;
	}

	public void setQnaOpen(String qnaOpen) {
		this.qnaOpen = qnaOpen;
	}

	public String getQnaAnsw() {
		return qnaAnsw;
	}

	public void setQnaAnsw(String qnaAnsw) {
		this.qnaAnsw = qnaAnsw;
	}

	public Date getQndAdate() {
		return qndAdate;
	}

	public void setQndAdate(Date qndAdate) {
		this.qndAdate = qndAdate;
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}
	
	
	

}
