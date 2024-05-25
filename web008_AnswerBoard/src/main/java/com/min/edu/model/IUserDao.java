package com.min.edu.model;

import java.util.Map;

import com.min.edu.dto.UserVo;

public interface IUserDao {
	/**
	 * 화면에서 아이디와 비밀번호를 입력받아 정보를 반환함
	 * @param id,password의 키를 map
	 * @return 회원의 정보를 ID,NAME,EMAIL,AUTH
	 */
	public UserVo loginSelect(Map<String, Object> map);
}
