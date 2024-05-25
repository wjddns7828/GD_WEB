package com.min.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CalendarDto {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String mdate;
	private String regdate;
	
	public CalendarDto(String id, String title, String content, String mdate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.mdate = mdate;
	}
}
