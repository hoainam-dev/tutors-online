package com.giasuonline.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giasuonline.converter.WebXuConverter;
import com.giasuonline.dto.WebXuDTO;
import com.giasuonline.entity.WebxuEntity;
import com.giasuonline.repository.WebXuRepository;
import com.giasuonline.service.IWebXuService;

@Service
public class WebXuService implements IWebXuService {

	@Autowired
	private WebXuRepository webXuRepository;

	@Autowired
	private WebXuConverter webXuConverter;
	
	@Override
	@Transactional
	public List<WebXuDTO> findAll() {
		List<WebXuDTO> models = new ArrayList<>();
		List<WebxuEntity> entities = webXuRepository.findAll();
		for (WebxuEntity item: entities) {
			WebXuDTO webXuModel = webXuConverter.toDto(item);
			models.add(webXuModel);
		}
		return models;
	}

	@Override
	public WebXuDTO findById(long id) {
		WebxuEntity entity = webXuRepository.findOne(id);
		return webXuConverter.toDto(entity);
	}

	@Override
	@Transactional
	public WebXuDTO save(WebXuDTO dto) {
		WebxuEntity webxuEntity = new WebxuEntity();
		if(dto.getCurrent_xu() == null ) {
			webxuEntity.setCurrent_xu(dto.getNeed_xu());
		}
		if(dto.getTotal_xu() == null ) {
			webxuEntity.setTotal_xu(dto.getNeed_xu());
		}
		return webXuConverter.toDto(webXuRepository.save(webxuEntity));
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub

	}

}
