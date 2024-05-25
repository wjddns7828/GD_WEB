--잡리스트 가져오기
-- 전체의 결과를 쿼리를 통해서  반환한다 여러개를 => 이동하는 객체는 JOBS컬럼과 일대일로 모든 컬럼이 매핑되어 있어야한다
SELECT JOB_ID , JOB_TITLE , MIN_SALARY ,MAX_SALARY 
	FROM JOBS j 
	ORDER BY JOB_ID ;
	
-- 해당 JOB_ID에 포함되어 있는 직원은 조회
-- 모든컬럼들이 매핑되지 않고 특정한 컬럼의 타입의 갯수로 매핑이 된다
-- 입력값은 JOB_ID를 입력 받는다
SELECT EMPLOYEE_ID , FIRST_NAME ||' ' || LAST_NAME , EMAIL , PHONE_NUMBER, JOB_TITLE
	FROM EMPLOYEES e JOIN JOBS j 
	USING(JOB_ID)
	WHERE JOB_ID = 'PU_CLERK';
