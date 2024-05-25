package com.min.edu.ctrl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.dto.CalendarDto;
import com.min.edu.model.CalBoardDaoImpl;
import com.min.edu.model.ICalBoardDao;

public class CalController extends HttpServlet {

	private static final long serialVersionUID = 6483701772520000145L;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		ICalBoardDao dao = new CalBoardDaoImpl();

		String command = req.getParameter("command");
		logger.info("요청받은 command 값 : {}", command);
		if (command.equalsIgnoreCase("sessionDel")) {
			logger.info("세션 삭제");
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect("./index.jsp");
		} else if (command.equalsIgnoreCase("calList")) {
			logger.info("일자 게시글 리스트");
			String year = req.getParameter("year");
			String month = String.format("%2s", req.getParameter("month")).replace(" ", "0");
			String date = String.format("%2s", req.getParameter("date")).replace(" ", "0");

			logger.info("요청 받은 전달 값 : {} {} {}", year, month, date);
			HttpSession session = req.getSession();
			String id = (String) session.getAttribute("id");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("yyyymmdd", year + month + date);
			List<CalendarDto> lists = dao.getCalList(map);
			req.setAttribute("lists", lists);
			req.getRequestDispatcher("./calList.jsp").forward(req, resp);
		} else if (command.equalsIgnoreCase("insertForm")) {
			String year = req.getParameter("year");
			String month = req.getParameter("month");
			String date = req.getParameter("date");

			Calendar cal = Calendar.getInstance();
			cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(date));
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

			logger.info("마지막 날 {}", lastDay);
			logger.info("요청 받은 값 : {} {} {}", year, month, date);
			SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
			Date d = new Date();
			String time = sdf.format(d);
			System.out.println(time);
			String hour = time.substring(0, 2);
			String min = time.substring(2, 4);

			logger.info("요청 받은 값 : {} {}", hour, min);

			req.setAttribute("year", year);
			req.setAttribute("month", month);
			req.setAttribute("date", date);
			req.setAttribute("lastDay", lastDay);
			req.setAttribute("hour", hour);
			req.setAttribute("min", min);
			req.getRequestDispatcher("/insertForm.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		logger.info("CalController doPost");
		String command = req.getParameter("command");
		logger.info("전달받은 command값 {} ", command);

		if (command.equalsIgnoreCase("calendar")) {
			String id = req.getParameter("id");
			String name = req.getParameter("name");

			logger.info("전달받은 id값 {} ", id);
			logger.info("전달받은 name값 {} ", name);

			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);

			logger.info("세션의 저장 값 >> ID : {} 이름 : {} ", session.getAttribute("id"), session.getAttribute("name"));
			resp.sendRedirect("./calendar.jsp");
		} else if (command.equalsIgnoreCase("getMaxDay")) {
			int year = Integer.parseInt(req.getParameter("year"));
			int month = Integer.parseInt(req.getParameter("month"));

			Calendar cal = Calendar.getInstance();
			cal.set(year, (month) - 1, 1);
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			logger.info("마지막 날 {}", lastDay);
			logger.info("전달받은 {} {} ", year, month);

			StringBuffer sb = new StringBuffer();
			for (int i = 1; i <= lastDay; i++) {
				sb.append("<option value='" + i + "'>" + i + "</option>");
			}
			resp.getWriter().write(sb.toString());
		} else if (command.equalsIgnoreCase("insertForm")) {
			logger.info("insertForm");
			String id = (String) req.getSession().getAttribute("id");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String year = String.format("%2s", req.getParameter("year")).replace(" ", "0");
			String month = String.format("%2s", req.getParameter("month")).replace(" ", "0");
			String date = String.format("%2s", req.getParameter("date")).replace(" ", "0");
			String hour = String.format("%2s", req.getParameter("hour")).replace(" ", "0");
			String min = String.format("%2s", req.getParameter("min")).replace(" ", "0");
			
			CalendarDto dto = new CalendarDto();
			dto.setId(id);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setMdate(year+month+date+hour+min);
			
			ICalBoardDao dao = new CalBoardDaoImpl();
			int n = dao.insertCalBoard(dto);
			if(n==1) {
				resp.sendRedirect("./calendar.jsp?year="+year+"&month="+month);
			}
		}
	}
}
