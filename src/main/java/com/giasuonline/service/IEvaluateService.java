package com.giasuonline.service;

import java.util.List;

import com.giasuonline.dto.EvaluateDTO;

public interface IEvaluateService {
	List<EvaluateDTO> findAll();
	EvaluateDTO findById(long id);
	EvaluateDTO findByTeacherId(long id);
	EvaluateDTO save(EvaluateDTO dto);
	void delete(long[] ids);
}
