package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.min.edu.model.CalBoardDaoImpl;
import com.min.edu.model.ICalBoardDao;

public class MultiDelForm extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final long serialVersionUID = 3687197609044837756L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String yyyymmdd= req.getParameter("yyyymmdd");
		logger.info("doPost실행");
		ICalBoardDao dao = new CalBoardDaoImpl();
		String[] seq = req.getParameterValues("chk");
		boolean isc = dao.multiDel(seq);
		String yyyy= yyyymmdd.substring(0, 4);
		String mm= yyyymmdd.substring(4, 6);
		String dd = yyyymmdd.substring(6, 8);
		if(isc) {
			resp.sendRedirect("./CalController.do?command=callist&year="+yyyy+"&month="+mm+"&date="+dd+"");
		}
	}
}
