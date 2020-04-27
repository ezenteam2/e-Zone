package ezone.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ezone.dao.SeminarDao;
import ezone.service.seminaService;
import ezone.vo.SemiQna;


@WebServlet(name="semina", urlPatterns = { "/semina"})
public class seminaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private seminaService service;
	
    public seminaController() {
        super();
        service = new seminaService();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String proc = request.getParameter("proc");
		String page = null;
		
		if(proc==null||proc.equals("")) {
		request.setAttribute("seminaInfo", service.infoList(request));
		request.setAttribute("qnaList", service.qnaList(request));
		page = "gr2_ysh\\jsp\\sh_user_w_semiDetail.jsp";
		for(SemiQna q1:service.qnaList(request)) {
			System.out.println(q1.getMemNick());
		}
		request.setAttribute("reviewList", service.reviewList(request));

		
		}else if(proc.equals("qnaMore")) {
			page="gr2_ysh\\jsp\\sh_user_w_semiDetail_detail.jsp";
			request.setAttribute("list", service.qnaList(request));
		}else if(proc.equals("reviewMore")) {
			page="gr2_ysh\\jsp\\sh_user_w_semiDetail_detail.jsp";
			request.setAttribute("list2", service.reviewList(request));
			
		}else if(proc.equals("pay")) {
			HttpSession session = request.getSession();
			String user = (String)session.getAttribute("user");
			System.out.println(user);
			page = "gr2_ysh\\jsp\\sh_user_w_semiPay.jsp";
			String number = request.getParameter("number");
			request.setAttribute("seminaInfo", service.infoList(request));
			request.setAttribute("number", number);
			
		}else if(proc.equals("apply")) {
			service.insertParti(request);
			page = "gr2_ysh\\jsp\\sh_user_w_semiPay_last.jsp";
			System.out.println("등록성공");
		}else if(proc.equals("sqDetail")) {
			service.insertQna(request);
			request.setAttribute("seminaInfo", service.infoList(request));
			request.setAttribute("qnaList", service.qnaList(request));
			request.setAttribute("reviewList", service.reviewList(request));
			String semiCode=request.getParameter("semiCode");
			page="gr2_ysh\\jsp\\qnaResult.jsp?semiCode="+semiCode;
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		}
	
}
