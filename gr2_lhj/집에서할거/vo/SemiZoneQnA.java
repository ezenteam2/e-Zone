package ezone.vo;

public class SemiZoneQnA {
	private int qnaCode;
	private String qnaType;
	private int semiZoneCode;
	private String memId;
	private String qnaContent;
	private String qnaDate;
	private String adminId;
	private String qnaAnswContent;
	private String qnaANswDate;
	
	public SemiZoneQnA(int qnaCode, String qnaType, int semiZoneCode, String memId, String qnaContent,
			String qnaDate, String adminId, String qnaAnswContent, String qnaANswDate) {
		this.qnaCode = qnaCode;
		this.qnaType = qnaType;
		this.semiZoneCode = semiZoneCode;
		this.memId = memId;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.adminId = adminId;
		this.qnaAnswContent = qnaAnswContent;
		this.qnaANswDate = qnaANswDate;
	}
	
	public SemiZoneQnA() {}

	public int getQnaCode() {
		return qnaCode;
	}

	public void setQnaCode(int qnaCode) {
		this.qnaCode = qnaCode;
	}

	public String getQnaType() {
		return qnaType;
	}

	public void setQnaType(String qnaType) {
		this.qnaType = qnaType;
	}

	public int getSemiZoneCode() {
		return semiZoneCode;
	}

	public void setSemiZoneCode(int semiZoneCode) {
		this.semiZoneCode = semiZoneCode;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getQnaAnswContent() {
		return qnaAnswContent;
	}

	public void setQnaAnswContent(String qnaAnswContent) {
		this.qnaAnswContent = qnaAnswContent;
	}

	public String getQnaANswDate() {
		return qnaANswDate;
	}

	public void setQnaANswDate(String qnaANswDate) {
		this.qnaANswDate = qnaANswDate;
	};
	
	
}
