package com.giasuonline.service;

import java.util.List;

import com.giasuonline.dto.WebXuDTO;

public interface IWebXuService {
	List<WebXuDTO> findAll();
	WebXuDTO findById(long id);
	WebXuDTO save(WebXuDTO dto);
	void delete(long[] ids);
}
