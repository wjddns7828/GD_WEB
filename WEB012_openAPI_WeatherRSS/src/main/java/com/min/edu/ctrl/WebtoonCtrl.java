package com.min.edu.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebtoonCtrl extends HttpServlet {
	private static final long serialVersionUID = -209447667902746879L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	String url = "";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		List<Object> wlists = new ArrayList<Object>();
		for (int j = 1; j <= 100; j++) {
			url = "https://comic.naver.com/webtoon/detail?titleId=650305&no="+j;
		
		Document doc = Jsoup.connect(url).timeout(3000).get();
		Elements ele = doc.select("#comic_view_area");
		Elements ele1 = ele.select("div>img");
		
		System.out.println(ele1.size());
		for(Element el : ele1) {
//			System.out.println(el.attr("src"));
			wlists.add(el);
		}
		System.out.println(wlists);
		}
		req.setAttribute("wlists", wlists);
		req.getRequestDispatcher("/mywebtoon.jsp").forward(req, resp);
	}
}
