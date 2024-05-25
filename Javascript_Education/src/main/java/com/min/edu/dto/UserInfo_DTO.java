package com.min.edu.dto;

public class UserInfo_DTO {
	
	private String name;
	private String id;
	private String address;
	private String auth;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}

	public UserInfo_DTO(String name, String id, String address, String auth) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.auth = auth;
	}
	
	
}
