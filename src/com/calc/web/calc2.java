package com.calc.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cal/calc2")
public class calc2 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		String n_ = req.getParameter("num");	
		String op = req.getParameter("operator");
		
		ServletContext app =req.getServletContext();
		
		int n = 0;
		if(!n_.equals(""))n=Integer.parseInt(n_);
		int result = 0;
		
		if(op.equals("=")) {
			int x = (Integer)app.getAttribute("val");
			int y = n;
			
			String operator = (String)app.getAttribute("op");
	
			if(operator.equals(""))
				result = x+y;
			else
				result = x-y;
		}else {
			app.setAttribute("val", n);
			app.setAttribute("op", op);
		}
		
		req.setAttribute("sum", result);
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/WEB-INF/cal/calc2.jsp").forward(req, resp);
	}
}
