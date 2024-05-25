package com.min.edu.dto;

import java.io.Serializable;
import java.util.Date;

public class FileBoardDTO implements Serializable {
	
	private static final long serialVersionUID = -2633613622042607186L;
	
	private int f_seq;
	private int b_seq;
	private String writer;
	private String origin_fname;
	private String stored_fname;
	private int file_size;
	private Date file_regdate;
	private String f_delflag;
	
	public FileBoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FileBoardDTO(int f_seq, int b_seq, String writer, String origin_fname, String stored_fname, int file_size,
			Date file_regdate, String f_delflag) {
		super();
		this.f_seq = f_seq;
		this.b_seq = b_seq;
		this.writer = writer;
		this.origin_fname = origin_fname;
		this.stored_fname = stored_fname;
		this.file_size = file_size;
		this.file_regdate = file_regdate;
		this.f_delflag = f_delflag;
	}
	
	@Override
	public String toString() {
		return "FileBoardDTO [f_seq=" + f_seq + ", b_seq=" + b_seq + ", writer=" + writer + ", origin_fname="
				+ origin_fname + ", stored_fname=" + stored_fname + ", file_size=" + file_size + ", file_regdate="
				+ file_regdate + ", f_delflag=" + f_delflag + "]";
	}
	
	public int getF_seq() {
		return f_seq;
	}
	public void setF_seq(int f_seq) {
		this.f_seq = f_seq;
	}
	public int getB_seq() {
		return b_seq;
	}
	public void setB_seq(int b_seq) {
		this.b_seq = b_seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getOrigin_fname() {
		return origin_fname;
	}
	public void setOrigin_fname(String origin_fname) {
		this.origin_fname = origin_fname;
	}
	public String getStored_fname() {
		return stored_fname;
	}
	public void setStored_fname(String stored_fname) {
		this.stored_fname = stored_fname;
	}
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public Date getFile_regdate() {
		return file_regdate;
	}
	public void setFile_regdate(Date file_regdate) {
		this.file_regdate = file_regdate;
	}
	public String getF_delflag() {
		return f_delflag;
	}
	public void setF_delflag(String f_delflag) {
		this.f_delflag = f_delflag;
	}
}
