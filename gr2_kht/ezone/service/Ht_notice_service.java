package ezone.service;

import java.util.ArrayList;

import ezone.dao.Ht_notice_dao;
import ezone.vo.Ht_notice_VO;

public class Ht_notice_service {
	
	private Ht_notice_dao dao;

	public Ht_notice_service() {
		super();
		dao = new Ht_notice_dao();
	}
	
	public ArrayList<Ht_notice_VO> getNotiList(Ht_notice_VO sch){
		return dao.noticeList(sch);
	}

}
