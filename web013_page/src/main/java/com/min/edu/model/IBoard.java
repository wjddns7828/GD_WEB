package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.BoardDto2;
import com.min.edu.dto.FileDto;
import com.min.edu.dto.ReplyDto;

public interface IBoard {
	public List<BoardDto2> getAllBoard();
	public boolean insertBoard(BoardDto2 dto2, List<FileDto> flists);
	public BoardDto2 getOneBoard(String seq);
	public boolean insertReply(ReplyDto rDto);
}
