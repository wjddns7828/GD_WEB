package com.min.edu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO_08 {
	//파일복제
	public static void main(String[] args) {
		//파일을 읽는 객체
		FileInputStream fis = null;
		BufferedInputStream bis= null;
		//파일을 작성하는 객체
		FileOutputStream fos =null;
		BufferedOutputStream bos=null;
		
		try {
			//파일을 byte로 읽는다
			fis = new FileInputStream("gartner_report.txt");
			//읽어온 data를 buffer로 감싼다
			bis = new BufferedInputStream(fis);
			//저장한 파일을 생성한다
			fos = new FileOutputStream("gartner_report_copy.txt");
			//쓰여질 데이터를 처리할 buffer를 buffer로 감싼다
			bos = new BufferedOutputStream(fos);
			int c = 0;
			while ((c=bis.read())!=-1) {
				bos.write(c);
			}
			bos.flush();
			bos.close();
			
			fos.close();
			bis.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
