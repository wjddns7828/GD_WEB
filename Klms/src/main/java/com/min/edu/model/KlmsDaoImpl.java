package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.KlmsVo;

public class KlmsDaoImpl implements KlmsDao {
	private Logger log = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.KlmsDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();

	@Override
	public List<KlmsVo> Fplayer_select(KlmsVo vo) {
		SqlSession session = manager.openSession();
		List<KlmsVo> lists = session.selectList(NS+"Fplayer_select",vo);
		return lists;
	}
	@Override
	public int team_FCheck(String team_id) {
		SqlSession session = manager.openSession(false);
		Integer fCnt = session.selectOne(NS+"FCnt",team_id);
		return fCnt;
	}

	@Override
	public int player_add(KlmsVo vo) {
		SqlSession session = manager.openSession(true);
		int n = session.insert(NS+"player_add",vo);	
		return n;
	}

	@Override
	public int team_delete(KlmsVo vo) {
		SqlSession session= manager.openSession(true);
		int isc = session.update(NS+"updateTeamID",vo);
		if(isc >0) {
			return session.delete(NS+"delTeam",vo);
		}else {
			System.out.println("업데이트 실패");
			return 0;
		}
	}
	@Override
	public int schedule_add(KlmsVo vo) {
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"schedule_add", vo);
	}
	@Override
	public boolean schedule_update(KlmsVo vo) {
		SqlSession session = manager.openSession(true);
		int n = session.update(NS+"schedule_update", vo);
		return (n>0)?true:false;
	}
	   @Override
	   public int player_delete(Map<String, Object> map) {
	      SqlSession session = manager.openSession(true);
	      int n2 = session.delete(NS+"player_delete",map);
	      return n2;
	   }
	   @Override
	   public List<KlmsVo> player_tallFw(String position) {
	      SqlSession session = manager.openSession(false);
	      List<KlmsVo> lists = session.selectOne(NS+"player_tallFw",position);
	      return lists;
	   }
	
	public boolean player_update(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int n = session.update(NS+"player_update",map);
		return (n>0)?true:false;
	}
}
