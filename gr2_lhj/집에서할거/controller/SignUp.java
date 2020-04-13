package ezone.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ezone.dao.*;
import ezone.vo.*;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        dao=new MemberDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String nickName=request.getParameter("nickname");
		String telNum=request.getParameter("telnumber");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String img=request.getParameter("img-file");
		String cate1=request.getParameter("category1");
		String cate2=request.getParameter("category2");
		String cate3=request.getParameter("category3");
		if(id!=null) {
			System.out.println("cate1:"+cate1);
			img=(img==null)?" ":img;
			cate1=(cate1==null)?" ":cate1;
			cate2=(cate2==null)?" ":cate2;
			cate3=(cate3==null)?" ":cate3;
			
			Member m1=new Member();
			m1.setId(id);
			m1.setPass(pass);
			m1.setEmail(email);
			m1.setNick(nickName);
			m1.setPhone(telNum);
			m1.setName(name);
			m1.setAddr(address);
			m1.setCate(cate1+","+cate2+","+cate3);
			m1.setProf(img);
			dao.insertMember(m1);
			String page="my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_signUp_done.jsp";
			RequestDispatcher rd= request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else {
			String page="my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_signUp.jsp";
			RequestDispatcher rd= request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}
}
