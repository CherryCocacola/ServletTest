package com.mvc.web.entity.content;

import java.util.List;

public class EtcList {
	private int count;
	private List<Notice>list;
	
	public EtcList(int count, List<Notice> list) {
		this.count = count;
		this.list = list;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Notice> getList() {
		return list;
	}
	public void setList(List<Notice> list) {
		this.list = list;
	}
}

