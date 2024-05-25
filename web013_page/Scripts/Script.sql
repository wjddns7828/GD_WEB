INSERT INTO HR.EMPLOYEES
	(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID)
VALUES(, '', '', '', '', '', '', 0, 0, 0, 0);

INSERT INTO USERINFO (ID, NAME, PASSWORD, 
								EMAIL, AUTH, DELFLAG,
								JOIND)
			VALUES('sdfasdf', '소현', '1234', 
					'sd@gmail.omc', 'U', 'N',
					SYSDATE);
					
SELECT ID, NAME, EMAIL, AUTH, DELFLAG, JOINDATE
	FROM USERINFO u
	WHERE ID = 'hello' AND PASSWORD = '1234';



-- file board
CREATE TABLE BOARD(
	B_SEQ NUMBER PRIMARY KEY, 
	TITLE VARCHAR2(500), 
	WRITER VARCHAR2(20), 
	CONTENT VARCHAR2(2000), 
	REGDATE DATE DEFAULT SYSDATE, 
	DELFLAG CHAR(1) DEFAULT 'N'
);

CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE REPLY(
	R_SEQ NUMBER PRIMARY KEY,
	B_SEQ NUMBER, 
	WRITER VARCHAR2(20), 
	CONTENT VARCHAR2(2000), 
	REGDATE DATE DEFAULT SYSDATE, 
	DELFLAG CHAR(1) DEFAULT 'N'
);

CREATE SEQUENCE REPLY_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE FILEFILE(
	F_SEQ NUMBER PRIMARY KEY,
	B_SEQ NUMBER NOT NULL,
	WRITER VARCHAR2(200),
	ORIGIN_FNAME VARCHAR2(1000) NOT NULL,
	STORED_FNAME VARCHAR2(1000) NOT NULL,
	FILE_SIZE NUMBER NOT NULL,
	F_REGDATE DATE DEFAULT SYSDATE NOT NULL,
	F_DELFLAG CHAR(1) DEFAULT 'N' NOT NULL
);

CREATE SEQUENCE FILEFILE_SEQ START WITH 1 INCREMENT BY 1;

INSERT INTO HR.BOARD(B_SEQ, TITLE, WRITER, CONTENT)
		VALUES(BOARD_SEQ.NEXTVAL, '', '', '');
	
INSERT INTO HR.REPLY(R_SEQ, B_SEQ, WRITER, CONTENT)
		VALUES(REPLY_SEQ.NEXTVAL, 0, '', '');

INSERT INTO HR.FILEFILE(F_SEQ, B_SEQ, WRITER, ORIGIN_FNAME, STORED_FNAME, FILE_SIZE)
		VALUES(0, 0, '', '', '', 0);

-- 목록 조회 
SELECT B_SEQ, TITLE || '(' || (SELECT COUNT(*)
									FROM REPLY r
									WHERE b.B_SEQ = r.B_SEQ) || ')' AS TITLE, 
		WRITER, REGDATE , DELFLAG
	FROM BOARD b ;

-- 상세 조회
SELECT B_SEQ, TITLE, WRITER, CONTENT, REGDATE , DELFLAG
	FROM BOARD b;
	
SELECT R_SEQ, B_SEQ, WRITER , CONTENT , REGDATE , DELFLAG 
	FROM REPLY r ;
	
SELECT F_SEQ, B_SEQ , WRITER , ORIGIN_FNAME , STORED_FNAME , FILE_SIZE , F_REGDATE , F_DELFLAG 
	FROM FILEFILE f ;

SELECT F_SEQ, ORIGIN_FNAME 
	FROM FILEFILE f 
	WHERE B_SEQ='';

SELECT FILEFILE_SEQ.CURRVAL
	FROM DUAL;

INSERT ALL
		INTO HR.FILEFILE(F_SEQ, B_SEQ, WRITER, ORIGIN_FNAME, STORED_FNAME, FILE_SIZE)
		VALUES(FILEFILE_SEQ.NEXTVAL, '1', '1', '1', '1', '1')
		INTO HR.FILEFILE(F_SEQ, B_SEQ, WRITER, ORIGIN_FNAME, STORED_FNAME, FILE_SIZE)
		VALUES(FILEFILE_SEQ.NEXTVAL, '1', '1', '1', '1', '1')
	SELECT * FROM DUAL
