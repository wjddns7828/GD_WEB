package com.min.edu.comm;

public final class Jsflow {
	public static String jsForward(String msg, String url) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+msg+"');");
		sb.append("location.href='"+url+"';");;
		sb.append("</script>");
		
		
		return sb.toString();
	}
}
