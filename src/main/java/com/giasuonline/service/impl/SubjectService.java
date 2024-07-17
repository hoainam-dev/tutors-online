package com.giasuonline.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giasuonline.converter.SubjectConverter;
import com.giasuonline.dto.SubjectDTO;
import com.giasuonline.entity.SubjectEntity;
import com.giasuonline.repository.SubjectRepository;
import com.giasuonline.service.ISubjectService;

@Service
public class SubjectService implements ISubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private SubjectConverter subjectConverter;

//	@Override
//	public List<SubjectDTO> findAll(Pageable pageable) {
//		List<SubjectDTO> models = new ArrayList<>();
//		List<SubjectEntity> entities = subjectRepository.findAll(pageable).getContent();
//		for(SubjectEntity item: entities) {
//			SubjectDTO subjectModel = new SubjectDTO();
//			subjectModel.setId(item.getId());
//			subjectModel.setSubjectName(item.getSubjectName());
//			models.add(subjectModel);
//		}
//		
//		return models;
//	}
	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<SubjectEntity> entities = subjectRepository.findAll();
		for (SubjectEntity item: entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}
	
	@Override
	public int getTotalItem() {
		return (int) subjectRepository.count();
	}

	@Override
	public SubjectDTO findById(long id) {
		SubjectEntity entity = subjectRepository.findOne(id);
		return subjectConverter.toDto(entity);
	}

	@Override
	@Transactional
	public SubjectDTO save(SubjectDTO dto) {
		SubjectEntity subjectEntity = new SubjectEntity();
		if (dto.getId() != null) {
			SubjectEntity oldSubject = subjectRepository.findOne(dto.getId());
			subjectEntity = subjectConverter.toEntity(oldSubject, dto);
		} else {
			subjectEntity = subjectConverter.toEntity(dto);
		}
		return subjectConverter.toDto(subjectRepository.save(subjectEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			subjectRepository.delete(id);
		}
	}
}
