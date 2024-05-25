package com.min.edu.dto;

import java.io.Serializable;



public class Job_DTO implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = -6576782947177986730L;
	private String jobId; //JOB_ID 매핑
	private String jobTitle; //JOB_TITLE 매핑
	private int minSalary; //MIN_SAL 매핑
	private int maxSalary; //MAX_SAL 매핑
	
	public Job_DTO() {
		super();
	}
	
	public Job_DTO(String jobId, String jobTitle, int minSalary, int maxSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	public int getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Job_DTO [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + "]";
	}
	
	}
