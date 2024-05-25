package com.jeong.edu.ctrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeong.edu.model.BoardDaoImpl;
import com.jeong.edu.model.IBoardDao;
import com.jeong.edu.vo.FileDto;

public class Download extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final long serialVersionUID = -5838933347536021042L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String b_seq = req.getParameter("b_seq");
		logger.info(b_seq);
		IBoardDao dao = new BoardDaoImpl();
		FileDto fdto =  dao.getFile(Integer.parseInt(b_seq));
		logger.info(fdto.toString());
		
		FileInputStream in = null;
		ServletOutputStream out = null;
		try {
			ServletContext context = req.getServletContext();
			String path = context.getRealPath("/upload");
			String filepath = path+"/"+fdto.getStored_fname();
			logger.info(filepath);
			
			File file = new File(filepath);
			logger.info(file.toString());
			
			byte[] b = new byte[(int)file.length()];
			System.out.println("읽어온 파일 byte : " + Arrays.toString(b));
			
			resp.reset();
			resp.setContentType("application/octect-stream");
			String encoding = new String (fdto.getOrigin_fname().getBytes("UTF-8"),"8859_1");
			resp.setHeader("Content-Disposition", "attachment; filename="+encoding);
			
			in = new FileInputStream(file);
			out = resp.getOutputStream();
			
			int numRead=0;
			while((numRead =in.read(b,0,b.length))!=-1){
				out.write(b,0,numRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			out.flush();
			out.close();
			in.close();
		}
	}
}
