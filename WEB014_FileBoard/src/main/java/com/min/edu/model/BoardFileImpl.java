package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.BoardDTO;
import com.min.edu.dto.FileBoardDTO;


public class BoardFileImpl implements IBoardFile {

	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.BoardFileImpl.";
	@Override
	public List<BoardDTO> getAllList() {
		logger.info("전체 조회 - 파일갯수 포함");
		SqlSession session = manager.openSession();
		List<BoardDTO> lists = session.selectList(NS+"getAllList");
		return lists;
	}

	@Override
	public boolean insertBoard(BoardDTO bDto, FileBoardDTO fDto) {
		logger.info("새글 및 파일 작성");
		int cnt = 0;
		SqlSession session = manager.openSession(false);
		try {
			cnt+= session.insert(NS+"insertBoard",bDto);
			fDto.setB_seq(bDto.getSeq());
			cnt+= session.insert(NS+"insertFile",fDto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}		
		return cnt>0?true:false;
	}

	@Override
	public FileBoardDTO getFile(String seq) {
		logger.info("파일 가져오기");
		SqlSession session = manager.openSession();
		FileBoardDTO dto =  session.selectOne(NS+"getFile",seq);
		return dto;
	}

	@Override
	public List<BoardDTO> getBoard(String seq) {
		logger.info("게시글 상세 + 파일");
		SqlSession session = manager.openSession();
		List<BoardDTO> lists = session.selectList(NS+"getBoard",seq);
		
		return lists;
	}

}
