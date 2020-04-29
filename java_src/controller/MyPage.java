package ezone.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import ezone.dao.MemberDao;
import ezone.vo.Member;

/**
 * Servlet implementation class MyPage
 */
@WebServlet("/mypage")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPage() {
        super();
        dao=new MemberDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String proc = request.getParameter("proc");
		HttpSession session = request.getSession();
		session.setAttribute("user", "himan123");

		if(proc==null) {
			String page= "my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_myPage.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}
		if(proc!=null&&proc.equals("semi")) {
			String page= "my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_myPage_semi.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}
		if(proc!=null&&proc.equals("qna")) {
			String page= "my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_myPage_qna.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}
		
		if(proc!=null&&proc.equals("comm")) {
			String page= "my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_myPage_comm.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}
		
		if(proc!=null&&proc.equals("edit")) {
			request.setAttribute("memInfo", dao.getMemInfo((String)session.getAttribute("user")));
			String page= "my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_myPage_profileEdit.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}
		if(proc!=null&&proc.equals("update")) {
			
			String id=(String)session.getAttribute("user");
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
			img=(img==null)?" ":img;
			cate1=(cate1==null)?" ":cate1;
			cate2=(cate2==null)?" ":cate2;
			cate3=(cate3==null)?" ":cate3;
			
			Member m1=new Member();
			m1.setMemId(id);
			m1.setMemPw(pass);
			m1.setMemEmail(email);
			m1.setMemNick(nickName);
			m1.setMemPhone(telNum);
			m1.setMemName(name);
			m1.setMemAddr(address);
			m1.setMemCate(cate1+","+cate2+","+cate3);
			m1.setMemProf(img);
			dao.updateMember(m1);
			String page= "my\\e-Zone\\gr2_lhj\\jsp\\hj_user_w_myPage_profileEdit.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(page);
			dis.forward(request, response);
		}
		
	}

}
