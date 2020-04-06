package jspexp.z01_vo;

import java.util.Date;

// jspexp.z01_vo.Member
public class Member {
	private String id;
	private String pass;
	private String name;
	private int point;
	private String auth;
	private Date regdte;
	
	
	
	public Member(String id, String pass, String name, int point, String auth, Date regdte) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.point = point;
		this.auth = auth;
		this.regdte = regdte;
	}
	
	public Member(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	public Member(String id, int point) {
		super();
		this.id = id;
		this.point = point;
	}
	public Member(String id, String pass, String name, int point, String auth) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.point = point;
		this.auth = auth;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public Date getRegdte() {
		return regdte;
	}
	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}
	
}
