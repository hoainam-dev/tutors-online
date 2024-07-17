package com.giasuonline.converter;

import org.springframework.stereotype.Component;

import com.giasuonline.dto.UserDTO;
import com.giasuonline.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setUserName(entity.getUserName());
		result.setPassword(entity.getPassword());
		result.setFullName(entity.getFullName());
		if (entity.getStudent() != null) {
			result.setStudent_id(entity.getStudent().getId());
		}
		if (entity.getTeacher() != null) {
			result.setTeacher_id(entity.getTeacher().getId());
		}
		return result;
	}
	
	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
		return result;
	}
	
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
		return result;
	}
}
