package ezone.vo;

public class SeminaZone {
	private int zoneCode;
	private String zoneTitle;
	private int zoneCapa;
	private String zoneDetail;
	private int zonePrice;
	private String zoneIntro;
	private String zoneNoctice;
	private String zoneRefund;
	private String zoneImage;
	
	public SeminaZone() {}
	public SeminaZone(int zoneCode, String zoneTitle, int zoneCapa, String zoneDetail, int zonePrice, 
			String zoneIntro, String zoneNoctice, String zoneRefund, String zoneImage) {
		this.zoneCode = zoneCode;
		this.zoneTitle = zoneTitle;
		this.zoneCapa = zoneCapa;
		this.zoneDetail = zoneDetail;
		this.zonePrice = zonePrice;
		this.zoneIntro = zoneIntro;
		this.zoneNoctice = zoneNoctice;
		this.zoneRefund = zoneRefund;
		this.zoneImage = zoneImage;
	}
	public int getZoneCode() {
		return zoneCode;
	}
	public void setZoneCode(int zoneCode) {
		this.zoneCode = zoneCode;
	}
	public String getZoneTitle() {
		return zoneTitle;
	}
	public void setZoneTitle(String zoneTitle) {
		this.zoneTitle = zoneTitle;
	}
	public int getZoneCapa() {
		return zoneCapa;
	}
	public void setZoneCapa(int zoneCapa) {
		this.zoneCapa = zoneCapa;
	}
	public String getZoneDetail() {
		return zoneDetail;
	}
	public void setZoneDetail(String zoneDetail) {
		this.zoneDetail = zoneDetail;
	}
	public int getZonePrice() {
		return zonePrice;
	}
	public void setZonePrice(int zonePrice) {
		this.zonePrice = zonePrice;
	}
	public String getZoneIntro() {
		return zoneIntro;
	}
	public void setZoneIntro(String zoneIntro) {
		this.zoneIntro = zoneIntro;
	}
	public String getZoneNoctice() {
		return zoneNoctice;
	}
	public void setZoneNoctice(String zoneNoctice) {
		this.zoneNoctice = zoneNoctice;
	}
	public String getZoneRefund() {
		return zoneRefund;
	}
	public void setZoneRefund(String zoneRefund) {
		this.zoneRefund = zoneRefund;
	}
	public String getZoneImage() {
		return zoneImage;
	}
	public void setZoneImage(String zoneImage) {
		this.zoneImage = zoneImage;
	}
	
	
}
