package com.min.edu;

import java.io.File;
import java.util.Date;

public class IO_10 {
	/*
	 * 파일(file)클래스 활용
	 * 파일 클래스를 통해 : 타입, 크기, 디렉터리, 파일의 이름
	 * 
	 */
	public static void main(String[] args) {
		File f1 = new File("c:\\windows\\system.ini");
		File f2 = new File("c:\\eclipse_web\\temp");
		File f3 = new File("c:\\eclipse_web");
		
		//1) 파일여부 판단
		String res= "";
		if(f1.isFile()) {
			res="파일입니다";
		}else {
			res="파일이 아닙니다.";
		}
		System.out.println(res);
		
		//2)폴더 생성하기 * 파일업로드를 한다면 기본적으로 들어가는 것 *
		if(!f2.exists()) {//폴더의 존재여부를 판단 
			if(f2.mkdirs()) {
				System.out.println("폴더를 생성했습니다.");
			}else {
				System.out.println("폴더를 생성에 실패했습니다..");
			}
		}else {
			System.out.println("디렉토리가 존재합니다.");
		}
		//3) 폴더명 변경하기
		f2.renameTo(new File("c:\\eclipse_web\\tmp"));
		
		//4) 정보 확인 *가장 많이 사용함*
		String[] fileNames = f3.list(); //파일의 위치, listFile() -> file[] 파일 객체를 줌
		for (String s : fileNames) {//s개체는 이름마 ㄴ가지고 있음
//			System.out.println(s);
			File f = new File(f3,s);
			long t = f.lastModified(); //마지막으로 수정한 날짜
			long l = f.length(); //파일크기
			String name = f.getName();//파일 이름
			
			System.out.println("마지막 수정날짜 "+ t);
			System.out.println("파일의 크기" + l );
			System.out.println("파일의 이름" + name);
			System.out.printf("수정 시간 %tb, %td, %ts, %tT \n", t,t,t,t );
			Date date = new Date();
			System.out.println(date.toString());
			
			System.out.println("---------------");
		}
	}
}
