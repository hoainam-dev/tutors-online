package com.giasuonline.converter;

import org.springframework.stereotype.Component;

import com.giasuonline.dto.TeacherDTO;
import com.giasuonline.entity.TeacherEntity;

@Component
public class TeacherConverter {
	
	public TeacherDTO toDto(TeacherEntity entity) {
		TeacherDTO result = new TeacherDTO();
		result.setId(entity.getId());
		result.setFirstName(entity.getFirstName());
		result.setLastName(entity.getLastName());
		result.setBirthDate(entity.getBirthDate());
		result.setGender(entity.getGender());
		result.setPhone(entity.getPhone());
		result.setEmail(entity.getEmail());
		result.setAddress(entity.getAddress());
		result.setIntroduce(entity.getIntroduce());
		if (entity.getSubject() != null) {
			result.setSubjectCode(entity.getSubject().getCode());
		}
		result.setWebxu(entity.getWebxu());
		return result;
	}
	
	public TeacherEntity toEntity(TeacherDTO dto) {
		TeacherEntity result = new TeacherEntity();
		result.setFirstName(dto.getFirstName());
		result.setLastName(dto.getLastName());
		result.setBirthDate(dto.getBirthDate());
		result.setGender(dto.getGender());
		result.setPhone(dto.getPhone());
		result.setEmail(dto.getEmail());
		result.setAddress(dto.getAddress());
		result.setIntroduce(dto.getIntroduce());
		result.setWebxu(dto.getWebxu());
		return result;
	}
	
	public TeacherEntity toEntity(TeacherEntity result, TeacherDTO dto) {
		result.setFirstName(dto.getFirstName());
		result.setLastName(dto.getLastName());
		result.setBirthDate(dto.getBirthDate());
		result.setGender(dto.getGender());
		result.setPhone(dto.getPhone());
		result.setEmail(dto.getEmail());
		result.setAddress(dto.getAddress());
		result.setIntroduce(dto.getIntroduce());
		result.setWebxu(dto.getWebxu());
		return result;
	}
}
