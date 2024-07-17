package com.giasuonline.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.giasuonline.dto.TeacherStudentDTO;
import com.giasuonline.entity.TeacherStudentEntity;

@Component
public class TeacherStudentConverter {
	
	
	public TeacherStudentDTO toDto(TeacherStudentEntity entity) {
		TeacherStudentDTO result = new TeacherStudentDTO();
		result.setId(entity.getId());
		result.setStudentId(entity.getStudent().getId());
		result.setTeacherId(entity.getTeacher().getId());
		return result;
	}
	
	public TeacherStudentEntity toEntity(TeacherStudentDTO dto) throws ParseException {
		TeacherStudentEntity result = new TeacherStudentEntity();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formatter.parse(dto.getDeleteAt()); 
		result.setDelete_at(date);
		result.setDelete_by(dto.getDeleteBy());
		return result;
	}
	
	public TeacherStudentEntity toEntity(TeacherStudentEntity result, TeacherStudentDTO dto) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formatter.parse(dto.getDeleteAt()); 
		result.setDelete_at(date);
		result.setDelete_by(dto.getDeleteBy());
		return result;
	}
}
