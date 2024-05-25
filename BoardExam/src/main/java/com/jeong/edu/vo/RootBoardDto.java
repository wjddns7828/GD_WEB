package com.jeong.edu.vo;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class RootBoardDto {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String regdate;
	
	private List<ReplyBoardDto> rdto;
	private List<FileDto> fdto;
	
	public RootBoardDto(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
}
