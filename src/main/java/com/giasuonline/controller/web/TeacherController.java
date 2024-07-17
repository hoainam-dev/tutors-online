package com.giasuonline.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.giasuonline.dto.EvaluateDTO;
import com.giasuonline.dto.TeacherDTO;
import com.giasuonline.service.IEvaluateService;
import com.giasuonline.service.IStudentService;
import com.giasuonline.service.ISubjectService;
import com.giasuonline.service.ITeacherService;
import com.giasuonline.util.MessageUtil;

/**
 * Method teacher controller of web
 * 
 * 
 * @author NamHH
 *
 */
@Controller
public class TeacherController {

	@Autowired
	private ITeacherService teacherService;
	
	@Autowired
	private ISubjectService subjectService;
	
	@Autowired
	private IEvaluateService evaluateService;
	
	@Autowired
	private IStudentService studentService;

	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/gia-su/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("subjectId") Long id,
								 HttpServletRequest request) {
		TeacherDTO model = new TeacherDTO();
		ModelAndView mav = new ModelAndView("web/teacher/list");
		mav.addObject("model", model);
		return mav;
	}

	/**
	 * View update teacher of web
	 * 
	 * 03152023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "gia-su/thong-tin-ca-nhan", method = RequestMethod.GET)
	public ModelAndView updateTeacher(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/teacher/edit");
		TeacherDTO model = new TeacherDTO();
		if (id != null) {
			model = teacherService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("subjects", subjectService.findAll());
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "gia-su/chi-tiet-gia-su", method = RequestMethod.GET)
	public ModelAndView showDetailTeacher(@RequestParam(value = "id") Long id,
										  @RequestParam(value = "studentID", required=false) Long studentId,
										  HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/teacher/detail");
		EvaluateDTO evaluate = new EvaluateDTO();
		if (id != null) {
			for(EvaluateDTO item:evaluateService.findAll()) {
				if(item.getTeacherId()==id && item.getStudentId()==studentId) {
					evaluate = item;
				}
			}
		}
		if(studentId != null) {
			mav.addObject("student", studentService.findById(studentId));
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("evaluate", evaluate);
		mav.addObject("evaluates", evaluateService.findAll());
		mav.addObject("teachers", teacherService.findAll());
		mav.addObject("teacher", teacherService.findById(id));
		mav.addObject("students", studentService.findAll());
		return mav;
	}
	
	

}
