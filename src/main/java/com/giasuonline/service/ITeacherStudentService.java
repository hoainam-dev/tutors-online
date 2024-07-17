package com.giasuonline.service;

import java.util.List;

import com.giasuonline.dto.TeacherStudentDTO;

public interface ITeacherStudentService {
	List<TeacherStudentDTO> findAll();
	TeacherStudentDTO save(TeacherStudentDTO dto);
	void delete(long[] ids);
}
