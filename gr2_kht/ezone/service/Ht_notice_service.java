package ezone.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import ezone.dao.Ht_notice_dao;
import ezone.vo.Ht_notice_VO;
import z00_util.Nk;

public class Ht_notice_service {
	
	private Ht_notice_dao dao;

	public Ht_notice_service() {
		super();
		dao = new Ht_notice_dao();
	}
	
	public ArrayList<Ht_notice_VO> getNotiList(Ht_notice_VO sch){
		return dao.noticeList(sch);
	}
	
	public ArrayList<Ht_notice_VO> schNoticeList(HttpServletRequest request){
		String keyword = Nk.toStr(request.getParameter("keyword"));
		
		
		return dao.schNoticeList(new Ht_notice_VO(keyword));
	}
	

}
