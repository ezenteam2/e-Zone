package ezone.vo;

public class SemiParti {
	private int partiCode; // 참가 코드
	private int semiCode; // 세미나 코드 
	private String partiBookDate; // 참가 신청 날짜
	private String memId; // 참가자 아이디
	private int partiMcnt; // 참가 신청 인원
	private int partiPrice; // 참가 비용
	private String partiCurr; // 결제 상태
	private String partiComm; // 이용후기
	private String partiCommDate; // 이용후기 날짜
	
	private String memNick; // 참가자 닉네임
	private String memProf; // 참가자 프로필

	
	public SemiParti() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SemiParti(int semiCode, String memId, int partiMcnt, int partiPrice) {
		super();
		this.semiCode = semiCode;
		this.memId = memId;
		this.partiMcnt = partiMcnt;
		this.partiPrice = partiPrice;
	}

	public SemiParti(int partiCode, int semiCode, String partiBookDate, String memId, int partiMcnt, int partiPrice,
			String partiCurr, String partiComm, String partiCommDate, String memNick, String memProf) {
		super();
		this.partiCode = partiCode;
		this.semiCode = semiCode;
		this.partiBookDate = partiBookDate;
		this.memId = memId;
		this.partiMcnt = partiMcnt;
		this.partiPrice = partiPrice;
		this.partiCurr = partiCurr;
		this.partiComm = partiComm;
		this.partiCommDate = partiCommDate;
		this.memNick = memNick;
		this.memProf = memProf;
	}

	public int getPartiCode() {
		return partiCode;
	}

	public void setPartiCode(int partiCode) {
		this.partiCode = partiCode;
	}

	public int getSemiCode() {
		return semiCode;
	}

	public void setSemiCode(int semiCode) {
		this.semiCode = semiCode;
	}

	public String getPartiBookDate() {
		return partiBookDate;
	}

	public void setPartiBookDate(String partiBookDate) {
		this.partiBookDate = partiBookDate;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getPartiMcnt() {
		return partiMcnt;
	}

	public void setPartiMcnt(int partiMcnt) {
		this.partiMcnt = partiMcnt;
	}

	public int getPartiPrice() {
		return partiPrice;
	}

	public void setPartiPrice(int partiPrice) {
		this.partiPrice = partiPrice;
	}

	public String getPartiCurr() {
		return partiCurr;
	}

	public void setPartiCurr(String partiCurr) {
		this.partiCurr = partiCurr;
	}

	public String getPartiComm() {
		return partiComm;
	}

	public void setPartiComm(String partiComm) {
		this.partiComm = partiComm;
	}

	public String getPartiCommDate() {
		return partiCommDate;
	}

	public void setPartiCommDate(String partiCommDate) {
		this.partiCommDate = partiCommDate;
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
