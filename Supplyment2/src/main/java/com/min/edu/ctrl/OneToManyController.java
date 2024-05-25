package com.min.edu.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.joindto.RootBoard;
import com.min.edu.mybatis.SqlSessionFactoryManager;

/**
 * Servlet implementation class OneToManyController
 */
@WebServlet("/OneToManyController.do")
public class OneToManyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSessionFactory factory = SqlSessionFactoryManager.getFactory();
		SqlSession session = factory.openSession();
		RootBoard rootdto = session.selectOne("OneToMany.oneToMany");
		request.setAttribute("dto", rootdto);
		request.getRequestDispatcher("/WEB-INF/views/rootDetail.jsp").forward(request, response);
	}
}
