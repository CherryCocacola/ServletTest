package com.mvc.web.controller.content;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.web.entity.content.Notice;
import com.mvc.web.service.ContentDAO;

@WebServlet("/board/content/detail")
public class ContentDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션 값 불러오기
		String userID = req.getSession().getAttribute("userID").toString();
		String userNm = req.getSession().getAttribute("UserNm").toString();
		String userRank = req.getSession().getAttribute("userRank").toString();
		
		//세션 값 테스트
		System.out.println("CONTENT-userID :" + userID);
		System.out.println("CONTENT-userNm :" + userNm);
		System.out.println("CONTENT-userRank :" + userRank);
		
		//JSP 파라미터
		String par = req.getParameter("id");	
		String field_ = req.getParameter("f");
		String qurry_ = req.getParameter("q");
		String field = "title";
		String qurry = "";
		
		
		
	
		int id =0;
		
		if (par != null && !par.equals("")) {
			 id = Integer.parseInt(par);
		}
		
		if (field_ != null && !field_.equals("")) {
			 field = field_;
		}
		
		if (qurry_ != null && !qurry_.equals("")) {
			 qurry = qurry_;
		}
		
		ContentDAO.getInstance().upHit(id);
		
		Notice nt = ContentDAO.getInstance().getDetail(id);
		
		req.setAttribute("sid", userID);
		req.setAttribute("srank", userRank);
		req.setAttribute("nt", nt);
		req.setAttribute("f", field);
		req.setAttribute("q", qurry);
		
		req.getRequestDispatcher("/WEB-INF/board/content/Detail.jsp").forward(req, resp);
	}
}
