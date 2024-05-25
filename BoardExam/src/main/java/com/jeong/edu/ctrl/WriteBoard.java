package com.jeong.edu.ctrl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeong.edu.model.BoardDaoImpl;
import com.jeong.edu.model.IBoardDao;
import com.jeong.edu.vo.FileDto;
import com.jeong.edu.vo.RootBoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteBoard extends HttpServlet {

	private static final long serialVersionUID = -2337058333550937416L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("WriteBoard doGet");
		resp.sendRedirect("./writeBoard.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("WriteBoard doPost 진입");
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("UTF-8");

		ServletContext context = req.getServletContext();
		String saveDirectory = context.getRealPath("upload");
		logger.info("서버 실제 저장 경로 : {}",saveDirectory);
		
		int maxPostSize = 10*1024*1024;//10MB
		String encoding ="UTF-8";
		
		MultipartRequest multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		String id = multi.getParameter("id");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String origin_fname = multi.getOriginalFileName("file");

		RootBoardDto dto = new RootBoardDto(id,title,content);
		IBoardDao dao = new BoardDaoImpl();
		int n = dao.insertBoard(dto);
		
		if(origin_fname!=null) {
		int filesize = (int)multi.getFile("file").length();
		logger.info("id: {} / title : {} /  content: {} / ofn : {} / filesize:{}",id,title,content,origin_fname, filesize);
		String stored_fname=null;
		FileDto fdto = null;
		stored_fname = UUID.randomUUID().toString().replace("-","")+origin_fname.substring(0,origin_fname.lastIndexOf("."));
		logger.info("서버에 저장될 파일 이름 : {}",stored_fname);
		fdto= new FileDto(dto.getSeq(),id,origin_fname,stored_fname,filesize);
		File oldFile = new File(saveDirectory+"/"+multi.getFilesystemName("file"));
		File newFile = new File(saveDirectory+"/"+stored_fname);
		oldFile.renameTo(newFile);
		n += dao.insertFile(fdto);
		}
		
		if(n>=1) {
			resp.sendRedirect("./detail.do?seq="+dto.getSeq()+"&page=1");
		}else {
			resp.getWriter().print("<script>alert('글입력실패');</script>");
		}
	}
}
