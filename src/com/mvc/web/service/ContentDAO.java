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
import com.mvc.web.entity.content.EtcList;
import com.mvc.web.entity.content.Notice;
import com.mvc.web.entity.content.Picture;

public class ContentDAO{
	private static ContentDAO instance = new ContentDAO(); //처음에 생성한 하나의 dao
	
	public static ContentDAO getInstance() {
		return instance;
	}
	/* 글 목록 */
	public EtcList getList(int page, String field, String qurry, String rank) {
		Connection con =null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		int start = 1+ (page-1)*10;
		int end = page*10;
		
		String sql =  "select * ,  (select count(id) as count "
			  		+ "	              from tbl_board "
				    + "	           	where "+field+" like ? "
					+ "	           	  and useFlag ='Y' "
					+ "	           	  and boardid in (select boardID "
					+ "	             				    from user_auth "
					+ "	             			       where rankcd= ?)) as count "
					+ "  from (select @rownum:=@rownum+1 as num ,n.* "
					+ "          from( select * "
					+ "	                 from tbl_board "
					+ "				    where "+field+" like ? "
					+ "					  and useFlag ='Y' "
					+ "                   and boardid in (select boardID "
					+ "									    from user_auth "
					+ "									   where rankcd=? ) "
					+ "	      order by regdate desc)n "
					+ "          where (@rownum:=0)=0)num "
					+ "  where num.num between ? and ? "; // 조회 sql
		List<Notice> list = new ArrayList<>(); // list 배열 생성

		try {
		    con = ConnectionProvider.getConnection();
		    psmt = con.prepareStatement(sql);
			psmt.setString(1, "%"+qurry+"%");
			psmt.setString(2, rank);
			psmt.setString(3, "%"+qurry+"%");
			psmt.setString(4, rank);
			psmt.setInt(5, start);
			psmt.setInt(6, end);
			System.out.println(psmt);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int id1 = rs.getInt("id");
				String boardid = rs.getString("boardid");
				String title = rs.getString("title");
				String writeid = rs.getString("writeid");
				String content = rs.getString("content");
				Date regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
			    count =rs.getInt("count");
				
				//조회 된 값을 입력하여 초기화하는 생성자 생성
				Notice ns = new Notice(id1, title, writeid, content, regdate, hit);
				list.add(ns);
				//list 에 조회된 값이 저장된 notice 객체 추가		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(con);
			jdbcUtil.close(psmt);
			jdbcUtil.close(rs);
		}
		EtcList el = new EtcList(count, list);
		
		return el;
	}
	
	/* 조회된 글 카운트 */
	public int getCount(String field, String qurry, String rank) {
		
		int count = 0;
		String sql = "select count(*) as count"
			   	   + "  from notice"
				   + " where useFlag ='Y'"
				   + "   and "+field+" like ?";

		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, "%"+qurry+"%");
			System.out.println(psmt);
			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("count");
				System.out.println("Service :" +count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/*자세히 보기*/
	public Notice getDetail(int no) {
		Notice ns= null;
		String sql = " SELECT tb.id, bm.board_name, tb.title, tb.writeid, tb.content, tb.regdate, tb.hit "
				+ "      FROM tbl_board tb, "
				+ "	          board_master bm "
				+ "     WHERE bm.board_id = tb.boardid "
				+ "       AND tb.useFlag = 'Y' "
				+ "       AND tb.id = ?  ";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, no);
			System.out.println(psmt);
			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				String board = rs.getString("board_name");
				int id1 = rs.getInt("id");
				String title = rs.getString("title");
				String writeid = rs.getString("writeid");
				String content = rs.getString("content");
				Date regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");

			    ns = new Notice(board, id1, title, writeid, content, regdate, hit);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ns;
	}

	/* 글 쓰기 */
	public int regeditNotice(String writeid, String title, String content) {
		String sql = "insert into notice(title, writeid, content) values(?,?,?)";
		int result = 0;
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, writeid);
			psmt.setString(3, content);
			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*글 수정*/
	public int updateContent(int pid, String userId, String title, String content) {
		int result = 0;
		
		Connection con =null;
		PreparedStatement psmt = null;
		
		String sql = "update tbl_board set title = ?, content= ? , writeid= ? "
				   + " where id= ?  "; // 수정 sql

		try {
		    con = ConnectionProvider.getConnection();
		    psmt = con.prepareStatement(sql);
		    psmt.setString(1, title);
		    psmt.setString(2, content);
		    psmt.setString(3, userId);
		    psmt.setInt(4, pid);
		       
			System.out.println(psmt);
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(con);
			jdbcUtil.close(psmt);
		}
		
		return result;	
	}
	
	// hit 수 증가
	public void upHit(int pid) {
		Connection con =null;
		PreparedStatement psmt = null;
		
		String sql = "update tbl_board set hit=hit+1 where id= ? "; // 수정 sql

		try {
		    con = ConnectionProvider.getConnection();
		    psmt = con.prepareStatement(sql);
		    psmt.setInt(1, pid);       
			System.out.println(psmt);
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(con);
			jdbcUtil.close(psmt);
		}
	}
	
	//그림 목록 불러오기
	public List<Picture> getPictureList() {
		String sql = "SELECT * FROM tbl_picture ";
		List<Picture> list = new ArrayList<>(); // list 배열 생성
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement psmt = con.prepareStatement(sql);
			System.out.println(psmt);
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				int id1 = rs.getInt("id");
				String ptitle = rs.getString("ptitle");
				String writeid = rs.getString("writeid");
				String path = rs.getString("path");
				Date regdate = rs.getTimestamp("regdate");

				Picture pt = new Picture(id1, ptitle, writeid, path, regdate);	
				list.add(pt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
