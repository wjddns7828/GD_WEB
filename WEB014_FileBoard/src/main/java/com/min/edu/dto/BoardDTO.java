package com.min.edu.dto;

import java.util.List;

public class BoardDTO {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String regdate;
	
	private List<FileBoardDTO> filedto;

	
	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BoardDTO(int seq, String id, String title, String content, String regdate, List<FileBoardDTO> filedto) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.filedto = filedto;
	}

	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", regdate="
				+ regdate + ", filedto=" + filedto + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<FileBoardDTO> getFiledto() {
		return filedto;
	}

	public void setFiledto(List<FileBoardDTO> filedto) {
		this.filedto = filedto;
	}

	
	
	
}
