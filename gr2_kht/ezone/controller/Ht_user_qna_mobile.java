package ezone.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ezone.service.Ht_qna_service;
import ezone.vo.Ht_qna_VO;

/**
 * Servlet implementation class Ht_user_qna_mobile
 */
@WebServlet("/Ht_user_qna_mobile")
public class Ht_user_qna_mobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Ht_qna_service service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ht_user_qna_mobile() {
        super();
        // TODO Auto-generated constructor stub
        service = new Ht_qna_service();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Ht_qna_VO tmp = new Ht_qna_VO();
		
		ArrayList<Ht_qna_VO> array = service.getqnaList(tmp);
		String jsonQlist = gson.toJson(array);
		System.out.println(jsonQlist);
		request.setAttribute("JSON", jsonQlist);
		String page = "project05_user_board\\ht_user_w_qna_json.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
