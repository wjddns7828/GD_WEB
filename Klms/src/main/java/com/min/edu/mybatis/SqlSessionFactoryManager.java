package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {

	private static SqlSessionFactory factory;
	
	public static SqlSessionFactory getFactory() {
	return factory;
	}
	
	static {
		String path = "com/min/edu/mybatis/config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(path);
			factory = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("객체 생성 성공");
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
