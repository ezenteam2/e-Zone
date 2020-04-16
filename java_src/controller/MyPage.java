package ezone.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyPage
 */
@WebServlet("/mypage")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String proc = request.getParameter("proc");
		if(proc==null) {
			String page= "my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_myPage.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}
		if(proc!=null&&proc.equals("semi")) {
			String page= "my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_myPage_semi.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}
		
	}

}
