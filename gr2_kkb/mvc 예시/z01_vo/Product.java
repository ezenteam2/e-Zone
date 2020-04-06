package jspexp.z01_vo;
// jspexp.z01_vo.Product
// sno, kind, name, price, cnt
public class Product {
	private int sno;
	private String kind;
	private String name;
	private int price;
	private int cnt;
	private int frPrice; // frPrice toPrice
	private int toPrice;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	// 검색하는 생성자 선언..
	public Product( int frPrice, int toPrice, String name) {
		this.name = name;
		this.frPrice = frPrice;
		this.toPrice = toPrice;
	}

	public Product(int sno, String kind, String name, int price, int cnt) {
		super();
		this.sno = sno;
		this.kind = kind;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	public Product(String kind, String name, int price, int cnt) {
		super();
		this.kind = kind;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	public Product(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getFrPrice() {
		return frPrice;
	}

	public void setFrPrice(int frPrice) {
		this.frPrice = frPrice;
	}

	public int getToPrice() {
		return toPrice;
	}

	public void setToPrice(int toPrice) {
		this.toPrice = toPrice;
	}
	
}
