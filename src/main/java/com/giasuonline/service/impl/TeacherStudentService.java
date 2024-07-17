package com.giasuonline.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giasuonline.converter.TeacherStudentConverter;
import com.giasuonline.dto.TeacherStudentDTO;
import com.giasuonline.entity.StudentEntity;
import com.giasuonline.entity.TeacherEntity;
import com.giasuonline.entity.TeacherStudentEntity;
import com.giasuonline.repository.StudentRepository;
import com.giasuonline.repository.TeacherRepository;
import com.giasuonline.repository.TeacherStudentRepository;
import com.giasuonline.service.ITeacherStudentService;

@Service
public class TeacherStudentService implements ITeacherStudentService{
	
	@Autowired
	private TeacherStudentRepository teacherStudentRepository;
	
	@Autowired
	private TeacherStudentConverter teacherStudentConverter;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<TeacherStudentDTO> findAll() {
		List<TeacherStudentDTO> models = new ArrayList<>();
		List<TeacherStudentEntity> entities = teacherStudentRepository.findAll();
		for(TeacherStudentEntity item: entities) {
			TeacherStudentDTO teacherStudentModel = teacherStudentConverter.toDto(item);
			models.add(teacherStudentModel);
		}
		return models;
	}
	
	@Override
	@Transactional
	public TeacherStudentDTO save(TeacherStudentDTO dto) {
		StudentEntity student = studentRepository.findOne(dto.getStudentId());
		TeacherEntity teacher = teacherRepository.findOne(dto.getTeacherId());
		TeacherStudentEntity teacherStudentEntity = new TeacherStudentEntity();
		if (dto.getId() != null) {
			TeacherStudentEntity oldTeacherStudent = teacherStudentRepository.findOne(dto.getId());
			oldTeacherStudent.setStudent(student);
			oldTeacherStudent.setTeacher(teacher);
			try {
				teacherStudentEntity = teacherStudentConverter.toEntity(oldTeacherStudent, dto);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			teacherStudentEntity.setStudent(student);
			teacherStudentEntity.setTeacher(teacher);
		}
		return teacherStudentConverter.toDto(teacherStudentRepository.save(teacherStudentEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			teacherStudentRepository.delete(id);
		}
	}
}
