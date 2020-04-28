package ezone.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ezone.dao.SeminarDao;
import ezone.vo.SemiParti;
import ezone.vo.SemiQna;
import ezone.vo.Seminar;

public class seminaService {
	private SeminarDao dao;

	public seminaService() {
		super();
		dao = new SeminarDao();
	}
	public Seminar infoList(HttpServletRequest request){
		int semiCode = Integer.parseInt(request.getParameter("semiCode"));
		return dao.getSeminaInfo(semiCode);
	}
	public ArrayList<SemiQna> qnaList(HttpServletRequest request) {
		int semiCode = Integer.parseInt(request.getParameter("semiCode"));
		return dao.getSeminaQna(semiCode);
	}
	public ArrayList<SemiParti> reviewList(HttpServletRequest request) {
		int semiCode = Integer.parseInt(request.getParameter("semiCode"));
		return dao.getSeminaReview(semiCode);
	}
	public void insertParti(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memId = (String)session.getAttribute("user");
		System.out.println("memId : "+memId);
		int semiCode = Integer.parseInt(request.getParameter("semiCode"));
		System.out.println("semiCode : "+semiCode);
		int partiMcnt= Integer.parseInt(request.getParameter("partiMcnt"));
		System.out.println("partiMcnt : "+partiMcnt);
		int partiPrice= Integer.parseInt(request.getParameter("partiPrice"));
		System.out.println("partiPrice : "+partiPrice);
		dao.insertSemiParti(new SemiParti(semiCode, memId, partiMcnt, partiPrice));
	}
}
