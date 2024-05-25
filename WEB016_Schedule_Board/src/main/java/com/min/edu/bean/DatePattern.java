package com.min.edu.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePattern {
	private String toDate;

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getToDate() {
		//2023 07 28 12 00 -> 2023-07-28 12:00:00
		
		StringBuffer sb = new StringBuffer();
		sb.append(toDate.substring(0,4));
		sb.append("-");
		sb.append(toDate.substring(4,6));
		sb.append("-");
		sb.append(toDate.substring(6,8));
		sb.append(" ");
		sb.append(toDate.substring(8,10));
		sb.append(":");
		sb.append(toDate.substring(10));
		sb.append(":00");
		
		System.out.println("수정된 DataPattern : " + sb.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date d = new Date();
		System.out.println(sdf.format(d));
		
		Timestamp tm = Timestamp.valueOf(sb.toString());
		System.out.println(sdf.format(tm));
		return sdf.format(tm);
	}
}
