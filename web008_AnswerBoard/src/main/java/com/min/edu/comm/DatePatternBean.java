package com.min.edu.comm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePatternBean {
	private String regdate;
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	//REGDATE의 형태를 출력하기 위해서 사용
	//REGDATE는 STRING 타입 -> java.util.Date 변경 -> java.text.SimpledatePattern을 통해 변경 -> 변환된 String출력
	public String getDatePattern(){
		Date cDate = null;
		Date now = null;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat fmt2 = null;
		try{
		cDate = fmt.parse(regdate);
		fmt2 = new SimpleDateFormat("yyyy년 MM월 dd일");
		now = new Date();
		}catch(Exception e){
		System.out.print(e.toString());
		}
		return fmt2.format(cDate).compareTo(fmt2.format(now))==0?"오늘작성":fmt2.format(cDate);
	}
}
