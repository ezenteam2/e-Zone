package ezone.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import ezone.dao.Ht_faq_dao;
import ezone.vo.Ht_faq_VO;
import z00_util.Nk;

public class Ht_faq_service {
	
	private Ht_faq_dao dao;

	public Ht_faq_service() {
		super();
		dao = new Ht_faq_dao();
	}
	
	public ArrayList<Ht_faq_VO> getFaqList(Ht_faq_VO sch){
		return dao.faqList(sch);
	}
	
	public ArrayList<Ht_faq_VO> schFaqList(HttpServletRequest request) {
		String faq_cate = Nk.toStr(request.getParameter("faq_cate"));
		String keyword = Nk.toStr(request.getParameter("keyword"));
				
		return dao.schFaqList(new Ht_faq_VO(faq_cate, keyword));
	}

}
