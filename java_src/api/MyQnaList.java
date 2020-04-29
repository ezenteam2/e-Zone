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
import com.google.gson.GsonBuilder;

import ezone.dao.Ht_qna_dao;
import ezone.dao.SemiZoneQnA_Dao;
import ezone.vo.Ht_qna_VO;
import ezone.vo.SemiZoneQnA;

/**
 * Servlet implementation class MyQnaList
 */
@WebServlet("/myqnalist")
public class MyQnaList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Ht_qna_dao dao1;
    private SemiZoneQnA_Dao dao2;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyQnaList() {
        super();
        dao1=new Ht_qna_dao();
        dao2=new SemiZoneQnA_Dao();
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
		pageStr=(pageStr==null)?"1":pageStr;
		int page = Integer.parseInt(pageStr);
		String type1=request.getParameter("type1");
		String type2=request.getParameter("type2");
		type2=(type2==null)? "":type2;
		
		
		if(type1.equals("qna")&&type2.equals("send")) {
			ArrayList<Ht_qna_VO> myQnaList = dao1.qnaList(id, page);
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			String json=gson.toJson(myQnaList);
			response.getWriter().print(json);
		}
		
		if(type1.equals("qna")&&type2.equals("sendcnt")) {
			int cnt=dao1.getCnt(id);
			response.getWriter().print("{\"cnt\":"+cnt+"}");
		}
		
		if(type1.equals("zone")&&type2.equals("send")) {
			ArrayList<SemiZoneQnA> myZoneQnaList = dao2.getQnAList(id, page);
			String json=new Gson().toJson(myZoneQnaList);
			response.getWriter().print(json);
		}
		
		if(type1.equals("zone")&&type2.equals("sendcnt")) {
			int cnt=dao2.getCount(id);
			response.getWriter().print("{\"cnt\":"+cnt+"}");
		}
		
		if(type1.equals("mobile")) {
			
			ArrayList<Map<String, String>> arr=dao1.mobileYong(page);
			Gson gson=new Gson();
			String json=gson.toJson(arr);
			response.getWriter().print("{\"qnaList\":");
			response.getWriter().print(json);
			response.getWriter().print("}");
		}
		
		if(type1.equals("mobile2")) {
			
			ArrayList<Map<String, String>> arr=dao1.mobileYong2(page);
			Gson gson=new Gson();
			String json=gson.toJson(arr);
			response.getWriter().print("{\"qnaList\":");
			response.getWriter().print(json);
			response.getWriter().print("}");
		}
	}

}
