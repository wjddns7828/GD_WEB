package com.min.edu.dto;

public class UserInfo_DTO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String auth;
	
	
	public UserInfo_DTO(String id, String pw, String name, String phone, String auth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.auth = auth;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserInfo_DTO [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", auth=" + auth + "]";
	}	
	
	
}
