package ezone.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezone.service.seminaService;


@WebServlet("/semina")
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
		if(proc==null||proc.equals("")) proc="sch";
		
		if(proc.equals("sch")) {
			request.setAttribute("seminaInfo", service.infoList(request));
		}
	
	String page = "jsp\\sh_user_w_semiDetail.jsp";
	System.out.println("수행!!");
	RequestDispatcher rd = request.getRequestDispatcher(page);
	rd.forward(request, response);
	}
}
