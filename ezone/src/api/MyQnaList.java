package ezone.api;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ezone.dao.Ht_qna_dao;
import ezone.vo.Ht_qna_VO;

/**
 * Servlet implementation class MyQnaList
 */
@WebServlet("/myqnalist")
public class MyQnaList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Ht_qna_dao dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyQnaList() {
        super();
        dao=new Ht_qna_dao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("user", "himan123");
		String id=(String)session.getAttribute("user");
		String pageStr=request.getParameter("page");
		int page = Integer.parseInt(pageStr);
		
		ArrayList<Ht_qna_VO> myQnaList = dao.qnaList(id, page);
		
		response.getWriter().println("[");
		for (Ht_qna_VO vo:myQnaList) {
			response.getWriter().print("{\"qnaCode\":"+vo.getQnaCode()+", \"qnaCate\":\""+vo.getQnaCate()+"\",");
			response.getWriter().print("\"memId\":\""+vo.getMemId()+"\",");
			response.getWriter().print("\"qnaDate\":\""+vo.getQnaDate()+"\",");
			response.getWriter().print("\"qnaTitle\":\""+vo.getQnaTitle()+"\",");
			response.getWriter().print("\"qnaDetail\":\""+vo.getQnaDetail()+"\",");
			response.getWriter().print("\"qnaOpen\":\""+vo.getQnaOpen()+"\",");
			response.getWriter().print("\"qnaAnsw\":\""+vo.getQnaAnsw()+"\",");
			response.getWriter().print("\"qnaAdate\":\""+vo.getQndAdate()+"\",");
			response.getWriter().print("\"adId\":\""+vo.getAdId()+"\"},");
		}
		response.getWriter().println("]");
	}

}
