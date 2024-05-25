package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Player_DTO4;
import com.min.edu.dto.Player_DTO5;
import com.min.edu.dto.Team_DTO;
import com.min.edu.dto.Team_DTO5;

public interface IsocerDao {
	
	//TODO 01-00 이전의 단일 테이블 처리방식
	
	/* 
	 * 하나의 DTO에 두개의 테이블 컬럼과 매핑된 getter/setter를 모두 작성하여 매핑
	 * 하나의 객체에 너무 많은 컬럼의 갯수가 많은 경우 복잡도 및 객체의 메모리가 증가한다 
	 */
	public List<All_Dto> joinCombine01();
	
	//TODO 02-00 각 테이블의 객체를 만들고, 하나(부모)의 객체에 자식 객체를 맴버필드로 만들어 사용
	/*
	 * 복잡도 감소 / 1:1인 테이블
	 * 각 객체를 단일로 사용 할 수 있음 
	 */
	public List<Team_DTO> joinCombine02();
	
	//TODO 03_00 myBatis의 Collection 문법을 사용하여 1:1 처리
	/*
	 * 코드의 가독성이 좋아짐
	 */
	public List<Team_DTO> joinCombine03();
	
	//TODO 04_00 myBatis의 Collection 문법을 사용하여 1:1 처리 player->Team
		/*
		 * 부모테이블(Team)의 소속되지않고 player가 team을 소속하여 사용
		 */
	public List<Player_DTO4> joinCombine04();
	
	//TODO 05_00 joinCombine03 과 같이 Team(15)를 기준으로 속해있는 player(483)을 각 팀에 ListRow로 만들어 출력하기
			/*
			 * 1:n관계를 가진 테이블의 결과를 조인하는 방식
			 * 출력시 하나의 팀에 여러 선수가 포함되어 있는 1:n관계 객체를 생성 할 수 있다
			 * {
			 * 		"K01" : [
			 * 					{"PLAYER_NAME":"홍길동","POSITION" :"FW"},
			 * 					{"PLAYER_NAME":"또치","POSITION" :"MF"},
			 * 					{"PLAYER_NAME":"둘리","POSITION" :"GK"}
			 * 				]
			 * }
			 * 
			 * 		Map<String,List<Player_DTO>> soccer new HashMap<String,List<Player_DTO>>();
			 * 		List<PlayerDTO> lists = new ArrayList<Player_DTO>;
			 * 		Player_DTO pDTO1 =new PLAYER_DTO("홍길동","FW");
			 * 		Player_DTO pDTO2 =new PLAYER_DTO("또치","MF");
			 * 		Player_DTO pDTO3 =new PLAYER_DTO("둘리","GK");
			 * 		lists.add(pDTO1);
			 * 		lists.add(pDTO2);
			 * 		lists.add(pDTO3);
			 * 		soccer.put("K01",lists);
			 */
			public List<Team_DTO5> joinCombine05();
}
