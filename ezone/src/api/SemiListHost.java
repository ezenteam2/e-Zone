package ezone.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ezone.dao.*;
import ezone.vo.*;
import java.util.*;

/**
 * Servlet implementation class SemiListHost
 */
@WebServlet("/semilisthost")
public class SemiListHost extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SeminarDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiListHost() {
        super();
        dao = new SeminarDao();
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
		String pageStr=request.getParameter("page");
		String type=request.getParameter("type");
		String user=request.getParameter("user");
		
		
		if(pageStr==null) {
			pageStr="1";
		}
		if(type==null) {
			type="host";
		}
		if(user==null) {
			user="";
		}
		
		if(type.equals("host")) {
			ArrayList<Seminar> array = dao.getList(type, Integer.parseInt(pageStr), user);
			response.getWriter().print("[");
			for(Seminar sem:array) {
				response.getWriter().print("{\"semiCode\":"+sem.getSemiCode()+", ");
				response.getWriter().print("\"memId\":`"+sem.getMemId()+"`, ");
				response.getWriter().print("\"zoneCode\":"+sem.getZoneCode()+", ");
				response.getWriter().print("\"semiBookdate\":\""+sem.getSemiBookdate()+"\", ");
				response.getWriter().print("\"semiTitle\":`"+sem.getSemiTitle()+"`, ");
				response.getWriter().print("\"semiSubtitle\":`"+sem.getSemiSubtitle()+"`, ");
				response.getWriter().print("\"semiDate\":\""+sem.getSemiDate()+"\", ");
				response.getWriter().print("\"semiStime\":`"+sem.getSemiStime()+"`, ");
				response.getWriter().print("\"semiFtime\":`"+sem.getSemiFtime()+"`, ");
				response.getWriter().print("\"semiCate\":\""+sem.getSemiCate()+"\", ");
				response.getWriter().print("\"semiImg\":`"+sem.getSemiImg()+"`, ");
				response.getWriter().print("\"semiDetail\":`"+sem.getSemiDetail()+"`, ");
				response.getWriter().print("\"semiCapa\":"+sem.getSemiCapa()+", ");
				response.getWriter().print("\"semiParno\":"+sem.getSemiParno()+", ");
				response.getWriter().print("\"semiPrice\":"+sem.getSemiPrice()+", ");
				response.getWriter().print("\"semiCurr\":`"+sem.getSemiCurr()+"`, ");
				response.getWriter().print("\"zoneComm\":`"+sem.getZoneComm()+"`, ");
				response.getWriter().print("\"zoneCommdate\":\""+sem.getZoneCommdate()+"\"}, ");
			}
			response.getWriter().print("]");
		}
		if(type.equals("cnt")) {
			int cnt =dao.getCount(user);
			response.getWriter().print("{\"count\":"+cnt+"}");
		}
	}
}
