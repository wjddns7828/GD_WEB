package com.jeong.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeong.edu.database.SqlSessionFactoryManager;
import com.jeong.edu.vo.FileDto;
import com.jeong.edu.vo.ReplyBoardDto;
import com.jeong.edu.vo.RootBoardDto;

public class BoardDaoImpl implements IBoardDao {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private String NS = "com.jeong.edu.model.BoardDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	
	@Override
	public int insertBoard(RootBoardDto dto) {
		SqlSession session = manager.openSession(true);
		int n = session.insert(NS+"insertBoard",dto);
		System.out.println(dto.getSeq());
		return n;
	}
	
	@Override
	public int insertFile(FileDto fdto) {
		SqlSession session = manager.openSession(true);
		int n = session.insert(NS+"insertFile",fdto);
		return n;
	}
	
	@Override
	public RootBoardDto getDetailBoard(int seq) {
		SqlSession session = manager.openSession();
		RootBoardDto dto = session.selectOne(NS+"getDetailBoard",seq);
		System.out.println(dto);
		return dto;
	}

	@Override
	public List<ReplyBoardDto> getReply(Map<String,Object> map) {
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getReply",map);
	}

	@Override
	public FileDto getFile(int seq) {
		SqlSession session = manager.openSession();
		FileDto dto = session.selectOne(NS+"getFile",seq);
		System.out.println(dto);
		return dto;
	}

	@Override
	public int getTotalpageCount() {
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getTotalpageCount");
	}

	

}
