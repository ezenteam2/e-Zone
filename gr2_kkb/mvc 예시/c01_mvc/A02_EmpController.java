package jspexp.c01_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class A02_EmpController
 */
@WebServlet(name = "emp", urlPatterns = { "/emp" })
public class A02_EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private A02_EmpService service;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A02_EmpController() {
        super();
        // TODO Auto-generated constructor stub
        service = new A02_EmpService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		// 1. 요청
		String proc= request.getParameter("proc");
		if(proc==null||proc.equals("")) proc="sch";
		// 2. 모델 처리
		if(proc.equals("sch")) { 
			request.setAttribute("emplist", service.elist( request ));
		}
		if(proc.equals("ins")) {
			// 서비스 단 처리..
			service.insertEmp(request);
		}
		if(proc.equals("detail")) {
			// emp Model
			request.setAttribute("emp", service.detail( request ));
			
		}
		// 3. View 선택..
		//    초기 검색 화면을 default page로 설정..
		String page = "a11_mvc\\a02_empList.jsp";
		// 조건에 따른 proc 페이지 설정..
		if(proc.equals("insFrm")||proc.equals("ins")) page="a11_mvc\\a02_empInsert.jsp";
		if(proc.equals("detail")) page="a11_mvc\\a02_empDetail.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
