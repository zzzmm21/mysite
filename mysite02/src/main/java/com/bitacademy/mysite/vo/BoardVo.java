package com.bitacademy.mysite.vo;

public class BoardVo {
	private Long no;
	private Long groupno;
	private Long hit;
	private String regdate;
	private Long orderno;
	private Long depth;
	private String contents;
	private String title;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getGroupno() {
		return groupno;
	}
	public void setGroupno(Long groupno) {
		this.groupno = groupno;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public Long getOrderno() {
		return orderno;
	}
	public void setOrderno(Long orderno) {
		this.orderno = orderno;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getUserno() {
		return userno;
	}
	public void setUserno(Long userno) {
		this.userno = userno;
	}
	private Long userno;
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", groupno=" + groupno + ", hit=" + hit + ", regdate=" + regdate + ", orderno="
				+ orderno + ", depth=" + depth + ", contents=" + contents + ", title=" + title + ", userno=" + userno
				+ "]";
	}
	
}
