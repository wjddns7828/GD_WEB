SELECT JOB_ID, JOB_TITLE, MIN_SALARY,MAX_SALARY
	FROM JOB;
	
SELECT JOB_ID, JOB_TITLE, MIN_SALARY,MAX_SALARY
	FROM JOB
		WHERE JOB_ID='AD_PRES';
		
INSERT INTO JOB j 
	VALUES('IT','PROGRAMMER',1000,2000);
	
UPDATE JOB 
	SET JOB_TITLE='Developer'
		WHERE JOB_ID='IT';
DELETE FROM JOB j 
	WHERE JOB_ID='IT';
	