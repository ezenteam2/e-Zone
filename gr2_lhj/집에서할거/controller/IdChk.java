package ezone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezone.dao.MemberDao;

/**
 * Servlet implementation class IdChk
 */
@WebServlet("/idchk")
public class IdChk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdChk() {
        super();
        dao = new MemberDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		if(id!=null) {
			boolean idChk = dao.idChk(id); //true이면 아이디가 있는 것(아이디중복), false이면 아이디가 없는 것(아이디 사용가능)
			response.getWriter().print("{\"check\":"+idChk+"}");
		}
	}

}
