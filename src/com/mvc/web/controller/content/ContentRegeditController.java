package com.mvc.web.controller.content;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.web.entity.content.Notice;
import com.mvc.web.service.ContentDAO;

@WebServlet("/board/content/regedit")
public class ContentRegeditController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String userNm = req.getSession().getAttribute("UserNm").toString();
		String userId = req.getSession().getAttribute("userID").toString();
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		//Notice nt = new Notice(title, userId , content);
		
		ContentDAO nd = new ContentDAO();

		int result = nd.regeditNotice(userId , title , content);
	
		resp.sendRedirect("list");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userNm = req.getSession().getAttribute("UserNm").toString();
		req.setAttribute("name", userNm);
		req.getRequestDispatcher("/WEB-INF/board/content/regedit.jsp").forward(req, resp);
	}
}
