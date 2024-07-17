package com.giasuonline.converter;

import org.springframework.stereotype.Component;

import com.giasuonline.dto.EvaluateDTO;
import com.giasuonline.entity.EvaluateEntity;

@Component
public class EvaluateConverter {
	
	
	public EvaluateDTO toDto(EvaluateEntity entity) {
		EvaluateDTO result = new EvaluateDTO();
		result.setId(entity.getId());
		result.setNumberStar(entity.getNumberStar());
		result.setFavourite(entity.getFavourite());
		result.setComment(entity.getComment());
		result.setLevel(entity.getLevel());
		result.setTeacherId(entity.getTeacherId());
		result.setStudentId(entity.getStudentId());
		return result;
	}
	
	public EvaluateEntity toEntity(EvaluateDTO dto) {
		EvaluateEntity result = new EvaluateEntity();
		result.setNumberStar(dto.getNumberStar());
		result.setFavourite(dto.getFavourite());
		result.setComment(dto.getComment());
		result.setLevel(dto.getLevel());
		result.setTeacherId(dto.getTeacherId());
		result.setStudentId(dto.getStudentId());
		return result;
	}
	
	public EvaluateEntity toEntity(EvaluateEntity result, EvaluateDTO dto) {
		result.setNumberStar(dto.getNumberStar());
		result.setFavourite(dto.getFavourite());
		result.setComment(dto.getComment());
		result.setLevel(dto.getLevel());
		result.setTeacherId(dto.getTeacherId());
		result.setStudentId(dto.getStudentId());
		return result;
	}
}
