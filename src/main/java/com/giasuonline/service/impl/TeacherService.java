package com.giasuonline.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giasuonline.converter.TeacherConverter;
import com.giasuonline.dto.TeacherDTO;
import com.giasuonline.entity.SubjectEntity;
import com.giasuonline.entity.TeacherEntity;
import com.giasuonline.repository.SubjectRepository;
import com.giasuonline.repository.TeacherRepository;
import com.giasuonline.service.ITeacherService;

@Service
public class TeacherService implements ITeacherService{
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private TeacherConverter teacherConverter;
	
	@Override
	public List<TeacherDTO> findAll(Pageable pageable) {
		List<TeacherDTO> models = new ArrayList<>();
		List<TeacherEntity> entities = teacherRepository.findAll(pageable).getContent();
		for(TeacherEntity item: entities) {
			TeacherDTO teacherModel = new TeacherDTO();
			teacherModel.setId(item.getId());
			teacherModel.setFirstName(item.getFirstName());
			teacherModel.setLastName(item.getLastName());
			teacherModel.setBirthDate(item.getBirthDate());
			teacherModel.setEmail(item.getEmail());
			teacherModel.setAddress(item.getAddress());
			teacherModel.setPhone(item.getPhone());
			teacherModel.setGender(item.getGender());
			teacherModel.setIntroduce(item.getIntroduce());
			teacherModel.setSubjectId(item.getSubject().getId());
			models.add(teacherModel);
		}
		
		return models;
	}
	
	@Override
	public List<TeacherDTO> findAll() {
		List<TeacherDTO> models = new ArrayList<>();
		List<TeacherEntity> entities = teacherRepository.findAll();
		for(TeacherEntity item: entities) {
			TeacherDTO teacherModel = teacherConverter.toDto(item);
			models.add(teacherModel);
		}
		return models;
	}
	
	@Override
	public int getTotalItem() {
		return (int) teacherRepository.count();
	}
	
	@Override
	public TeacherDTO findById(long id) {
		TeacherEntity entity = teacherRepository.findOne(id);
		return teacherConverter.toDto(entity);
	}
	
	@Override
	public Map<Long, String> findAllMap() {
		Map<Long, String> result = new HashMap<>();
		List<TeacherEntity> entities = teacherRepository.findAll();
		for (TeacherEntity item: entities) {
			result.put(item.getId(), item.getEmail());
		}
		return result;
	}
	
	@Override
	@Transactional
	public TeacherDTO save(TeacherDTO dto) {
		SubjectEntity subject = subjectRepository.findOneByCode(dto.getSubjectCode());
		TeacherEntity teacherEntity = new TeacherEntity();
		if (dto.getId() != null) {
			TeacherEntity oldTeacher = teacherRepository.findOne(dto.getId());
			oldTeacher.setSubject(subject);
			teacherEntity = teacherConverter.toEntity(oldTeacher, dto);
		} else {
			teacherEntity = teacherConverter.toEntity(dto);
			teacherEntity.setSubject(subject);
		}
		return teacherConverter.toDto(teacherRepository.save(teacherEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			teacherRepository.delete(id);
		}
	}
}
