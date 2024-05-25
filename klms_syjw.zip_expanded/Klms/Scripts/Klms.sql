SELECT *
	FROM PLAYER;
	
--쿼리테스트

--KLMS01001 선수영입기능 player_add
INSERT INTO PLAYER p (PLAYER_ID,PLAYER_NAME,TEAM_ID,"POSITION",NATION,HEIGHT) 
	VALUES('1111111','김수엽','K05','FW','대한민국','180');

SELECT *
	FROM PLAYER p 
	WHERE PLAYER_NAME = '김수엽';

--KLMS01002 리그 내 이적기능 player_update

UPDATE PLAYER SET TEAM_ID = 'K02'
	WHERE PLAYER_NAME = '김수엽';

SELECT *
	FROM PLAYER p 
	WHERE PLAYER_NAME = '김수엽';

--KLMS01003 선수 방출기능 player_delete

DELETE FROM PLAYER p 
	WHERE PLAYER_NAME = '김수엽'
		AND TEAM_ID = 'K05';

SELECT *
	FROM PLAYER p 
	WHERE PLAYER_NAME = '김수엽';

--KLMS01004 팀별 소속된 외국인선수 조회기능 Fplayer_select

SELECT TEAM_NAME ,NATION
	FROM TEAM t JOIN PLAYER p
	ON P.TEAM_ID  = T.TEAM_ID 
	WHERE NATION IS NOT NULL ;

--KLMS01005 최장신 공격수 player_tallFw
SELECT * 
	FROM PLAYER p 
	WHERE HEIGHT = (SELECT MAX(HEIGHT) FROM PLAYER p2); 










	
	







