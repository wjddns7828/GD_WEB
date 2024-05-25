package com.min.edu.service;

import com.min.edu.dto.info_DTO;
import com.min.edu.model.IInfoSelectKey;
import com.min.edu.model.InfoSelectKeyImpl;

public class InfoServiceImpl {

	private IInfoSelectKey dao;
	
	public InfoServiceImpl() {
		dao = new InfoSelectKeyImpl();
	}
	
	
	public info_DTO insertAfterSelect(info_DTO dto) {
		info_DTO rDTO = null;
		System.out.println("원본 DTO :" + dto);
		int n = dao.insertINfo(dto);
		System.out.println("Info Insert 결과 : "+ n);
		System.out.println("입력 후 DTO :" + dto);
		rDTO = dao.selectOneInfo(dto);
		return rDTO;
	}
}
