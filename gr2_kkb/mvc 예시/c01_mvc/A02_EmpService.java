package jspexp.c01_mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import jspexp.b01_database.A01_Database;
import jspexp.z01_vo.Emp;

public class A02_EmpService {
	private A01_Database dao;
	public A02_EmpService() {
		super();
		dao = new A01_Database();
	}
	// 요청값 proc에 따라서 처리할 기능 메서드 선언.
	// 초기화면/검색데이터
	public ArrayList<Emp> elist(HttpServletRequest req){
		// 요청값 처리..
		String ename = toStr(req.getParameter("ename"));
		String job = toStr(req.getParameter("job"));

		return dao.getEmpList(new Emp(ename,job));
	}
	// 등록 처리..
	public void insertEmp(HttpServletRequest req) {
		// 1. 등록될 요청값.
		String ename = toStr(req.getParameter("ename"));
		String job = toStr(req.getParameter("job"));
		int mgr = toInt(req.getParameter("mgr"));
		double sal = toDbl(req.getParameter("sal"));
		double comm = toDbl(req.getParameter("comm"));
		int deptno = toInt(req.getParameter("deptno"));
		// 2. VO에 요청값 할당.
		// 3. 등록 dao 호출 처리..
		dao.insertEmp(new Emp(ename, job, mgr, sal,comm, deptno));
	}
	// 상세화면 처리..
	public Emp detail(HttpServletRequest req) {
		return dao.getEmp(toInt(req.getParameter("empno")));
	}
	
	
	// null ==> "", 0으로 처리하는 기능메서드 선언.
	private String toStr(String str) {
		return str==null?"":str;
	}
	private int toInt(String intS) {
		return intS==null?0:new Integer(intS);
	}
	private double toDbl(String dblS) {
		return dblS==null?0.0:new Double(dblS);
	}	
	
	
	
	
	
	
}
