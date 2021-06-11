package com.mvc.web.controller.content;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.web.entity.content.Notice;
import com.mvc.web.service.ContentDAO;
@WebServlet("/board/content/modify")
public class ContentModifyController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String userNm = req.getSession().getAttribute("UserNm").toString();
		String userId = req.getSession().getAttribute("userID").toString();
		String pid_ = req.getParameter("id");
		
		int pid = Integer.parseInt(pid_);
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		// Notice nt = new Notice(title, userId , content);
		
		int result = ContentDAO.getInstance().updateContent(pid, userId, title, content);

		if(result > 0)
			resp.sendRedirect("/board/content/detail?id="+pid);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String par = req.getParameter("id");
		String field_ = req.getParameter("f");
		String qurry_ = req.getParameter("q");
		String field = "title";
		String qurry = "";

		int id = 0;

		if (par != null && !par.equals("")) {
			id = Integer.parseInt(par);
		}

		if (field_ != null && !field_.equals("")) {
			field = field_;
		}

		if (qurry_ != null && !qurry_.equals("")) {
			qurry = qurry_;
		}

		Notice nt = ContentDAO.getInstance().getDetail(id);

		req.setAttribute("nt", nt);
		req.setAttribute("f", field);
		req.setAttribute("q", qurry);

		req.getRequestDispatcher("/WEB-INF/board/content/modify.jsp").forward(req, resp);
	}
}
