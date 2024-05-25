package com.min.edu.dto;

/*
 * -- 모든컬럼들이 매핑되지 않고 특정한 컬럼의 타입의 갯수로 매핑이 된다
	-- 입력값은 JOB_ID를 입력 받는다
	EMPLOYEE_ID , FIRST_NAME ||' ' || LAST_NAME , EMAIL , PHONE_NUMBER, JOB_TITLE
 */
public class EmployeesDto {
	private Integer employee_id;
	private String name;
	private String email;
	private String phone;
	private String jobTitle;
	
	public EmployeesDto() {
	}

	public EmployeesDto(Integer employee_id, String name, String email, String phone, String jobTitle) {
		this.employee_id = employee_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "EmployeesDto ***employee_id=" + employee_id + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", jobTitle=" + jobTitle + "***";
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
}
