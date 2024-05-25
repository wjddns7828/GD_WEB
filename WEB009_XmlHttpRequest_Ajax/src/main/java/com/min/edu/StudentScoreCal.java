package com.min.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

public class StudentScoreCal extends HttpServlet {

	private static final long serialVersionUID = 3682372734955241606L;
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		String name = req.getParameter("name");
		String kor = req.getParameter("kor");
		String math = req.getParameter("math");
		String eng = req.getParameter("end");
		
		String param = String.format("%s %s %s %s", name, kor, math, eng);
		System.out.println("전달 받은 요청값 : " + param);
		
		int sum = Integer.parseInt(kor) + 
					Integer.parseInt(math) + 
					Integer.parseInt(eng);
		double avg = sum/3.0;
		
		PrintWriter out = resp.getWriter();
	
		//1단계
//		out.print("안녕하세요");
		//2단계
//		out.print("{\"name\":\""+name+"\"}");
		//3단계 JSON Object 사용
		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("sum", sum);
		json.put("avg", avg);
		
		out.print(json.toString());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		String name = req.getParameter("name");
		String kor = req.getParameter("kor");
		String math = req.getParameter("math");
		String eng = req.getParameter("end");
		
		String param = String.format("%s %s %s %s", name, kor, math, eng);
		System.out.println("전달 받은 요청값 : " + param);
		
		int sum = Integer.parseInt(kor) + 
					Integer.parseInt(math) + 
					Integer.parseInt(eng);
		double avg = sum/3.0;
		
		PrintWriter out = resp.getWriter();
	
		//1단계
//		out.print("안녕하세요");
		//2단계
//		out.print("{\"name\":\""+name+"\"}");
		//3단계 JSON Object 사용
		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("sum", sum);
		json.put("avg", avg);
		
		out.print(json.toString());
	
	}
}
