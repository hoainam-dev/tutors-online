package com.giasuonline.service;

import java.util.List;
import java.util.Map;

import com.giasuonline.dto.StudentDTO;

public interface IStudentService {
	List<StudentDTO> findAll();
	StudentDTO findById(long id);
	Map<Long, String> findAllMap();
	StudentDTO save(StudentDTO dto);
	void delete(long[] ids);
}
