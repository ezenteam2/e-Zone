package ezone.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		session.setAttribute("user", "himan123");
		String page = null;
		String pageStr = null;
		
		String proc = request.getParameter("proc");
		
		if(proc==null||proc.equals("")) proc="main";
		
		if(proc.equals("main")) {
			pageStr = request.getParameter("page");
			int pageInt=(pageStr==null)? 1:Integer.parseInt(pageStr);
			request.setAttribute("qnalist", service.getqnaList(pageInt));
			request.setAttribute("qnacnt", service.getCnt());
			page = "project05_user_board\\ht_user_w_qna.jsp";
		}
		
		if(proc.equals("insert")) {
			service.insertQna(request);
			page="project05_user_board\\ht_user_w_qna_process.jsp";
			System.out.println(page);
		}
		
		if(proc.equals("delete")) {
			service.deleteQna(request);
			page="project05_user_board\\ht_user_w_qna_process.jsp";
			System.out.println(page);
		}

		if(proc.equals("update")) {
			service.uptQna(request);
			page="project05_user_board\\ht_user_w_qna_process.jsp";
			System.out.println(page);
		}
		
		if(proc.equals("detail")) {
			page = "project05_user_board\\ht_user_w_qna.jsp";
			pageStr = request.getParameter("page");
			int pageInt=(pageStr==null)? 1:Integer.parseInt(pageStr);
			request.setAttribute("qnalist", service.getqnaList(pageInt));
			request.setAttribute("qnacnt", service.getCnt());
			request.setAttribute("info", service.qnaUptDetail(request));
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

}
