package jspexp.c01_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspexp.z01_vo.Member;

/**
 * Servlet implementation class A03_MemberCtrl
 */
@WebServlet(name = "member", urlPatterns = { "/member" })
public class A03_MemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private A03_MemberService service;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A03_MemberCtrl() {
        super();
        // TODO Auto-generated constructor stub
        service = new A03_MemberService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 요청
		String proc = request.getParameter("proc");
		if(proc==null) proc="";

		// 2. 모델
		//    1) 로그인 했을 때..
		if(proc.equals("login")) {
			// DB처리를 통해 Member객체가 있을 때, Session 처리..
			Member mem = service.login(request);
			if(mem!=null) {
				// Session 입력처리 완료..
				HttpSession session = request.getSession();
				session.setAttribute("mem", mem);
			}
		}
		if(proc.equals("logout")) {
			// 로그 아웃 클릭시, session값을 없애는 처리..
			request.getSession().invalidate();
		}
		// 3. 화면 a11_mvc\a03_login.jsp
		String page="a11_mvc\\a03_login.jsp";
		if(proc.equals("main")) {
			page="a11_mvc\\a03_main.jsp";
		}
		RequestDispatcher rd= request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
