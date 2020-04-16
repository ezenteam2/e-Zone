package ezone.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import ezone.dao.SeminarDao;
import ezone.vo.Seminar;

public class seminaService {
	private SeminarDao dao;
	public seminaService() {
		super();
		dao = new SeminarDao();
	}
	public ArrayList<Seminar> infoList(HttpServletRequest request){
		int semiCode = Integer.parseInt(request.getParameter("semiCode"));
		return dao.getSeminaInfo(semiCode);
	}
}
