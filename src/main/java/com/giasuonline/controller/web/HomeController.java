package com.giasuonline.controller.web;

/**
 * HomeController.java
 * 
 * Create date 12032023 by NamLD
 * 
 * Version 1.0
 * 
 * @author NamLD
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.giasuonline.converter.SubjectConverter;
import com.giasuonline.dto.StudentDTO;
import com.giasuonline.dto.SubjectDTO;
import com.giasuonline.dto.TeacherDTO;
import com.giasuonline.dto.WebXuDTO;
import com.giasuonline.repository.SubjectRepository;
import com.giasuonline.service.IEvaluateService;
import com.giasuonline.service.IStudentService;
import com.giasuonline.service.ISubjectService;
import com.giasuonline.service.ITeacherService;
import com.giasuonline.service.IWebXuService;
import com.giasuonline.service.ITeacherStudentService;
import com.giasuonline.util.MessageUtil;

/**
 * Method view home controller of web
 * 
 * 
 * @author NamLD
 *
 */
@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	private ITeacherService teacherService;
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ISubjectService subjectService;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private SubjectConverter subjectConverter;
	
	@Autowired
	private IEvaluateService evaluateService;
	
	@Autowired
	private IWebXuService webXuService;

	@Autowired
	private ITeacherStudentService teacherStudentService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	/**
	 * View home page of web
	 * 
	 * 03122023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(@RequestParam(name="paypat", required = false) String message,
								 @RequestParam(name="subject", required = false) String subjectCode) {
		ModelAndView mav = new ModelAndView("web/home");
		List<TeacherDTO> teachers = new ArrayList<>();
		List<WebXuDTO> webXu = webXuService.findAll();
		List<SubjectDTO> subjects = new ArrayList<>();
		for(String item: subjectService.findAll().keySet()) {
			subjects.add(subjectConverter.toDto(subjectRepository.findOneByCode(item)));
		}
		mav.addObject("webXu", webXu);
		mav.addObject("evaluates", evaluateService.findAll());
		mav.addObject("saveTeachers", teacherStudentService.findAll());
		mav.addObject("subjects", subjects);
		mav.addObject("teachers", teacherService.findAll());
		mav.addObject("students", studentService.findAll());
		mav.addObject("teacherForSubjects", teachers);
		mav.addObject("message", message);
		return mav;
	}

	/**
	 * View login page
	 * 
	 * 03152023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "message", required = false) String message) {
		ModelAndView mav = new ModelAndView("web/login");
		if (message != null) {
			mav.addObject("message", message);
			mav.addObject("alert", "success");
		}
		return mav;
	}

	/**
	 * Method Logout
	 * 
	 * 03152023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}

	/**
	 * Method check user not authorize access in admin page
	 * 
	 * 03152023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
	
	/**
	 * Method check which account user want to create
	 * 
	 * 03152023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/dang-ki", method = RequestMethod.GET)
	public ModelAndView checkRegister() {
		ModelAndView teacher = new ModelAndView("web/register/register");
		return teacher;
	}
	
	/**
	 * Method view register page for teacher
	 * 
	 * 03152023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/dang-ki-gia-su", method = RequestMethod.GET)
	public ModelAndView registerTeacher(HttpServletRequest request) {
		ModelAndView teacher = new ModelAndView("web/register/register_teacher");
		TeacherDTO model = new TeacherDTO();
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			teacher.addObject("message", message.get("message"));
			teacher.addObject("alert", message.get("alert"));
		}
		teacher.addObject("subjects", subjectService.findAll());
		teacher.addObject("model", model);
		return teacher;
	}

	/**
	 * Method view register page for student
	 * 
	 * 03152023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/dang-ki-hoc-sinh", method = RequestMethod.GET)
	public ModelAndView registerStudent(HttpServletRequest request) {
		ModelAndView student = new ModelAndView("web/register/register_student");
		StudentDTO model = new StudentDTO();
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			student.addObject("message", message.get("message"));
			student.addObject("alert", message.get("alert"));
		}
		student.addObject("model", model);
		return student;
	}
}
