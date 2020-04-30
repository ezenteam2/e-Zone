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

import ezone.service.seminaService;
import ezone.vo.Seminar;

@WebServlet("/seminaMobileController")
public class seminaMobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private seminaService service;   
    
    public seminaMobileController() {
        super();
        service = new seminaService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		Seminar tmp = new Seminar();
		
		ArrayList<Seminar> array=service.infoListArray(request);
		String jsonNlist = gson.toJson(array);
		System.out.println(jsonNlist);
		request.setAttribute("JSON", jsonNlist);
		String page = "Json\\semiJson.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
