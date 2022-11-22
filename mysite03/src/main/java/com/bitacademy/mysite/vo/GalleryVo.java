package com.bitacademy.mysite.vo;

public class GalleryVo {
	private Long no;
	private String url;
	private String commetns;
	
	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", url=" + url + ", commetns=" + commetns + "]";
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCommetns() {
		return commetns;
	}
	public void setCommetns(String commetns) {
		this.commetns = commetns;
	}
	
}
