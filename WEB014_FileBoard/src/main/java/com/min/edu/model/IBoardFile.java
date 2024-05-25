package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.BoardDTO;
import com.min.edu.dto.FileBoardDTO;

public interface IBoardFile  {
	//글 목록 조회
	public List<BoardDTO> getAllList();
	
	//글 입력 & 파일 입력
	public boolean insertBoard(BoardDTO bDto, FileBoardDTO fDto);
	
	//파일 가져오기
	public FileBoardDTO getFile(String seq);
	
	//상세보기(글+파일명)
	public List<BoardDTO> getBoard(String seq);
}
