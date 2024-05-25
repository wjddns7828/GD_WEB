package com.min.edu.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.database.SqlSessionFactorymanager;
import com.min.edu.dto.AnswerBoardDTO;

public class AnswerBoardDaoImpl implements IAnswerBoardDao {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.AnswerBoardDaoImpl.";
	private SqlSessionFactory manager;
	
	public AnswerBoardDaoImpl() {
		manager = SqlSessionFactorymanager.getFactory();
	}
	
	@Override
	public List<AnswerBoardDTO> selectAllBoard() {
		logger.info(this.getClass().getSigners()+"selectAllBoard");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"selectAllBoard");
	}

	@Override
	public AnswerBoardDTO selectDetailBoard(String seq) {
		logger.info(this.getClass().getSigners()+"selectDetailBoard");
		SqlSession session = manager.openSession();
		return (AnswerBoardDTO) session.selectList(NS+"selectDetailBoard",seq).get(0);
	}

	@Override
	public boolean reply(AnswerBoardDTO dto) {
		logger.info(this.getClass()+"reply 답글 작성 : 부모의 sesq" + dto.getSeq()+"/"+dto);
		SqlSession session = manager.openSession();
		int replyUp = session.update(NS+"replyupdate",dto);
		int replyIn = session.insert(NS+"replyInsert",dto);
		logger.info("답글 결과 : "+replyIn +"/"+ replyUp);
		session.commit();
		return (replyUp+replyIn>0)?true:false;
	}

	@Override
	public boolean modifyBoard(Map<String, Object> map) {
		logger.info(this.getClass()+"modifyBoard 글수정 "+map);
		SqlSession session = manager.openSession(true);
		int row = session.update(NS+"modifyBoard",map);
		return row>0?true:false;
	}

	@Override
	public boolean deleteBoard(String[] seq) {
		logger.info(this.getClass()+"deleteBoard 글삭제"+Arrays.toString(seq));
		SqlSession session = manager.openSession();
		int cnt = 0;
		for (int i = 0; i < seq.length; i++) {
			cnt += session.update(NS+"deleteBoard",seq[i]);
		}
		session.commit();
		return cnt==seq.length?true:false;
	}

	@Override
	public boolean insertBoard(AnswerBoardDTO dto) {
		logger.info(this.getClass()+"Root글 작성"+dto);
		SqlSession session = manager.openSession(true);
		int row = session.insert(NS+"insertBoard",dto);
		
		return row>0?true:false;
	}

	@Override
	public boolean deleteBoardReal(String seq) {
		logger.info(this.getClass()+"deleteBoardReal"+seq);
		SqlSession session = manager.openSession(true);
		int row = session.delete(NS+"deleteBoardReal",seq);
		return row>0?true:false;
	}

	@Override
	public int multiDelete2(Map<String, String[]> map) {
		logger.info(this.getClass()+"multiDelete2"+map);
		SqlSession session = manager.openSession(true);
		int row = session.update(NS+"multiDelete2",map);
		return row;
	}

}
