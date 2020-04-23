package ezone.vo;

public class Ht_faq_VO {
	
	private int faq_code;
	private String ad_id;
	private String faq_cate;
	private String faq_title;
	private String faq_detail;
	private String faq_img;
	private String keyword;

	public Ht_faq_VO() {
		super();
	}
	
	

	public Ht_faq_VO(int faq_code, String ad_id, String faq_cate, String faq_title, String faq_detail, String faq_img) {
		super();
		this.faq_code = faq_code;
		this.ad_id = ad_id;
		this.faq_cate = faq_cate;
		this.faq_title = faq_title;
		this.faq_detail = faq_detail;
		this.faq_img = faq_img;
	}



	public Ht_faq_VO(String faq_cate, String faq_title, String faq_detail) {
		super();
		this.faq_cate = faq_cate;
		this.faq_title = faq_title;
		this.faq_detail = faq_detail;
	}
	
	
	

	public Ht_faq_VO(String faq_cate, String keyword) {
		super();
		this.faq_cate = faq_cate;
		this.keyword = keyword;
	}



	public String getKeyword() {
		return keyword;
	}



	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}



	public int getFaq_code() {
		return faq_code;
	}

	public void setFaq_code(int faq_code) {
		this.faq_code = faq_code;
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getFaq_cate() {
		return faq_cate;
	}

	public void setFaq_cate(String faq_cate) {
		this.faq_cate = faq_cate;
	}

	public String getFaq_title() {
		return faq_title;
	}

	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}

	public String getFaq_detail() {
		return faq_detail;
	}

	public void setFaq_detail(String faq_detail) {
		this.faq_detail = faq_detail;
	}

	public String getFaq_img() {
		return faq_img;
	}

	public void setFaq_img(String faq_img) {
		this.faq_img = faq_img;
	}
	
	

}
