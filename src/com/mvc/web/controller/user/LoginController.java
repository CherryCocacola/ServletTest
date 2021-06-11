package com.mvc.web.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.web.entity.user.Login;
import com.mvc.web.entity.user.User;
import com.mvc.web.service.UserDAO;
@WebServlet("/user/login")
public class LoginController extends HttpServlet{
	private static final Integer cookieExpire = 60*60*24*30; //1 month = 30day
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String pid = req.getParameter("id");
		String ppass = req.getParameter("pass");
		String remember = req.getParameter("remember");	
		
		Login lg = new Login(pid, ppass);  //id 와 password 담은 객체 생성
	
		User ur = (UserDAO.getInstance().loginCheck(lg));
		
		int result = ur.getNumber(); //user 조회 후 결과에 대한 number
		
		switch(result) {
		case -1: 
			//login 창으로 다시 보낸다.
			req.setAttribute("ment", "존재하지 않는 ID 입니다.");
			doGet(req, resp);
			break;
		
		case 0:
			//login 창으로 다시 보낸다.
			req.setAttribute("ment", "PASSWORD 가 틀렸습니다.");
			doGet(req, resp);
			break;
		
		case 1:// 로그인 성공
			
			//user 객체 내 정보를 변수로 이동
			String userID = ur.getId();
			String userNm = ur.getName();
			String userRank = ur.getRank();
			String userEmail = ur.getEmail();
			
			System.out.println("UR 객체 userID : " + userID);
			System.out.println("UR 객체 getName : " + userNm);
			System.out.println("UR 객체 getRank : " + userRank);
			
			HttpSession session = req.getSession();  //세션에 개인정보를 등록한다.
			session.setAttribute("userID", userID );
			session.setAttribute("UserNm", userNm);
			session.setAttribute("userRank", userRank);
			session.setAttribute("userEmail", userEmail);
			
			if(remember!=null) {
				setCookie("sid", pid, resp);
			}else{
				setCookie("sid", "", resp);
			}
					
			//세션값 테스트 출력
			System.out.println("세션 : " + (req.getSession().getAttribute("userID")).toString());
			System.out.println("세션 : " + (req.getSession().getAttribute("UserNm")).toString());
			System.out.println("세션 : " + (req.getSession().getAttribute("userRank")).toString());
			System.out.println("세션 : " + (req.getSession().getAttribute("userEmail")).toString());
			
			resp.sendRedirect("/board/content/list");
			
			break;
		}		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userID = get_Cookie("sid", req); 
		req.setAttribute("id", userID); 
		
		req.getRequestDispatcher("/WEB-INF/board/user/login.jsp").forward(req, resp);
	}
	
	//쿠키 불러오기
	private String get_Cookie(String cid, HttpServletRequest req) {
		String ret = "";
		
		if(req == null) {
			return ret;
		}
		
		Cookie[] cookies = req.getCookies();
		if(cookies == null) {
			return ret;
		}
		
		for(Cookie ck : cookies) {
			if(ck.getName().equals(cid)) {
				
				ret= ck.getValue();
				
				System.out.println("ck.getname : " + ck.getName()); //sid
				System.out.println("ck.getvalue :  " + ck.getValue());  //sid 가 가진 값 : 내 아이디값
				System.out.println("ret :  " + ret);
				ck.setMaxAge(cookieExpire);
				break;
			}
		}
		return ret;
	}

	//쿠키 생성
	private void setCookie(String cid, String pid, HttpServletResponse resp) {
		Cookie ck = new Cookie(cid, pid); //sid , pid(접속한 사람 id)
		ck.setPath("/");
		ck.setMaxAge(cookieExpire);
		resp.addCookie(ck);	
	}
}
