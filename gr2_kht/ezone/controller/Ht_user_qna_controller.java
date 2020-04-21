package ezone.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezone.service.Ht_qna_service;
import ezone.vo.Ht_qna_VO;

/**
 * Servlet implementation class Ht_user_qna_controller
 */
@WebServlet("/Ht_user_qna_controller")
public class Ht_user_qna_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Ht_qna_service service; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ht_user_qna_controller() {
        super();
        // TODO Auto-generated constructor stub
        service = new Ht_qna_service();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String proc = request.getParameter("proc");
		if(proc==null||proc.equals("")) proc="main";
		
		if(proc.equals("main")) {
			String pageStr = request.getParameter("page");
			int page=(pageStr==null)? 1:Integer.parseInt(pageStr);
			request.setAttribute("qnalist", service.getqnaList(page));
			request.setAttribute("qnacnt", service.getCnt());
		}
		
		if(proc.equals("insert")) {
			service.insertQna(request);
		}
		
		if(proc.equals("delete")) {
			service.deleteQna(request);
		}
		
		
		String page = "project05_user_board\\ht_user_w_qna.jsp";
		
		if(proc.equals("insert")||proc.equals("delete")) page="project05_user_board\\ht_user_w_qna_insert.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
