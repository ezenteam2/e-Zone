package jspexp.c01_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspexp.b01_database.A01_Database;

/**
 * Servlet implementation class A01_Controller
 */
@WebServlet(name = "mvc01", urlPatterns = { "/mvc01" })
public class A01_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public A01_Controller() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// MVC에서 controller 역할은 하는 servlet
		// 1. 요청값 처리..
		
		// 2. view보낼 model데이터(DB연결한 핵심데이터) request객체에 할당..
		A01_Database dao = new A01_Database();
		request.setAttribute("emplist", dao.getEmpList());
		
		// 3. view(.jsp)단을 호출..
		String page= "a11_mvc\\a01_view.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(page);
		dis.forward(request, response);
	}

}
