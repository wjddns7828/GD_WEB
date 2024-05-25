package com.jeong.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeong.edu.model.BoardDaoImpl;
import com.jeong.edu.model.IBoardDao;
import com.jeong.edu.vo.FileDto;
import com.jeong.edu.vo.ReplyBoardDto;
import com.jeong.edu.vo.RootBoardDto;
import com.jeong.edu.vo.pageDto;

public class Detail extends HttpServlet {

	private static final long serialVersionUID = -5533102037616096193L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doGet Detail");
		String seq = req.getParameter("seq");
		logger.info("전달받은 seq : {} ",seq);
		
		//게시글 detail정보
		IBoardDao dao = new BoardDaoImpl();
		RootBoardDto dto = dao.getDetailBoard(Integer.parseInt(seq));
		System.out.println(dto);
		req.setAttribute("dto", dto);
		
		//page 처리
		String page =  req.getParameter("page");
		logger.info("전달받은 page : {} ",page);
		Map<String, Object> map = new HashMap<String,Object>();
		pageDto pDto = new pageDto();
		if(page==null || page.equals("1") ||Integer.parseInt(page) <= 1) {
			page="1";
		}
		pDto.setTotalCount(dao.getTotalpageCount());
		pDto.setCountList(3);
		pDto.setCountPage(5);
		pDto.setTotalPage(pDto.getTotalCount());
		if(Integer.parseInt(page)>pDto.getTotalPage()) {
			page = ""+pDto.getTotalPage();
		}
		pDto.setPage(Integer.parseInt(page));
		pDto.setStartPage(Integer.parseInt(page));
		pDto.setEndPage(Integer.parseInt(page));
		logger.info("page : {}",pDto);
		req.setAttribute("page", pDto);
		
		map.put("ref", seq);
		map.put("start",(pDto.getPage()*pDto.getCountList()-(pDto.getCountList()-1)));
		map.put("end", (pDto.getPage()*pDto.getCountList()));
		
		//답글
		List<ReplyBoardDto> rlist = dao.getReply(map);
		logger.info("rlist : {}",rlist);
		req.setAttribute("rlist", rlist);
		
		//file
		FileDto fdto = dao.getFile(Integer.parseInt(seq));
		if(fdto!=null) {
		logger.info(fdto.toString());
		req.setAttribute("file", fdto);
		}
		req.getRequestDispatcher("./WEB-INF/detailBoard.jsp").forward(req, resp);
	}
}
