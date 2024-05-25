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
public class FileDto {
	private int f_seq;
	private int b_seq;
	private String writer;
	private String origin_fname;
	private String stored_fname;
	private int file_size;
	private String f_regdate;
	private String f_delflag;
	
	public FileDto(int b_seq, String writer, String origin_fname, String stored_fname, int file_size) {
		super();
		this.b_seq = b_seq;
		this.writer = writer;
		this.origin_fname = origin_fname;
		this.stored_fname = stored_fname;
		this.file_size = file_size;
	}
}