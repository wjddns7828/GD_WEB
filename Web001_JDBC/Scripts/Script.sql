
--전체 조회
SELECT EMPNO, ENAME, JOB, TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE
	FROM EMP;

--상세 조회
SELECT ENAME, JOB , SAL, TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE, NVL(COMM,0) COMM 
	FROM EMP e 
		WHERE EMPNO ='7369';