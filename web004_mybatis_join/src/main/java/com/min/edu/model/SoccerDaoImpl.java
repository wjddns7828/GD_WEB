package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Player_DTO4;
import com.min.edu.dto.Player_DTO5;
import com.min.edu.dto.Team_DTO;
import com.min.edu.dto.Team_DTO5;
import com.min.edu.manager.SqlSessionFactoryManager;

public class SoccerDaoImpl implements IsocerDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS1 = "com.min.edu.join01.";
	private final String NS2 = "com.min.edu.join02.";
	private final String NS3 = "com.min.edu.join03.";
	private final String NS4 = "com.min.edu.join04.";
	private final String NS5 = "com.min.edu.join05.";
	
	//TODO 01-02 joinCombine01 Dao
	@Override
	public List<All_Dto> joinCombine01() {
		logger.info("하나의 단일 DTO 조인 매핑");
		SqlSession session = manager.openSession();
		List<All_Dto> lists= session.selectList(NS1+"joinCombine01");
		return lists;
	}
	
	//TODO 02-02 joinCombine02  Dao
	@Override
	public List<Team_DTO> joinCombine02() {
		logger.info("하나의 객체에 소속된 DTO 조인");
		SqlSession session = manager.openSession();
		List<Team_DTO> lists= session.selectList(NS2+"joinCombine02");
		return lists;
	}
	
	//TODO 03-02  joinCombine03 Dao
	@Override
	public List<Team_DTO> joinCombine03() {
		logger.info("하나의 객체에 소속된 DTO 조인 Team -> Player");
		SqlSession session = manager.openSession();
		List<Team_DTO> lists= session.selectList(NS3+"joinCombine03");
		return lists;
	}
	//TODO 04-02 joinCombine04 Dao
	@Override
	public List<Player_DTO4> joinCombine04() {
		logger.info("하나의 객체에 소속된 DTO 조인 Player->Team");
		SqlSession session = manager.openSession();
		List<Player_DTO4> lists= session.selectList(NS4+"joinCombine04");
		return lists;
	}
	
	//TODO 05-02 joinCombine04 Dao
	@Override
	public List<Team_DTO5> joinCombine05() {
		logger.info("Team에 소속된 Player의 List로 join");
		SqlSession session = manager.openSession();
		List<Team_DTO5> lists= session.selectList(NS5+"joinCombine05");
		return lists;
	}
}
