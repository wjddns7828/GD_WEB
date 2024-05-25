package com.jeong.edu.model;

import java.util.List;
import java.util.Map;

import com.jeong.edu.vo.FileDto;
import com.jeong.edu.vo.ReplyBoardDto;
import com.jeong.edu.vo.RootBoardDto;

public interface IBoardDao {
	
public int insertBoard(RootBoardDto dto);

public int insertFile(FileDto fdto);

public RootBoardDto getDetailBoard(int seq);

public List<ReplyBoardDto> getReply(Map<String,Object> map);

public FileDto getFile(int seq);

public int getTotalpageCount();

}
