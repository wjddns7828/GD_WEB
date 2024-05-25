package com.min.edu.dto;



public class Board_DTO {

	private String title;
	private String writter;
	private String regdate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWritter() {
		return writter;
	}
	public void setWritter(String writter) {
		this.writter = writter;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public Board_DTO(String title, String writter, String regdate) {
		super();
		this.title = title;
		this.writter = writter;
		this.regdate = regdate;
	}
}
