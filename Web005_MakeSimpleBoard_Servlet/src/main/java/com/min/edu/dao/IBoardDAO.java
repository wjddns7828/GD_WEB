package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.BoardDTO;

public interface IBoardDAO {
	public List<BoardDTO> getAllBoard();
	
	public int setInsertBoard(String title, String writer, String Content);
	
	public BoardDTO getOneboard(String title);
	
	public int setUpdateBoard(Map<String, Object> inmap);
	
	public int setDeleteBoard(String seq);
	
}
