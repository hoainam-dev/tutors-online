package com.giasuonline.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giasuonline.converter.EvaluateConverter;
import com.giasuonline.dto.EvaluateDTO;
import com.giasuonline.entity.EvaluateEntity;
import com.giasuonline.repository.EvalueteRepository;
import com.giasuonline.service.IEvaluateService;

@Service
public class EvaluateService  implements IEvaluateService{

	@Autowired
	private EvalueteRepository evalueteRepository;
	
	@Autowired
	private EvaluateConverter evaluateConverter;
	
	@Override
	public List<EvaluateDTO> findAll() {
		List<EvaluateDTO> models = new ArrayList<>();
		List<EvaluateEntity> entities = evalueteRepository.findAll();
		for(EvaluateEntity item: entities) {
			EvaluateDTO evaluateModel = evaluateConverter.toDto(item);
			models.add(evaluateModel);
		}
		return models;
	}
	
	@Override
	public EvaluateDTO findById(long id) {
		EvaluateEntity entity = evalueteRepository.findOne(id);
		return evaluateConverter.toDto(entity);
	}
	
	@Override
	public EvaluateDTO findByTeacherId(long id) {
		EvaluateEntity entity = evalueteRepository.findOneByTeacherId(id);
		return evaluateConverter.toDto(entity);
	}
	
	@Override
	@Transactional
	public EvaluateDTO save(EvaluateDTO dto) {
		EvaluateEntity evaluateEntity = new EvaluateEntity();
		if (dto.getId() != null) {
			EvaluateEntity oldEvaluate = evalueteRepository.findOne(dto.getId());
			evaluateEntity = evaluateConverter.toEntity(oldEvaluate, dto);
		} else {
			evaluateEntity = evaluateConverter.toEntity(dto);
		}
		return evaluateConverter.toDto(evalueteRepository.save(evaluateEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			evalueteRepository.delete(id);
		}
	}

}
