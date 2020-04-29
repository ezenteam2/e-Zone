package ezone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ezone.service.*;

//ezone.controller.kb_Controller
@Controller
public class kb_Controller {
	kb_Service kb_service = new kb_Service();
	
	
	@RequestMapping("/main.do")
	public String main(HttpServletRequest request) {
		
		String islogin = kb_service.isLogin(request);
		System.out.println(islogin);
		
		if(!islogin.equals("")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", islogin);
			System.out.println("성공");
		}
		
		return "WEB-INF\\views\\gr2_kkb\\kb_w_user_Main.jsp";
	}
	
	@RequestMapping("/login.do")
	public String login() {
		
		return "WEB-INF\\views\\gr2_kkb\\kb_w_user_Login.jsp";
	}
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		
		return "main.do";
	}
	

	
	@RequestMapping("/findId.do")
	public String findId() {
		return "WEB-INF\\views\\gr2_kkb\\kb_w_user_findId.jsp";
	}
	
	@RequestMapping("/idResult.do")
	public String idResult(HttpServletRequest request, Model d) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		if(name == null) name = ""; if(email == null) email = "";
		System.out.println(name);
		d.addAttribute("name", name);
		d.addAttribute("id", kb_service.getId(request));
		return "WEB-INF\\views\\gr2_kkb\\kb_w_user_findIdResult.jsp";
	}
	
	@RequestMapping("/findPass.do")
	public String findPass() {
		return "WEB-INF\\views\\gr2_kkb\\kb_w_user_findPass.jsp";
	}
	
	@RequestMapping("/UptPass.do")
	public String UptPass(HttpServletRequest request, Model d) {
		
		boolean isExist = kb_service.getfindPass(request);
		String page = "";
		if(isExist) {
			d.addAttribute("id", request.getParameter("id"));
			page = "WEB-INF\\views\\gr2_kkb\\kb_w_user_UptPass.jsp";
		} else {
			page = findPass();
		}
		
		return page;
	}
	
	@RequestMapping("/UptPassResult.do")
	public String UptPassResult(HttpServletRequest request) {
		
		kb_service.UpdatePass(request);
		
		return "WEB-INF\\views\\gr2_kkb\\kb_w_user_UptPassResult.jsp";
	}
	
	@RequestMapping("/mypage.do")
	public String Mypage() {
		return "WEB-INF\\views\\gr2_lhj\\hj_user_w_myPage.jsp";
	}
	
	@RequestMapping("/mypage_qna.do")
	public String myPage_Qna() {
		return "WEB-INF\\views\\gr2_lhj\\hj_user_w_myPage_qna.jsp";
	}
	
	@RequestMapping("/SignUp.do")
	public String SignUp() {
		return "WEB-INF\\views\\gr2_lhj\\hj_user_w_signUp.jsp";
	}
	
	@RequestMapping("/SignDone.do")
	public String SignDone() {
		return "WEB-INF\\views\\gr2_lhj\\hj_user_w_signUp_done.jsp";
	}
	
	@RequestMapping("/SemiReg1.do")
	public String SemiReg1() {
		return "WEB-INF\\views\\gr2_lhj\\hj_user_w_semiReg1.jsp";
	}
	
	@RequestMapping("/SemiReg2.do")
	public String SemiReg2() {
		return "WEB-INF\\views\\gr2_lhj\\hj_user_w_semiReg2.jsp";
	}
	
	@RequestMapping("/SemiDone.do")
	public String SemiRegDone() {
		return "WEB-INF\\views\\gr2_lhj\\hj_user_w_semiReg_done.jsp";
	}
	
	@RequestMapping("/mypage_semi.do")
	public String mypage_semi() {
		return "WEB-INF\\views\\gr2_lhj\\hj_user_w_myPage_semi.jsp";
	}
	
	@RequestMapping("/seminaDetail.do")
	public String SeminaDetail() {
		return "WEB-INF\\views\\gr2_ysh\\sh_user_w_semiDetail.jsp";
	}
	
	@RequestMapping("/seminaDetail_Semi.do")
	public String SeminaDetail_Semi() {
		return "WEB-INF\\views\\gr2_ysh\\sh_user_w_semiDetail_semi.jsp";
	}
}
