package com.giasuonline.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.giasuonline.dto.TeacherDTO;

public interface ITeacherService {
	List<TeacherDTO> findAll(Pageable pageable);
	List<TeacherDTO> findAll();
	int getTotalItem();
	TeacherDTO findById(long id);
	Map<Long, String> findAllMap();
	TeacherDTO save(TeacherDTO dto);
	void delete(long[] ids);
}
