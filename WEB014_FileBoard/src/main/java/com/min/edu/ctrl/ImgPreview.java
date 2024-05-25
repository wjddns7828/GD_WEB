package com.min.edu.ctrl;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class ImgPreview extends HttpServlet {

	private static final long serialVersionUID = -8075985621301810501L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		logger.info("ajax를 통한 POST 실행");
		
		ServletContext context = req.getServletContext();
		String saveDirectory = context.getRealPath("upload");
		logger.info("서버 실제 저장 경로 : {}",saveDirectory);
		
		String[] URI = req.getRequestURI().split("/");
		logger.info("상대 경로 : {}",URI[1]);
		
		String encoding ="UTF-8";
		int maxPostSize = 10*1024*1024;//10MB 
		MultipartRequest multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		System.out.println("%%%%%%%");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<img src='/"+URI[1]+"/upload/"+multi.getOriginalFileName("image")+"' alt=''>");
		System.out.println(sb);
		resp.getWriter().write(sb.toString()); 
	}
}
