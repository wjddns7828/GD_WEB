package com.min.edu.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 3427238536564619829L;
	
	private String seq;
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String enable;
	private String auth;
	public UserDTO() {
	}
	public UserDTO(String id, String password, String name, String address, String phone, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UserDTO [seq=" + seq + ", id=" + id + ", password=" + password + ", name=" + name + ", address="
				+ address + ", phone=" + phone + ", email=" + email + ", enable=" + enable + ", auth=" + auth + "]";
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	
}
