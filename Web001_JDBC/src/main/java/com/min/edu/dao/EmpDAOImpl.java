package com.min.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.min.edu.comm.DataBase;
import com.min.edu.dto.Emp_DTO;

public class EmpDAOImpl extends DataBase implements IEmpDAO {

	@Override
	public List<Emp_DTO> getAllemp() {
		List<Emp_DTO> lists = new ArrayList<Emp_DTO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT EMPNO, ENAME, JOB, TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE "
				+ "	FROM EMP ";
		try {
			conn = getConnection();
			System.out.println("2단계 커넥션로딩 성공");
			stmt = conn.prepareStatement(sql);
			System.out.println("3단계 쿼리 준비 성공");
			
			rs = stmt.executeQuery();
			System.out.println("4단계 쿼리 실행 성공");
			
			while (rs.next()) {
				Emp_DTO dto = new Emp_DTO();
				dto.setEmpno(rs.getInt(1));
				dto.setEname(rs.getString(2));
				dto.setJob(rs.getString(3));
				dto.setHiredate(rs.getString(4));
				lists.add(dto);
			}
			System.out.println("5단계 결과값 받기 성공");
		} catch (SQLException e) {
			System.out.println("getAllemp 실패");
			e.printStackTrace();
		} finally {
			closed(rs, stmt, conn);
		}
		return lists;
	}

	@Override
	public Emp_DTO getOneemp(int empno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		return null;
	}

}
