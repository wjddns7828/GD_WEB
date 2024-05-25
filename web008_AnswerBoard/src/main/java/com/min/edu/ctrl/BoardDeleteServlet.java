package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class BoardDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = -7115106910661393794L;
	private Logger logger = Logger.getLogger(this.getClass());
	IAnswerBoardDao dao = new AnswerBoardDaoImpl();
	
	// 상세에서 단일 샂게를 위한 GET의 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		logger.info("BoardDeleteServlet doGet");
//		String seq = req.getParameter("seq");
//		logger.info("BoardDeleteServlet doGet 요청 값 : "+seq);
		
		UserVo login =  (UserVo)req.getSession().getAttribute("loginInfo");
		if (login.getAuth().equalsIgnoreCase("A")) {
//			String seq = req.getParameter("seq");
//			boolean isc = dao.deleteBoardReal(seq);
			
//			myBatis Dynamic쿼리를 통한 다중삭제
			
			String[] seqs = req.getParameterValues("seq");
			Map<String, String[]> map = new HashMap<String, String[]>();
			map.put("seqs", seqs);
			int n = dao.multiDelete2(map);
			
			resp.sendRedirect("./main,do");
		}else {
			req.getRequestDispatcher("WEB-INF/views/boardError.jsp").forward(req, resp);
		}
	}
	
	// 전체 글 보기에서 다중삭제 Post의 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		String[] seqs = req.getParameterValues("ch");//어레이 값으로 가져옴
		logger.info("BoardDeleteServlet dopost 전달받은 값"+Arrays.toString(seqs));
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		boolean isc = dao.deleteBoard(seqs);
		
		if(isc){
			StringBuffer sb = new StringBuffer();
			sb.append("<script>");
			sb.append("alert('삭제가 완료되었습니다');");
			sb.append("location.href='./main.do';");
			sb.append("</script>");
			resp.getWriter().println(sb.toString());
		}else {
			req.getRequestDispatcher("WEB-INF/views/boardError.jsp").forward(req, resp);
		}
	}
}
