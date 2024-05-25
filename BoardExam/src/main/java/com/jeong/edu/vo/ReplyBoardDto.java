package com.jeong.edu.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReplyBoardDto {
	private String seq;
	private int ref;
	private String title;
	private String regdate;
}
