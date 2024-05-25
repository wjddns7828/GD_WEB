package com.min.edu.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.model.KlmsDao;
import com.min.edu.model.KlmsDaoImpl;
import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.KlmsVo;

public class MyBaits_JUnit {
	SqlSession session;
	private KlmsDao dao;
	KlmsVo vo;

	@Before
	public void test() {
		dao = new KlmsDaoImpl();
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	
//	스케쥴 수정
	public void schedule_update() {
		vo = new KlmsVo();
		vo.setStadium_id("C02");
		vo.setSche_date("23/09/02");
		vo.setNew_sche_date("23/09/03");
		boolean isc = dao.schedule_update(vo);
		assertTrue(isc);
	}
	
	
//	스케쥴 등록
	public void schedule_add() {
		vo = new KlmsVo();
		vo.setStadium_id("C02");
		vo.setSche_date("23/09/02");
		vo.setGubun("N");
		vo.setHometeam_id("K01");
		vo.setAwayteam_id("K02");
		int n = dao.schedule_add(vo);
		assertEquals(n, 1);
	}
	
//	외국인 선수 조회
	public void Fplayer_select() {
		vo = new KlmsVo();
		vo.setTeam_id("K02");
		List<KlmsVo> lists = dao.Fplayer_select(vo);
		assertNotNull(lists);
	}
	
	//팀삭제
	public void del_team() {
		vo = new KlmsVo();
		vo.setTeam_id("K03");
		int n = dao.team_delete(vo);
		assertEquals(n, 1);
	}
	
	
	//플레이어 추가
//	@Test
	public void player_add() {
		vo = new KlmsVo();
		vo.setPlayer_id("1256");
		vo.setPlayer_name("임정운");
		vo.setTeam_id("K05");
		vo.setPosition("FW");
		vo.setNation("");
		vo.setHeight(180);
		int FCnt = dao.team_FCheck(vo.getTeam_id());
		if(FCnt < 5) {
			int n =	dao.player_add(vo);
			assertEquals(n, 1);
		}
		else {
			System.out.println("외국인 player는 최대 5명까지 영입가능합니다");
		}
	}
	
	//보유중인 외국인 선수 체크하는 메소드
	public void FCheck() {
		String team_id = "K03";
		Integer FCnt = dao.team_FCheck(team_id);
		System.out.println(FCnt);
		assertTrue(true);
	}
	
	   //선수를 리그 내에서 이적하는 기능
//  @Test
  public void PUpdate() {
     Map<String, Object> map = new HashMap<String, Object>();
     map.put("team_id", "K01");
     map.put("player_name", "김수엽");
     map.put("new_team_id", "K01");
     boolean PU = dao.player_update(map);
     assertTrue(PU);
  }
  //선수를 방출하는 기능
//  @Test
  public void PDelete() {
     Map<String, Object> map = new HashMap<String, Object>();
     map.put("player_name", "김수엽");
     map.put("team_id", "K01");
     int n = dao.player_delete(map);
     assertEquals(n,1);
  }
  // 최장신 공격수(FW)를 조회하는 기능
//  @Test
  public void TSelect() {
     String position = "FW";
     List<KlmsVo> lists = dao.player_tallFw(position);
     System.out.println(lists);
     assertNotNull(lists);
  }
}
