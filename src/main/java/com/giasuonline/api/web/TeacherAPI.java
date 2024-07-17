package com.giasuonline.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giasuonline.dto.TeacherDTO;
import com.giasuonline.service.ITeacherService;

@RestController(value = "teacherAPIOfWeb")
public class TeacherAPI {
	
	@Autowired
	private ITeacherService teacherService;
	
	@GetMapping("/api/teacher")
	public List<TeacherDTO> getTeacher() {
		List<TeacherDTO> teachers = teacherService.findAll();
		return teachers;
	}
	
	@PostMapping("/api/teacher")
	public TeacherDTO createTeacher(@RequestBody TeacherDTO teacherDTO) {
		return teacherService.save(teacherDTO);
	}
	
	@PutMapping("/api/teacher")
	public TeacherDTO updateTeacher(@RequestBody TeacherDTO teacherDTO) {
		return teacherService.save(teacherDTO);
	}
	
	@DeleteMapping("/api/teacher")
	public void deleteTeacher(@RequestBody long[] ids) {
		teacherService.delete(ids);
		System.out.println("delete successfully!");
	}
}
