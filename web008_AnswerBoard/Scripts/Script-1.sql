SELECT *
	FROM USERINFO u 
	ORDER BY AUTH ASC;
	
SELECT *
	FROM USERINFO u 
		WHERE AUTH='A'
		OR AUTH='U';
	
/* 예약 떄 많이 쓰는 쿼리문*/
SELECT ID, NAME, EMAIL, 
	CASE AUTH WHEN 'U' THEN'1' WHEN 'A' THEN'2'END AS AUTH,
	DELFLAG, JOINDATE 
	FROM USERINFO u 
		ORDER BY AUTH DESC;