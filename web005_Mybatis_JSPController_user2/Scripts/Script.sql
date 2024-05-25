CREATE TABLE MEMBERINFO(
	SEQ NUMBER,
	ID VARCHAR2(20) NOT NULL,
	PASSWORD VARCHAR2(40)NOT NULL,
	NAME VARCHAR2(20) NOT NULL,
	ADDRESS VARCHAR2(500) NOT NULL,
	PHONE VARCHAR2(11),
	EMAIL VARCHAR2(100) NOT NULL,
	ENABLE VARCHAR2(2) NOT NULL,
	AUTH VARCHAR2(10) NOT NULL,
	
	CONSTRAINT MEMBERINFO_PK PRIMARY KEY (SEQ),
	CONSTRAINT MEMBERINFO_UK UNIQUE(ID,EMAIL)	
);

CREATE SEQUENCE MEMBERINFO_SEQ START WITH 1 INCREMENT BY 1;

--전체 사용자 조회
SELECT SEQ, ID, NAME, ADDRESS, PHONE, EMAIL, ENABLE, AUTH
	FROM MEMBERINFO;

--전체 사용자 조회(사용가능 회원)

SELECT SEQ, ID, NAME, ADDRESS, PHONE, EMAIL, ENABLE, AUTH
	FROM MEMBERINFO
		WHERE ENABLE = 'Y';
		
--권한 수정(USER / ADMIN)
UPDATE MEMBERINFO SET AUTH = 'ADMIN' WHERE SEQ='1';

--사용자 입력(DUMMY TABLE)
INSERT INTO MEMBERINFO (SEQ, ID, PASSWORD, NAME, 
						ADDRESS, PHONE, EMAIL, 
						ENABLE, AUTH)
	VALUES(MEMBERINFO_SEQ.NEXTVAL,'USER','1234','유저',
									'서울','555','USER@gmail.com',
									'N','USER');
								
INSERT INTO MEMBERINFO (SEQ, ID, PASSWORD, NAME, 
						ADDRESS, PHONE, EMAIL, 
						ENABLE, AUTH)
	VALUES(MEMBERINFO_SEQ.NEXTVAL,'ADMIN','1234','관리자',
									'삼실','111','admin@info.com',
									'Y','AUTH');
--23.06.30
--요구사항 변경 대소문자에 관계없이 로그인이 될 수 있도록 변경
--로그인								
SELECT SEQ, ID, NAME, ADDRESS, PHONE, EMAIL, ENABLE, AUTH
	FROM MEMBERINFO
	WHERE ID='USER' AND PASSWORD='1234'
		AND ENABLE='N';
	
SELECT SEQ, ID, NAME, ADDRESS, PHONE, EMAIL, ENABLE, AUTH
	FROM MEMBERINFO
	WHERE UPPER(ID)=UPPER('rainbow') AND PASSWORD='1234'
		AND ENABLE='Y';

--사용자 정보
SELECT SEQ, ID, NAME, ADDRESS, PHONE, EMAIL, ENABLE, AUTH
	FROM MEMBERINFO
	WHERE SEQ='1';

--사용자 수정
UPDATE MEMBERINFO SET ADDRESS ='',PHONE='',EMAIL=''
	WHERE SEQ='1';

--사용자 삭제
UPDATE MEMBERINFO SET ENABLE = 'N'
	WHERE SEQ ='1';

--아이디 중복검사
SELECT COUNT(*)
	FROM MEMBERINFO m 
		WHERE ID='USER';
	


								
								
								
								
								
								
								
								
								
								
								
								
								
