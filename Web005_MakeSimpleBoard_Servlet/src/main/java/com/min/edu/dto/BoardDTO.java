package com.min.edu.dto;

public class BoardDTO {
	private String seq;
	private String writer;
	private String title;
	private String content;
	private String regdate;
	private char delflag;
	
	public BoardDTO() {
	}
	
	public BoardDTO(String writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public char getDelflag() {
		return delflag;
	}
	public void setDelflag(char delflag) {
		this.delflag = delflag;
	}
	
	
}
