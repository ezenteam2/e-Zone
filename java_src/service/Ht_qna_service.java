package ezone.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import ezone.dao.Ht_qna_dao;
import ezone.vo.Ht_qna_VO;
import z00_util.Nk;

public class Ht_qna_service {
	
	private Ht_qna_dao dao;

	public Ht_qna_service() {
		super();
		dao = new Ht_qna_dao();
	}
	
	public ArrayList<Ht_qna_VO> getqnaList(Ht_qna_VO sch){
		return dao.qnaList(sch);
	}

	public ArrayList<Ht_qna_VO> getqnaList(int page){
		return dao.qnaList(page);
	}
	
	public int getCnt(){
		return dao.getCnt();
	}
	
	public void insertQna(HttpServletRequest req) {
		
		String qnaCate = Nk.toStr(req.getParameter("qnaCate"));
		String memId = Nk.toStr(req.getParameter("memId"));
		String qnaTitle = Nk.toStr(req.getParameter("qnaTitle"));
		String qnaDetail = Nk.toStr(req.getParameter("qnaDetail"));
		String qnaOpen = Nk.toStr(req.getParameter("open"));
		
		dao.insertQna(new Ht_qna_VO(qnaCate, memId, qnaTitle, qnaDetail, qnaOpen));
	}
	
	public void deleteQna(HttpServletRequest req) {
		dao.deleteQna(Nk.toInt(req.getParameter("qnaCode")));
		System.out.println("삭제 서비스 수행");
	}
	
	public Ht_qna_VO qnaUptDetail(HttpServletRequest req) {
		System.out.println(req.getParameter("code"));
		String qnaCodeStr = Nk.toStr(req.getParameter("code"));
		int qnaCode = Integer.parseInt(qnaCodeStr);
		return dao.qnaUptDetail(qnaCode);
	}
	
	public void uptQna(HttpServletRequest req) {
		String qnaTitleUpt = Nk.toStr(req.getParameter("qnaTitleUpt"));
		String qnaDetailUpt = Nk.toStr(req.getParameter("qnaDetailUpt"));
		int qnaCode = Nk.toInt(req.getParameter("qnaCode"));
		
		dao.uptQna(new Ht_qna_VO(qnaTitleUpt, qnaDetailUpt, qnaCode));
	}
	
	

}
