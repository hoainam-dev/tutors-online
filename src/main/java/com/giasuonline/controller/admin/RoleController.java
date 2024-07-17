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

import com.giasuonline.dto.RoleDTO;
import com.giasuonline.service.IRoleService;
import com.giasuonline.util.MessageUtil;

/**
 * Method view role controller of admin
 * 
 * 
 * @author NamHH
 *
 */
@Controller
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	/**
	 * View list role page of admin
	 * 
	 * 03122023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/quan-tri/phan-quyen/danh-sach", method = RequestMethod.GET)
	public ModelAndView showRoleList(@RequestParam("page") int page, 
			 						 @RequestParam("limit") int limit,
			 						 HttpServletRequest request) {
		RoleDTO model = new RoleDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/role/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(roleService.findAll(pageable));
		model.setTotalItem(roleService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
//		//filter DeleteAt field in role_account table(!null ? show : don't show)
//		List<RoleModel> roles = roleService.findAll()
//				.stream()
//				.filter(role->role.getDeleteAt()==null)
//				.collect(Collectors.toList());
//		model.setListResult(roles);
//		mav.addObject("model", model);
//		return mav;
	}
	
	/**
	 * View create role page of admin
	 * 
	 * 03122023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/quan-tri/phan-quyen/tao-moi", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/role/edit");
		return mav;
	}
	public ModelAndView createRole() {
		ModelAndView mav = new ModelAndView("admin/role/edit");
		return mav;
	}
	
	/**
	 * View update role page of admin
	 * 
	 * 03122023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/quan-tri/phan-quyen/chinh-sua", method = RequestMethod.GET)
	public ModelAndView updateRole(@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/role/edit");
		RoleDTO model = new RoleDTO();
		if (id != null) {
			model = roleService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}

}