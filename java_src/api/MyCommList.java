package ezone.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import ezone.dao.SeminarDao;

/**
 * Servlet implementation class MyCommList
 */
@WebServlet("/mycommlist")
public class MyCommList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SeminarDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCommList() {
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
		HttpSession session = request.getSession();
		session.setAttribute("user", "himan123");
		String id=(String)session.getAttribute("user");
		
		ArrayList<Map<String, String>> arr=dao.getSeminarReview(id);
		System.out.println(arr);
		Gson gson=new Gson();
		String json=gson.toJson(arr);
		
		response.getWriter().print(json);
	}

}
