package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupCtrl extends HttpServlet {

	private static final long serialVersionUID = 143806407496826857L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String url ="https://simplehtmldom.sourceforge.io/";
		
		Document doc = Jsoup.connect(url).get();
//		System.out.println(doc);
//		System.out.println(doc.html());
//		System.out.println(doc.text());
		
//		Elements ele1 = doc.select("#content");
//		Elements ele2 = doc.select(".comment");
//		Elements ele3 = doc.select("div");
//		System.out.println(ele3.get(0));
//		Elements ele4 = doc.select("ul");
//		System.out.println(ele4.get(1));
		Elements ele5 = doc.select("#select-elements-using-css-selectors");
	}
}
