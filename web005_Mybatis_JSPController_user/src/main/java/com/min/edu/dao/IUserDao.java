package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.UserDTO;

/**
 * MemberInfo 테이블을 활용한 웹 Application 사용자 기능 
 * @author 임정운
 * @since 23-06-30
 *
 */
public interface IUserDao {

	/**
	 * 전체 사용자 조회 USER0001
	 * @return 사용자 조회
	 */
	public List<UserDTO> getAllUserStatus(); 
	/**
	 * 전체 사용자 조회	사용되고 있는 계정만 조회하는 기능 USER0002
	 * @return 사용자 조회
	 */
	public List<UserDTO>getAllUser();
	/**
	 * 권한 수정 USER0003
	 * @param Map 권환 (Admin,User)
	 * @return 성공한 row의 갯수
	 */
	public int updateAuthUser(Map<String, Object>inMap);
	
	/**
	 * 일반 사용자 입력 USER0004
	 * @param DTO 사용자 정보 입력
	 * @return 성공한 row의 갯수
	 */
	public int insertUser(UserDTO inDto);
	
	/**
	 * 사용자 로그인 정보 USER0005
	 * @param Map 아이디, 비밀번호
	 * @return 사용자 정보
	 */
	public UserDTO getLogin(Map<String,Object> inMap);
	
	/**
	 * 사용자 상세정보 조회 USER0006
	 * @param seq (pk값)
	 * @return 사용자 상세정보(UserDTO)
	 */
	public UserDTO getUserInfo (String seq);
	/**
	 * 사용자 정보 수정 USER0007
	 * @param Map ADDRESS, PHONE, EMAIL, SEQ
	 * @return 성공한 Row 갯수
	 */
	public int updateUserInfo(Map<String, Object> inMap);
	/**
	 * 사용자 삭제 (Update) USER0008
	 * @param seq(pk값)
	 * @return 성공한 row의 갯수
	 */
	public int delUser(String seq);
	/**
	 * 아이디 중복 검사 USER0009
	 * @param id 사용가능 여부판단 ID 입력
	 * @return 1사용불가 0사용가능
	 */
	public int dupulicateId(String id);
}
