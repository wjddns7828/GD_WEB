package com.min.edu.dto;

public class Job_Dto {
	
	private String job_id;
	private String job_title;
	private String min_salary;
	private String max_salary;
	
	public Job_Dto(){
		
	}

	public Job_Dto(String job_id, String job_title, String min_salary, String max_salary) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(String min_salary) {
		this.min_salary = min_salary;
	}

	public String getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(String max_salary) {
		this.max_salary = max_salary;
	}
	
}
