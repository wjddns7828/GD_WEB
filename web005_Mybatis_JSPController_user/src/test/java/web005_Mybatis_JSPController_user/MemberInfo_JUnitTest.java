package web005_Mybatis_JSPController_user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDTO;
import com.min.edu.support.SqlSessionFactoryManager;



public class MemberInfo_JUnitTest {
//	SqlSession session;
////	"com.min.edu.dao.UserDaoImpl"
//	UserDaoImpl dao =  new UserDaoImpl();
//	
//	@Before
//	public void test() {
//		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
//		session = manager.openSession(false);
//		assertNotNull(session);
//	}
//	@Test
//	public void memberInfo_Test() {
////	List<UserDTO> lists = session.selectList("com.min.edu.dao.UserDaoImpl.getAllUserStatus");
////		assertNotNull(lists);
//		assertNotNull(dao.getAllUserStatus());
//		
////	List<UserDTO> lists2 = session.selectList("com.min.edu.dao.UserDaoImpl.getAllUser");
////		assertNotNull(lists2);
//		assertNotNull(dao.getAllUser());
//		
////		  UserDTO dto = new UserDTO("test2","1234","냠냠","회사","0000","asd@naver.com");
////		  assertEquals(dao.insertUser(dto), 1);
//		  
////		  UserDTO dto = new UserDTO("test1","1234","냠냠","회사","0000","asd@naver.com");
////		  int n1 = session.insert("com.min.edu.dao.UserDaoImpl.insertUser",dto);
////		  assertEquals(n1, 1);
//		
//		 
////		  Map<String, Object> inMap = new HashMap<String, Object>(); 
////		  inMap.put("auth","admin"); 
////		  inMap.put("seq", "1"); 
////		  assertEquals(dao.updateAuthUser(inMap), 1);
//		  
////		  int update1 = session.update("com.min.edu.dao.UserDaoImpl.updateAuthUser",inMap);
////		  assertEquals(update1,1);
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "rainbow");
//		map.put("password", "1234");
//		assertNotNull(dao.getLogin(map));
//		
////		List<UserDTO> loginDto = session.selectList("com.min.edu.dao.UserDaoImpl.getLogin",map);
////		assertNotNull(loginDto.get(0));
//
////		List<UserDTO> lists = session.selectList("com.min.edu.dao.UserDaoImpl.getUserInfo","1");
////		assertNotNull(lists);
//		String seq = "1";
//		assertNotNull(dao.getUserInfo(seq));
//		
//		
//		
//		
////		Map<String, Object> map1 = new HashMap<String, Object>();
////		map1.put("address", "한국");
////		map1.put("phone", "12348");
////		map1.put("email", "wdjdasdns@mal2");
////		map1.put("seq", 3);
////		assertEquals (dao.updateUserInfo(map1),1);
////		
////		int n3 = session.update("com.min.edu.dao.UserDaoImpl.updateUserInfo",map);
////		assertEquals(n3, 1);
//		
//		
////		int n4 = session.delete("com.min.edu.dao.UserDaoImpl.delUser","3");
////		assertEquals(n4, 1);
//		assertEquals(dao.delUser("3"), 1);
//		
////		int n5 = session.selectOne("com.min.edu.dao.UserDaoImpl.dupulicateId","RAINBOW11");
////		assertEquals(n5,1);
////		assertEquals(n5,0);
//		assertEquals(dao.dupulicateId("RAINBOW"), 1);
//		
//	}
}
