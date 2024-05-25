package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.Job_DTO;

public interface IDynamicDao {
	public List<Job_DTO> getJobIf(Map<String, Object> map);
	public List<Job_DTO> getJobList(List<String> lists);
	public List<Job_DTO> getJobMap(Map<String, String[]> map);
	public List<Job_DTO> getJobChoose(Job_DTO dto);
	public List<Job_DTO> getJobTrim(Job_DTO dto);
	public boolean updateJobSet(Job_DTO dto);
	public int updateJobTrim(Job_DTO dto);
}
