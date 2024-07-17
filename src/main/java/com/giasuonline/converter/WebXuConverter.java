package com.giasuonline.converter;

import org.springframework.stereotype.Component;

import com.giasuonline.dto.WebXuDTO;
import com.giasuonline.entity.WebxuEntity;

@Component
public class WebXuConverter {
	
	public WebXuDTO toDto(WebxuEntity entity) {
		WebXuDTO result = new WebXuDTO();
		if (entity.getId() != null) {
			result.setId(entity.getId());
		}
		result.setCurrent_xu(entity.getCurrent_xu());
		result.setNeed_xu(entity.getNeed_xu());
		result.setTotal_xu(entity.getTotal_xu());
		if (entity.getUser() != null) {
			result.setUser_id(entity.getUser().getId());
		}
		return result;
	}
	
	public WebxuEntity toEntity(WebXuDTO dto) {
		WebxuEntity result = new WebxuEntity();
		result.setCurrent_xu(dto.getCurrent_xu());
		result.setNeed_xu(dto.getNeed_xu());
		result.setTotal_xu(dto.getTotal_xu());
		return result;
	}
	
	public WebxuEntity toEntity(WebxuEntity result, WebXuDTO dto) {
		result.setCurrent_xu(dto.getCurrent_xu());
		result.setNeed_xu(dto.getNeed_xu());
		result.setTotal_xu(dto.getTotal_xu());
		return result;
	}
}
