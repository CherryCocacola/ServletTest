package com.mvc.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mvc.web.connection.ConnectionProvider;
import com.mvc.web.connection.jdbcUtil;
import com.mvc.web.entity.content.Notice;
import com.mvc.web.entity.user.Login;
import com.mvc.web.entity.user.Register;
import com.mvc.web.entity.user.User;

public class UserDAO {
	private static UserDAO instance = new UserDAO(); //처음에 생성한 하나의 dao
	
	public static UserDAO getInstance() {
		return instance;
	}

	//LOGIN 
	public User loginCheck(Login lg) {
		Connection con =null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User ur = new User();
		
		String sql = "select  userID, userPass, userName, userEmail, userRank "
			   	   + "  from user "
				   + " where flag = 'Y' "
				   + "   and userID = ? "
				   + "   and userPass = SHA2(?, 256); "; 
		try {
		
			System.out.println("id : " + lg.getId());
			System.out.println("pass : " + lg.getPass());
			con = ConnectionProvider.getConnection();
		    psmt = con.prepareStatement(sql);
			psmt.setString(1, lg.getId()); //login 객체 내 id 값을 입력
			psmt.setString(2, lg.getPass()); //login 객체 내 pass 값을 입력
			rs = psmt.executeQuery();	
			
			if(rs.next()) { // 조회된 값이 있다면  id pass 일치
					ur.setId(lg.getId());
					ur.setName(rs.getString("userName"));
					ur.setRank(rs.getString("userRank"));
					ur.setEmail(rs.getString("userEmail"));
					ur.setNumber(1);	
			}else {
				ur.setNumber(0); //조회된 값이 없을 때  id 혹은 pass 불일치 혹은 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(con);
			jdbcUtil.close(psmt);
			jdbcUtil.close(rs);
		}
		return ur;
	}
	
	//id 체크
	public int idCheck(String pid) {
		Connection con =null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		String sql = "select userID from user where userID = ?";
		
		try {
			con = ConnectionProvider.getConnection();
		    psmt = con.prepareStatement(sql);
			psmt.setString(1, pid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = 1;   //조회된 값이 있을 경우
				
			}else {
				result = 0;   //조회된 값이 없을 경우
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(con);
			jdbcUtil.close(psmt);
			jdbcUtil.close(rs);
		}
		return result;
	}

	//사용자 추가
	public int signUp(Register rt) {
		Connection con =null;
		PreparedStatement psmt = null;
		
		int result = 0;
		String sql = "insert into user (userID, userPass, userName, userEmail) "
			  	   + "values(?,SHA2(?,256),?,?)";
		
		try {
			con = ConnectionProvider.getConnection();
		    psmt = con.prepareStatement(sql);
			psmt.setString(1, rt.getId());
			psmt.setString(2, rt.getPass());
			psmt.setString(3, rt.getName());
			psmt.setString(4, rt.getEmail());
			System.out.println("psmt aaaaaa :" +psmt);
			result = psmt.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(con);
			jdbcUtil.close(psmt);
		}
		return result;
	}

	//접속자 정보 입력
	public void setLoginInfo(String userID, String userIP) {
		Connection con =null;
		PreparedStatement psmt = null;
		
		int result = 0;
		String sql = "insert into user_swap(userID, userIP, outTime, division) "
					+" values(?, ?, ?, ?) ";
		
		try {
			con = ConnectionProvider.getConnection();
		    psmt = con.prepareStatement(sql);
			psmt.setString(1, userID);
			psmt.setString(2, userIP);
			psmt.setString(3, null);
			psmt.setString(4, "I");
			result = psmt.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(con);
			jdbcUtil.close(psmt);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
