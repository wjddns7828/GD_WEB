package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.JobVo;

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
	
	/**
	 * parameter는 Primitive 타입으로 전송 받음
	 * 결과는 전체 컬럼과 Mapping되어 있는 JobVO를 통해서 전달 받는다
	 * 쿼리에서 공집합이 나오면 ==> null
	 * Mapping이기 때문에 getter/setter의 이름이 맞춰있어야함
	 */
	public JobVo select02(String job_id);
	
	public JobVo select03(String job_id);
	
	/**
	 * 결과를 {특정컬럼:DTO/VO} 
	 */
	public Map<String,JobVo> select04();
	
	/**
	 * 결고라르 한개만 받음, NullPointException방지를 위해서
	 *  SelectList로 처리하고
	 *  여러개의 arguments를 필요로함 , 하지만 myBatis에서는 여러개의 arguments를 받는 문법은 없음
	 *  따라서 DTO/VO혹은 Map을 통해서 전달해야함
	 */
	public List<JobVo> select05(JobVo vo);
	
	/**
	 * Map객체를 통해서 여러개의 값을 DTO/VO없이 arguments를 전송한다.
	 * DTO/VO는 getter/setter의 이름이 정해져 있음
	 * Map은 Key를 정해줘야함 로그/설계도 반드시 적어두셔야함
	 */
	public JobVo select06 (Map<String, Object> map);
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public List<JobVo> select07 (Object obj);
	
}
