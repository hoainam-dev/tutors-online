package com.giasuonline.converter;

import org.springframework.stereotype.Component;

import com.giasuonline.dto.SubjectDTO;
import com.giasuonline.entity.SubjectEntity;

@Component
public class SubjectConverter {
	
	public SubjectDTO toDto(SubjectEntity entity) {
		SubjectDTO result = new SubjectDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setCode(entity.getCode());
		return result;
	}
	
	public SubjectEntity toEntity(SubjectDTO dto) {
		SubjectEntity result = new SubjectEntity();
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		return result;
	}
	
	public SubjectEntity toEntity(SubjectEntity result, SubjectDTO dto) {
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		return result;
	}
}
