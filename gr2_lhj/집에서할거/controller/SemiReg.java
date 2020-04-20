package ezone.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ezone.dao.*;
import ezone.vo.Seminar;

/**
 * Servlet implementation class SemiReg
 */
@WebServlet("/semireg")
public class SemiReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SeminarDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemiReg() {
        super();
        dao=new SeminarDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("user", "himan123");
		
		String proc = request.getParameter("proc");
		
		if(proc==null) {
			proc="";
		}
		if(proc.equals("")) {
			String page= "my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_semiReg.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}
		if(proc.equals("done")) {
			String title=request.getParameter("title");
			String subtitle=request.getParameter("subtitle");
			int zoneCode=Integer.parseInt(request.getParameter("zone"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date parsed=null;
			try {
				parsed = format.parse(request.getParameter("date"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        java.sql.Date semiDate = new java.sql.Date(parsed.getTime());
	        String startTime=semiDate+" "+request.getParameter("start-time")+":00";
	        String endTime=semiDate+" "+request.getParameter("end-time")+":00";
			String cate=request.getParameter("cate");
			String detail=request.getParameter("detail");
			int semiCapa=Integer.parseInt(request.getParameter("max-join"));
			int semiPrice=Integer.parseInt(request.getParameter("fee-join"));
			String memId=request.getParameter("id");
	        
			Seminar s1=new Seminar();
			s1.setMemId(memId);
			s1.setZoneCode(zoneCode);
			s1.setSemiDate(semiDate);
			s1.setSemiTitle(title);
			s1.setSemiSubtitle(subtitle);
			s1.setSemiStime(startTime);
			s1.setSemiFtime(endTime);
			s1.setSemiCate(cate);
			s1.setSemiDetail(detail);
			s1.setSemiCapa(semiCapa);
			s1.setSemiPrice(semiPrice);
			s1.setSemiCurr("입금대기");
			
			dao.insertSeminar(s1);
			String page= "my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_semiReg_done.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}
	}

}
