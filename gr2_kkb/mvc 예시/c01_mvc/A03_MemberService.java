package jspexp.c01_mvc;

import javax.servlet.http.HttpServletRequest;

import jspexp.b01_database.A04_MemberDao;
import jspexp.z01_vo.Member;

public class A03_MemberService {
	private A04_MemberDao dao;
	public A03_MemberService() {
		super();
		// TODO Auto-generated constructor stub
		dao = new A04_MemberDao();
	}
	// 로그인 했을 때, Member객체 return 처리하는 메서드 선언.
	public Member login(HttpServletRequest request) {
		String id= request.getParameter("id");
		if(id==null) id="";
		String pass= request.getParameter("pass");
		if(pass==null) pass="";
		// 요청값을 통한, db객체 확인
		return dao.login(new Member(id,pass));	
	}
	

}





