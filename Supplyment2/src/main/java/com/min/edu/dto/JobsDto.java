package com.min.edu.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class JobsDto {
	private String job_id;
	private String job_title;
	private String min_salary;
	private String max_salary;
}
