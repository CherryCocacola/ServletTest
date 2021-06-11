package com.mvc.web.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.web.service.UserDAO;

@WebServlet("/user/idCheck")
public class idCheckController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println("id : " + id);
		int check = UserDAO.getInstance().idCheck(id);

		req.setAttribute("check", check);
		req.setAttribute("id", id);

		req.getRequestDispatcher("/WEB-INF/board/user/idCheck.jsp").forward(req, resp);
	}
}
