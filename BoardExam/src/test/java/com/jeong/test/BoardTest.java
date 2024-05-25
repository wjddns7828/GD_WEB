package com.jeong.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeong.edu.model.BoardDaoImpl;
import com.jeong.edu.model.IBoardDao;
import com.jeong.edu.vo.FileDto;
import com.jeong.edu.vo.ReplyBoardDto;
import com.jeong.edu.vo.RootBoardDto;
import com.jeong.edu.vo.pageDto;

public class BoardTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void test() {
		IBoardDao dao = new BoardDaoImpl();
		pageDto page = new pageDto();
		page.setTotalCount(15);
		page.setCountList(3);
		page.setCountPage(5);
		page.setTotalPage(page.getTotalCount());
		page.setPage(1);
		page.setStartPage(1);
		page.setEndPage(1);
		System.out.println(page);
		
		System.out.println("start :"+(page.getPage()*page.getCountList()-(page.getCountList()-1)));
		System.out.println("end : "+(page.getPage()*page.getCountList()));
		
		
		//해당 글 조회
//		RootBoardDto dto = dao.getDetailBoard(1);
//		assertNotNull(dto);
		
		//해당글의 파일 조회
//		FileDto fdto = dao.getFile(1);
//		assertNotNull(fdto);
		
//		Map<String, Object> map = new HashMap<String,Object>();
//		map.put("ref", 1);
//		map.put("start", 1);
//		map.put("end", 3);
//		List<ReplyBoardDto> lists = dao.getReply(map);
//		assertNotNull(lists);
		
//		RootBoardDto dto = new RootBoardDto("토마토", "멋쟁이토마토", "토마토왕국의 왕 토맛토");
//		int n = dao.insertBoard(dto);
//		logger.info("{}",n);
//		
//		FileDto fdto = new FileDto(dto.getSeq(), "망고", "망고.png", "sadasdsadasd", 123456);
//		n += dao.insertFile(fdto);
//		
//		assertEquals(n, 2);
	}
}
