package ezone.api;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezone.dao.SeminarDao;

/**
 * Servlet implementation class SemiTimeChk
 */
@WebServlet("/semitimechk")
public class SemiTimeChk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SeminarDao dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiTimeChk() {
        super();
        dao=new SeminarDao();
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
		String zone=request.getParameter("zone");
		String date=request.getParameter("date");
		ArrayList<String> arr=dao.getTimeTable(zone, date);
		response.getWriter().print("[");
		for(int idx=0; idx<arr.size(); idx=idx+2) {
			response.getWriter().print("{\"start\":\""+arr.get(idx)+"\", \"end\":\""+arr.get(idx+1)+"\"},");
		}
		response.getWriter().print("]");
	}

}
