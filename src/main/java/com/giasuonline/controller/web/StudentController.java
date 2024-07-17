package com.giasuonline.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.giasuonline.dto.StudentDTO;
import com.giasuonline.dto.TeacherDTO;
import com.giasuonline.dto.TeacherStudentDTO;
import com.giasuonline.service.IStudentService;
import com.giasuonline.service.ITeacherService;
import com.giasuonline.service.ITeacherStudentService;
import com.giasuonline.util.MessageUtil;

/**
 * Method student controller of web
 * 
 * 
 * @author NamHH
 *
 */
@Controller
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ITeacherService teacherService;
	
	@Autowired
	private ITeacherStudentService teacherStudentService;
	
	@Autowired
	private MessageUtil messageUtil;


	/**
	 * View update student of web
	 * 
	 * 03152023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "hoc-sinh/thong-tin-ca-nhan", method = RequestMethod.GET)
	public ModelAndView updateStudent(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/student/edit");
		StudentDTO model = new StudentDTO();
		if (id != null) {
			model = studentService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	/**
	 * Show Teacher have been saved of web
	 * 
	 * 03232023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "hoc-sinh/luu-gia-su", method = RequestMethod.GET)
	public ModelAndView showSavedTeacher(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/student/save_teacher");
		StudentDTO student = new StudentDTO();
		List<TeacherDTO> teachers = new ArrayList<>();
		if (id != null) {
			student = studentService.findById(id);
			for(TeacherStudentDTO item: teacherStudentService.findAll()) {
				System.out.println(item.getDeleteAt());
				if(item.getStudentId()==id && item.getDeleteAt()==null) {
					teachers.add(teacherService.findById(item.getTeacherId()));
				}
			}
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("teachers", teachers);
		mav.addObject("student", student);
		mav.addObject("saveTeachers", teacherStudentService.findAll());
		return mav;
	}

}
