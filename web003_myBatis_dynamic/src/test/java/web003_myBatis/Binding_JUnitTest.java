package web003_myBatis;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.Job_DTO;
import com.min.edu.model.BindingDaoImpl;
import com.min.edu.model.IBindingDao;

public class Binding_JUnitTest {
	
	private IBindingDao dao = new BindingDaoImpl();
	
//	@Test
	public void binding01() {
		Map<String, Object> map = new HashMap<String, Object>();
		//#으로 처리하였기 떄문에 값으로 전달되지않는다
//		map.put("COLUMN", "JOB_ID");
//		map.put("VALUE", "IT_PROG");
		//$로 처리하는 방식은 값이 아닌 Name으로 처리가 됨
		map.put("COLUMN", "'a'='a'or JOB_ID");
		map.put("VALUE", "IT_PROG");
		List<Job_DTO> lists = dao.binding01(map);
		assertNotNull(lists);		
	}
	@Test
	public void binding02() {
		Map<String, Object> map = new HashMap<String, Object>();
//		//# , $ 테스트 값
//		map.put("val", "I");
		
		//직접 %문장 생성
		map.put("val", "I%");
		List<Job_DTO> lists = dao.binding02(map);
		assertNotNull(lists);
	}

}
