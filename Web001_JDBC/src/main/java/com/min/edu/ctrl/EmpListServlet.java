package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.EmpDAOImpl;
import com.min.edu.dao.IEmpDAO;
import com.min.edu.dto.Emp_DTO;

public class EmpListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqName = req.getParameter("name");
		System.out.println("Get요청이 되었습니다."+reqName);
		
		IEmpDAO dao = new EmpDAOImpl();
		List<Emp_DTO> lists = dao.getAllemp();
		
		req.setAttribute("lists", lists);
		//디스패쳐는 붙혀서 보내준다는 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/emplists.jsp");
		dispatcher.forward(req, resp);
		
	}
}
