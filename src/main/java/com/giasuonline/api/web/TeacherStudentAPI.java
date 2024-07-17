package com.giasuonline.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giasuonline.dto.TeacherStudentDTO;
import com.giasuonline.service.ITeacherStudentService;

@RestController
public class TeacherStudentAPI {
	
	@Autowired
	private ITeacherStudentService teacherStudentService;
	
	@PostMapping("/api/teacher_student")
	public TeacherStudentDTO saveTeacher(@RequestBody TeacherStudentDTO teacherStudentDTO) {
		return teacherStudentService.save(teacherStudentDTO);
	}
	
	@PutMapping("/api/teacher_student")
	public TeacherStudentDTO updateTeacher(@RequestBody TeacherStudentDTO teacherStudentDTO) {
		return teacherStudentService.save(teacherStudentDTO);
	}
}
