package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * xml 파일을 입력되는 형식(변수 = 값)으로 읽어(inputStreamReader) => java.io객체를 사용하거나 혹은 구현해놓은 메소드가 필요
 * java.ibatis.Resources 는 xml을 SqlSessionFactory 객체가 필요로 하는 argument를 만들어 줌
 * new SqlSessionFactoryBuild() 사용하면 객체의 여러개 argument를 입력하지 한번에 작성된 문서를 통해서 입력 가능하다
 */
public class SqlSessionFactoryManager {

	// 모든 멤버필드와 메소드를 static으로 만든 이유는 
	// Supplyment2 프로젝트는 웹서비스를 기반으로 하기 때문에
	
	// DAO에서 사용하는 객체 : DB접속 정보 DataSource, Transaction처리
	private static SqlSessionFactory factory;

	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	 static {
		 String path = "com/min/edu/mybatis/mybatis.xml";
		 try {
			Reader reader = Resources.getResourceAsReader(path);
			System.out.println(reader.toString());
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println(factory.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	
}











