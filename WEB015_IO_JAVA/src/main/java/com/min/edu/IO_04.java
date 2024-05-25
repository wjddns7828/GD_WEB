package com.min.edu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IO_04 {
	/**
	 * 문자를 읽어 내는 방법
	 * 문자 스트링(Reader /Writer 끝나는 스트림)
	 * 유니코드표로 되어있는 문자 입력 Stream
	 * -- 문자형식 만을 읽어내고 다른 데이터 타입은 사용 할 수 없음(이미지,음악,동영상)
	 * 
	 * Reader : 바이트로 문자를 읽음 ex) 컴퓨터에 있는 파일을 읽는다.
	 * Writer : 문자를 바이트로 읽어서 인코딩 해서 출력한다.
	 * 
	 * FileReader(만들어진 파일을 읽는다) : FileWriter(파일을 만들고 쓴다)
	 * 
	 */
	public static void main(String[] args) {
		try {
			FileReader in = new FileReader("c:\\windows\\system.ini");
			int c = 0;
			while ((c=in.read())!= -1 ) {
				System.out.print((char)c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
