package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.All_DTO;

public interface IEmpDao {
	public List<All_DTO> selectAll();
}
