package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.CalendarDto;

public interface ICalBoardDao {
//	각 달력 일별 리스트	getCalViewList
	public List<CalendarDto> getCalViewList(Map<String,Object> map);
//	일정추가	insertCalBoard
	public int insertCalBoard(CalendarDto dto);
//	일별게시글조회	getCalList
	public List<CalendarDto> getCalList(Map<String,Object> map);
//	일정갯수	getCalCount
	public int getCalCount(Map<String,Object>map);
//	게시글 상세	getCalDetatil
	public CalendarDto getCalDetail(Map<String,Object> map);
//	게시글 삭제	multiDel
	public boolean multiDel(String[] seq);
}
