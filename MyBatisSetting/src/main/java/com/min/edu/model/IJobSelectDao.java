package com.min.edu.model;
/**
 * myBatis에서 작동되는 Select의 기능의 상세
 *
 */
public interface IJobSelectDao {
	/**
	 * parameter의 전송 방식: Primitive Type
	 * result Type : Integer
	 * myBatis에서 전송받은 값의 입력 방식(preparedStatement) jdbc:?
	 * #,$사용
	 */
	public Integer select01(String id);
}
