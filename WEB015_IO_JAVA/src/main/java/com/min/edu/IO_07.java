package com.min.edu;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;

public class IO_07 {
	public static void main(String[] args) throws IOException {
		OutputStream o =System.out;
		for (int i = 48; i < 58; i++) {
			o.write(i);
		}
		for (int i = 48; i < 58; i++) {
			o.write(i);
		}
		
		System.out.println();
		String str = "아카데미";
		byte[] b = str.getBytes();
		System.out.println(Arrays.toString(b));
		
		o.write(b);
		o.flush();
		
		System.out.println("---------------------------------");
		
		//키보드로 입력 받음
//		InputStreamReader in = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); <<BufferedOutputStream 랑 같음
		
		BufferedOutputStream bOut = new BufferedOutputStream(System.out);

		Date d = new Date();
		long start = d.getTime();
		
//		FileInputStream fIn = new FileInputStream("C:\\eclipse_Web\\eclipse\\eclipse.txt");
		FileReader fIn = new FileReader("C:\\eclipse_web\\eclipse\\eclipse.txt");
		int c = 0;
		while ((c=fIn.read())!=-1) {
			bOut.write((char)c);
		}
		
		d= new Date();
		long end = d.getTime();
		
		System.out.println("\n\n 걸린 시간 : " + (end-start));
		bOut.flush();
		
		fIn.close();
		bOut.close();
	}
}
