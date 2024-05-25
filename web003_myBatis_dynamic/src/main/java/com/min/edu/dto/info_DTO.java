package com.min.edu.dto;

import java.io.Serializable;

import org.apache.ibatis.javassist.SerialVersionUID;

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
@NoArgsConstructor
@AllArgsConstructor
public class info_DTO implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -3896725884893362094L;
	private int seq; 
	private String name;
	private String phone; 
	private String auth;
	private String regdate;
}
