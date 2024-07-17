package com.giasuonline.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giasuonline.dto.StudentDTO;
import com.giasuonline.service.IStudentService;

@RestController(value = "studentAPIOfWeb")
public class StudentAPI {
	
	@Autowired
	private IStudentService studentService;
	
	@PostMapping("/api/student")
	public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
		return studentService.save(studentDTO);
	}
	
	@PutMapping("/api/student")
	public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) {
		return studentService.save(studentDTO);
	}
	
	@DeleteMapping("/api/student")
	public void deleteStudent(@RequestBody long[] ids) {
		studentService.delete(ids);
		System.out.println("delete successfully!");
	}
}
