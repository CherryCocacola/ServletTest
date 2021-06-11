package com.calc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cal/calc")
public class calc extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String x_ = req.getParameter("x");
//		String y_ = req.getParameter("y");
//		
//		int x = 0;
//		int y = 0;
//		
//		if(!x_.equals("")) 
//			x=Integer.parseInt(x_);
//		
//		if(!y_.equals("")) 
//			y=Integer.parseInt(y_);
		
		String x_[]= req.getParameterValues("num");
		int result
		= 0;
		for(int i=0; i<x_.length;i++) {
			int num = Integer.parseInt(x_[i]);
		    result+=num;
		}
		
		
		String op = req.getParameter("operator");
//		int result = 0;
//		
//		switch (op) {
//		case "Plus":
//			result = x+y;
//			break;
//			
//		case "minus":
//			result = x-y;
//			break;
//			
//		case "mutiple":
//			result = x*y;
//			break;
//
//		default:
//			break;
//		}
		req.setAttribute("sum", result);
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/WEB-INF/cal/calc.jsp").forward(req, resp);
	}
}
