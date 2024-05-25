package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerBoardDTO;

public interface IAnswerBoardDao {
	
	/**
	 * 답변형 게시판 전체조회
	 * @return 검색된 여러개 row&raquo AnswerBoardDTO
	 */
	public List<AnswerBoardDTO> selectAllBoard();
	
	/**
	 * 상세 게시글 조회
	 * @param seq
	 * @return 검색된 한개의 row&raquo AnswerBoardDTO
	 */
	public  AnswerBoardDTO selectDetailBoard(String seq);
	
	/**
	 * 답글 작성
	 * Transaction을 통한 Update 후 insert진행
	 * 	replyInsert
	 *	replyupdate
	 * @param AnswerBoardDTO &raquo 부모의 seq와 자식의 데이터 입력값
	 * @return 성공한 row의 갯수를 판단하여 성공 true / 실패 false
	 */
	public boolean reply(AnswerBoardDTO dto);
	
	/**
	 * 게시판에 입력되어 있는 글중 content내용 을 수정
	 * @param map seq, content
	 * @return 성공한 row의 갯수를 판단하여 성공 true / 실패 false
	 */
	public boolean modifyBoard(Map<String, Object> map);
	
	/**
	 * 단일/다중 삭제
	 * @param seq 삭제 대상의 String Array
	 * @return 성공한 row의 갯수를 판단하여 성공 true / 실패 false
	 */
	public boolean deleteBoard(String[] seq);
	
	/**
	 * 새 ROOT 글 작성
	 * @param AnserBoardDTO ID, Title,Content
	 * @return 성공한 row의 갯수를 판단하여 성공 true / 실패 false 
	 */
	public boolean insertBoard(AnswerBoardDTO dto);
	
	/**
	 * DataBase의 Row삭제
	 * @param seq
	 * @return
	 */
	public boolean deleteBoardReal(String seq);

	//	multiDelete
	/**
	 * 다중 삭제
	 * @param map seqs키의 String[]로 되어있는 값
	 * @return 성공한 row의 갯수
	 */
	public int multiDelete2(Map<String, String[]> map);
	
}
