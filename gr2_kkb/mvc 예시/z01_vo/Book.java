package jspexp.z01_vo;

public class Book { 
	private String title;
	private String writer;
	private String publisher;
	private int price;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String writer, String publisher, int price) {
		super();
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
	}
	// 객체의 property는 메서드 setXXXX() getXXXX()
	// 일반적으로 상단에 선언한 field명과 동일하기 때문에,
	// property를 field은 아니다.
	// property를 이용해서 접근을 할 때, 접근 제어자 private이어서
	// 접근이 되지 않다.
	// getTitle()  title  
	// title라고 사용하면서 getTitle() setTitle()
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
