package com.min.edu.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.info_DTO;
import com.min.edu.mybatis.SqlDaoSupport;
/**
 * Info 테이블의 기능을 구현한 클래스
 */
public class InfoSelectKeyImpl implements IInfoSelectKey {
	
	private Logger logger = Logger.getLogger(InfoSelectKeyImpl.class);
	private final String Ns = "com.min.edu.model.InfoSelectKeyImpl.";
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	
	@Override
	public int insertINfo(info_DTO dto) {
		logger.info("insertInfo 전달 값은 입력 값:" +dto.getSeq());
		SqlSession session = manager.openSession(true);
		int n = session.insert(Ns+"insertInfo",dto);
		logger.info("insertInfo 입력 후 생성된 getSeq():"+dto.getSeq());
		return n;
	}
	
	@Override
	public info_DTO selectOneInfo(info_DTO dto) {
		logger.info("insertInfo 전달받은 getSeq() 값:" +dto.getSeq());
		SqlSession session =  manager.openSession(false);
		info_DTO resultDto = session.selectOne(Ns+"selectOneInfo",dto);
		
		return resultDto;
	}
}
