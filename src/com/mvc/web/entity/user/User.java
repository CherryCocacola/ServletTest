package com.mvc.web.entity.user;

import java.util.Date;

public class User {
	private String id;
	private String pass;
	private String name;
	private String email;
	private Date regdate; //가입일자
	private String rank;  //사용자 등급
	private int number;   //조회 후 리턴 될 결과 ㄱ밧
	

	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email + ", regdate=" + regdate
				+ ", rank=" + rank + ", number=" + number + "]";
	}
	
	//user 출력 용
	public User(String id, String pass, String name, String email, Date regdate, String rank, int number) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.regdate = regdate;
		this.rank = rank;
		this.number = number;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
