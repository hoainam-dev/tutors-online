package com.giasuonline.converter;

import org.springframework.stereotype.Component;

import com.giasuonline.dto.StudentDTO;
import com.giasuonline.entity.StudentEntity;

@Component
public class StudentConverter {
	
	public StudentDTO toDto(StudentEntity entity) {
		StudentDTO result = new StudentDTO();
		result.setId(entity.getId());
		result.setFirstName(entity.getFirstName());
		result.setLastName(entity.getLastName());
		result.setPhone(entity.getPhone());
		result.setEmail(entity.getEmail());
		result.setAddress(entity.getAddress());
		result.setIs_parent(entity.getIs_parent());
		return result;
	}
	
	public StudentEntity toEntity(StudentDTO dto) {
		StudentEntity result = new StudentEntity();
		result.setFirstName(dto.getFirstName());
		result.setLastName(dto.getLastName());
		result.setPhone(dto.getPhone());
		result.setEmail(dto.getEmail());
		result.setAddress(dto.getAddress());
		result.setIs_parent(dto.getIs_parent());
		return result;
	}
	
	public StudentEntity toEntity(StudentEntity result, StudentDTO dto) {
		result.setFirstName(dto.getFirstName());
		result.setLastName(dto.getLastName());
		result.setPhone(dto.getPhone());
		result.setEmail(dto.getEmail());
		result.setAddress(dto.getAddress());
		result.setIs_parent(dto.getIs_parent());
		return result;
	}
}
