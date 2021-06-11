package com.mvc.web.entity.content;

import java.util.Date;

public class Picture {
	private int id;
	private String ptitle;
	private String writeid;
	private String path;
	private Date regdate;
	
	public Picture(int id, String ptitle, String writeid, String path, Date regdate) {
		this.id = id;
		this.ptitle = ptitle;
		this.writeid = writeid;
		this.path = path;
		this.regdate = regdate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getWriteid() {
		return writeid;
	}
	public void setWriteid(String writeid) {
		this.writeid = writeid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
