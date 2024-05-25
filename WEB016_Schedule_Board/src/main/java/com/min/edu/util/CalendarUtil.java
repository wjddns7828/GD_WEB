package com.min.edu.util;

import java.util.Iterator;
import java.util.List;

import com.min.edu.dto.CalendarDto;

public class CalendarUtil {
	//한자리의 숫자를 두자리의 문자형 숫자로 만들어주는 메소드
	public static String iTwoWord(int month) {
		String m = String.valueOf(month);
//		System.out.println(String.format("%2s", m));
		return m.length()==2?m:"0"+m;
	}
	
	//날짜별 글자색 표기(토:파 / 일:빨 / 평:검)
	public static String fontColor(int date, int dayOfWeek) {
		int dayCal=(date-1+dayOfWeek)%7;
		if(dayCal==0) {
			return "blue";
		}
		else if(dayCal==1){
			return "red";
		}else {
			return "black";
		}
	}
	
	//해당일에 포함된 게시글의 붙여넣기 위해서 HTML Tag를 만듬
	//i달력의 일, clist 해당월에 전체 글 목록
	public static String getCalView(int i,List<CalendarDto> clist) {
		String result ="";
		String d = iTwoWord(i);
		for(CalendarDto dto : clist) {
			if(dto.getMdate().substring(6,8).equals(d)) {
				StringBuffer sb = new StringBuffer();
				sb.append("<p title='"+dto.getTitle()+"'>");
				
				//title의 문자열 길이 표기법 변경
				if(dto.getTitle().length()>6) {
					sb.append(dto.getTitle().subSequence(0, 6));
					sb.append("...");
				}else {
					sb.append(dto.getTitle());
				}
				sb.append("</p>");
				result+=sb.toString();
			}
		}
		return result;
	}
	
}
