package com.test.fileboard;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.database.SqlSessionFactoryManager;
import com.min.edu.dto.BoardDTO;
import com.min.edu.dto.FileBoardDTO;
import com.min.edu.model.BoardFileImpl;
import com.min.edu.model.IBoardFile;

public class FileBoard_JUnitTest {

	@Test
	public void test() {
//		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
//		SqlSession session = manager.openSession();
//		assertNotNull("MyBatis 세션 객체 생성",session);
		
		IBoardFile dao = new BoardFileImpl();
//		List<BoardDTO> lists = dao.getAllList();
//		assertNotNull(lists);
		
//		BoardDTO bDTO = new BoardDTO();
//		bDTO.setId("KOKOBALL");
//		bDTO.setTitle("글 작성 및 파일 업로드");
//		bDTO.setContent("파일 업로드 기능 적용 중");
//		
//		FileBoardDTO fDto = new FileBoardDTO();
//		fDto.setWriter("KOKOBALL");
//		fDto.setOrigin_fname("보노보노.PNG");
//		fDto.setStored_fname("asdmlasmld");
//		fDto.setFile_size(1010);
//		
//		boolean isc = dao.insertBoard(bDTO, fDto);
//		assertTrue(isc);
//		FileBoardDTO fDto =  dao.getFile("195");
//		assertNotNull(fDto);
		
		List<BoardDTO> lists= dao.getBoard("195");
		System.out.println(lists.size());
		System.out.println(lists.get(0).getFiledto());
		for (FileBoardDTO fdto : lists.get(0).getFiledto()) {
			System.out.println("파일명 : " +fdto.getOrigin_fname());
		}
		assertNotNull(lists);
	}

}
