package com.min.edu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.BoardDTO;
import com.min.edu.support.SqlSessionFactoryManager;

public class BoardDAOImpl implements IBoardDAO {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.dao.BoardDAOImpl.";
	
	@Override
	public List<BoardDTO> getAllBoard() {
		logger.info("getAllBoard 실행");
		SqlSession session = manager.openSession();
		List<BoardDTO> lists =  session.selectList(NS+"getAllBoard");
		return lists;
	}
	
	@Override
	public int setInsertBoard(String title, String writer, String Content) {
		logger.info("setInsertBoard 실행");
		SqlSession session = manager.openSession(true);
		BoardDTO dto = new BoardDTO(title,writer,Content);
		int n =  session.insert(NS+"setInsertBoard",dto);
		return n;
	}
	@Override
	public BoardDTO getOneboard(String title) {
		logger.info("getOneboard 실행");
		SqlSession session = manager.openSession();
		BoardDTO dto =  session.selectOne(NS+"getOneboard",title);
		return dto;
	}
	
	@Override
	public int setDeleteBoard(String seq) {
		logger.info("setDeleteBoard 실행");
		SqlSession session = manager.openSession(true);
		int n = session.update(NS+"setDeleteBoard",seq);
		return n;
	}
	@Override
	public int setUpdateBoard(Map<String, Object> map) {
		logger.info("setDeleteBoard 실행");
		SqlSession session = manager.openSession(true);
		int n = session.update(NS+"setUpdateBoard",map);
		return n;
	}
	
}
