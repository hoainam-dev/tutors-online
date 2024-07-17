package com.giasuonline.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.giasuonline.dto.SubjectDTO;

public interface ISubjectService {
//	List<SubjectDTO> findAll(Pageable pageable);
	Map<String, String> findAll();
	int getTotalItem();	
	SubjectDTO findById(long id);
	SubjectDTO save(SubjectDTO dto);
	void delete(long[] ids);
}
