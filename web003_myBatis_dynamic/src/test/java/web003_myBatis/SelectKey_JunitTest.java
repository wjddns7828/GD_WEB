package web003_myBatis;

import static org.junit.Assert.*;

import org.junit.Test;

import com.min.edu.dto.info_DTO;
import com.min.edu.service.InfoServiceImpl;

public class SelectKey_JunitTest {

	/**
	 * 1)insertInfo(Info_DTO)에 신규값을 입력 -> 생성된 SEQ를 Parameter의 Info_Dto 객체에 담음
	 * 2)insertInfo의 DTO를 이용하여 (pass by reference)를 이용하여 selectOneInfo에 Parameter로 전달
	 */
	@Test
	public void selectKey() {
		InfoServiceImpl service = new InfoServiceImpl();
		info_DTO iDto = new info_DTO(0, "판콜", "00100", null, null);
		info_DTO rDto = service.insertAfterSelect(iDto);
		System.out.println("입력된 객체 확인 : "+rDto);
		assertNotNull(rDto);
	}
}
