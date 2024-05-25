package com.min.edu;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO_06 {
	public static void main(String[] args) throws IOException {
		System.out.println("입력 정보를 파일로 저장하기");
		//키보드로 입력받은 문자를 읽어오는 객체
		InputStreamReader in = new InputStreamReader(System.in);

		//문자를 쓰기 위한 파일을 생성
		FileWriter fileOut = new FileWriter("C:\\eclipse_Web\\workspace_web\\WEB015_IO_JAVA\\inputValue.txt");
		
		//입력받은 inputStream을 바이트로 읽어서 FileWriter에 써준다
		int c=0;
		while((c=in.read())!=-1){
			fileOut.write(c);
		}
		fileOut.flush();
		fileOut.close();
		in.close();
	}
}
