package com.mvc.web.controller.content;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.web.entity.content.Picture;
import com.mvc.web.service.ContentDAO;

@WebServlet("/board/content/picturelist")
public class PictureListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Picture>list = ContentDAO.getInstance().getPictureList();
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/board/content/PictureList.jsp").forward(req, resp);
	}
}
