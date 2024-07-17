package com.giasuonline.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giasuonline.converter.StudentConverter;
import com.giasuonline.dto.StudentDTO;
import com.giasuonline.entity.StudentEntity;
import com.giasuonline.repository.StudentRepository;
import com.giasuonline.service.IStudentService;

@Service
public class StudentSevice implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentConverter studentConverter;
	
	@Override
	public List<StudentDTO> findAll() {
		List<StudentDTO> models = new ArrayList<>();
		List<StudentEntity> entities = studentRepository.findAll();
		for(StudentEntity item: entities) {
			StudentDTO studentModel = new StudentDTO();
			studentModel.setId(item.getId());
			studentModel.setFirstName(item.getFirstName());
			studentModel.setLastName(item.getLastName());
			studentModel.setEmail(item.getEmail());
			studentModel.setAddress(item.getAddress());
			studentModel.setPhone(item.getPhone());
			models.add(studentModel);
		}
		return models;
	}
	
	@Override
	public Map<Long , String> findAllMap() {
		Map<Long, String> result = new HashMap<>();
		List<StudentEntity> entities = studentRepository.findAll();
		for (StudentEntity item: entities) {
			result.put(item.getId(), item.getEmail());
		}
		return result;
	}
	
	@Override
	public StudentDTO findById(long id) {
		StudentEntity entity = studentRepository.findOne(id);
		return studentConverter.toDto(entity);
	}
	
	@Override
	@Transactional
	public StudentDTO save(StudentDTO dto) {
		StudentEntity studentEntity = new StudentEntity();
		if (dto.getId() != null) {
			StudentEntity oldStudent = studentRepository.findOne(dto.getId());
			studentEntity = studentConverter.toEntity(oldStudent, dto);
		} else {
			studentEntity = studentConverter.toEntity(dto);
		}
		return studentConverter.toDto(studentRepository.save(studentEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			studentRepository.delete(id);
		}
	}

}
