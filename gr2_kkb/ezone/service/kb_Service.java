package ezone.service;

import javax.servlet.http.HttpServletRequest;

import ezone.dao.*;
import ezone.vo.*;

public class kb_Service {
	MemberDao mem_dao;
	
	public kb_Service() {
		mem_dao = new MemberDao();
	}
	
	public String getId(HttpServletRequest req) {
		String id = "";
		
		String name = req.getParameter("name");
		if(name == null) name = "";
		String email = req.getParameter("email");
		if(email == null) email = "";
		
		return mem_dao.getfindId(name, email);
	}
	
	public boolean getfindPass(HttpServletRequest req) {
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		if(id == null) id = "";
		if(email == null) email = "";
		
		return mem_dao.findPass(id, email);
	}
	
	public void UpdatePass(HttpServletRequest req) {
		String pass = req.getParameter("pass");
		String id = req.getParameter("id");
		if(pass == null) pass = "";
		if(id == null) id = "";
		
		mem_dao.UpdatePass(pass, id);
	}
	
	public String isLogin(HttpServletRequest req) {
		String id = req.getParameter("id");
		System.out.println(id);
		String pass = req.getParameter("pass");
		System.out.println(pass);
		if(id == null) id = "";
		if(pass == null) pass="";
		
		return mem_dao.isLogin(id, pass);
	}
}
