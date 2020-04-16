package ezone.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ezone.dao.*;

/**
 * Servlet implementation class SemiDelete
 */
@WebServlet("/semidelete")
public class SemiDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SeminarDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiDelete() {
        super();
        dao=new SeminarDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String semiCodeStr=request.getParameter("semi_code");
		boolean result = false;
		if(semiCodeStr!=null) {
			int semiCode = Integer.parseInt(semiCodeStr);
			result = dao.deleteSeminar(semiCode);
		}
		
		response.getWriter().print("{\"result\":"+result+"}");
	}

}
