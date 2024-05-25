package com.min.edu;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IO_01 {
		/**
		 * java.io.*
		 * 1) 자바에서 데이터를 읽고 쓰고 하는 기능을 가진 package ex)System.out / System.in ==> Stream 객체
		 * 2) 자바 IO는 IO Exception필수 Why? => 외부에서 파일을 읽어온다(있을 수 있고 없을 수 있기 때문에)
		 * 3) 자바의 Strem객체임
		 * 
		 * 자바의 Stream이란?
		 * - java의 Stream은 입출력장치와 프로그램을 연결하여 이들 사이의 데이터를 처리하는 것
		 * - 입력Stream / 출력Stream 
		 * Node ==> 시작점 | Filter ==> inputStreamReader  / outputStream
		 * Buffer => 크기를 정하는 것
		 * - 기본 크기 : 1byte(8bit)
		 * - 연속적으로 전송하는 데이터의 크기를 보안하기 위해 Buffer와 Filter <==Stream을 도와주는 객체 
		 * - 출력Stream(FIFO) 자바의 Stack(LIFO)
		 *  
		 */
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		String line = scan.nextLine();
//		System.out.println(line);
		
		//메모리에서 읽어오는데 (System.in), 문자열(Reader)로 읽어(InputStream)으로 오겠다
		InputStreamReader reader = new InputStreamReader(System.in);
		try {
			int n = reader.read();
			System.out.println(n);
			System.out.println((char)n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
