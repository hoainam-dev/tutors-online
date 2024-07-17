package com.giasuonline.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.giasuonline.dto.SubjectDTO;
import com.giasuonline.service.ISubjectService;
import com.giasuonline.util.MessageUtil;

/**
 * Method view subject controller of admin
 * 
 * 
 * @author NamHH
 *
 */
@Controller
public class SubjectController {
	
	@Autowired
	private ISubjectService subjectService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	/**
	 * View list subject page of admin
	 * 
	 * 03162023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
//	@RequestMapping(value = "/quan-tri/mon-hoc/danh-sach", method = RequestMethod.GET)
//	public ModelAndView showSubjectList(@RequestParam("page") int page, 
//			 						 @RequestParam("limit") int limit,
//			 						 HttpServletRequest request) {
//		SubjectDTO model = new SubjectDTO();
//		model.setPage(page);
//		model.setLimit(limit);
//		ModelAndView mav = new ModelAndView("admin/subject/list");
//		Pageable pageable = new PageRequest(page - 1, limit);
//		model.setListResult(subjectService.findAll(pageable));
//		model.setTotalItem(subjectService.getTotalItem());
//		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
//		if (request.getParameter("message") != null) {
//			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
//			mav.addObject("message", message.get("message"));
//			mav.addObject("alert", message.get("alert"));
//		}
//		mav.addObject("model", model);
//		return mav;
//	}

}
