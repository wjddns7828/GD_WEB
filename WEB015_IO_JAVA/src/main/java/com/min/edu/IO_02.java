package com.min.edu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IO_02 {
	/**
	 * InputStream 데이터를 읽어 오는 객체 
	 * File을 읽어 온다.
	 * ByteStream은 바이트 단위로 Binary값을 읽는 스트림 
	 *  
	 *  InputStream
	 *  - FileStream
	 *  - DataStream
	 *  
	 *  -- 실습 --
	 *  물리적인 주소 (절대 경로) java의 문법오류 (Escape문자) 가 발생 할 수 있음 
	 *  C:\eclipse_Web\eclipse\eclipse.txt
	 *  위에 파일을 읽어서 console에 출력해보자
	 *  
	 *   ※
	 *   	절대 경로 : 주소를 고정값으로 (변하지 않는 주소)
	 *      상대 경로 : 주소가 계속 계속 변경되어 사용되는 것(./img/~~~.png)
	 */
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("C:\\eclipse_Web\\eclipse\\eclipse.txt");
			//InputStream의 객체가 읽어오면 byte크기의 데이터를 읽어서 문자형으로 변환
			int v = 0;
//			int r = file.read();
//			System.out.println((char)r);
			while ((v=file.read())!=-1) {
				System.out.print((char)v);
			}
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
