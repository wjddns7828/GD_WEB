package com.min.edu.dao;

import java.util.List;

import com.min.edu.dto.Emp_DTO;

public interface IEmpDAO {
	public List<Emp_DTO> getAllemp();
	public Emp_DTO getOneemp(int empno);
	

}
