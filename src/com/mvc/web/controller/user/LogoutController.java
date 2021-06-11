package com.mvc.web.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/logout")
public class LogoutController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		session.removeAttribute("userID");
		session.removeAttribute("UserNm");
		session.removeAttribute("userRank");
		session.removeAttribute("userEmail");
		
		resp.sendRedirect("/user/login");
	}
}
