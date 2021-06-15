package com.mvc.web.etc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.web.entity.content.EtcList;
import com.mvc.web.entity.content.Notice;
import com.mvc.web.service.ContentDAO;

@WebServlet("/board/content/allcontent")
public class ContentHeaderController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션 값 불러오기
		String userID = req.getSession().getAttribute("userID").toString();
		String userNm = req.getSession().getAttribute("UserNm").toString();
		String userRank = req.getSession().getAttribute("userRank").toString();
		
		//세션 값 테스트
		System.out.println("CONTENT-userID :" + userID);
		System.out.println("CONTENT-userNm :" + userNm);
		System.out.println("CONTENT-userRank :" + userRank);
		
		//JSP 파라미터 초기화 및 불러오기
		int page =1;
		String page_=req.getParameter("p");      //PAGE
		String field_ =req.getParameter("f");    //조회조건
		String qurry_ = req.getParameter("q");   //검색어
		String qurry = "";                       //검색어 초기값
	 
		if(page_ !=null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		if(qurry_ !=null && !qurry_.equals("")) {
				qurry = qurry_;
		}
		
		//int count = ContentDAO.getInstance().getCount(field, qurry, userRank); //총 글 갯수
		
		EtcList el = ContentDAO.getInstance().getAllContent(page,  qurry, userRank);
		int count = el.getCount();  //EtcList 로 부터 count 꺼냄
		System.out.println("count :" + count);
		List<Notice>list = el.getList(); //EtcList 로 부터 list 꺼냄
		
		
		req.setAttribute("name", userNm);
		req.setAttribute("count", count);
		req.setAttribute("list", list);
		String str =req.getParameter("cnt");

		req.getRequestDispatcher("/WEB-INF/board/content/AllContentList.jsp").forward(req, resp);
	}
}
