package com.giasuonline.controller.admin;

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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Method view home controller of admin
 * 
 * 
 * @author NamLD20
 *
 */
@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	
	/**
	 * View home page of web
	 * 
	 * 03122023 NamHH
	 * 
	 * @author NamHH
	 *
	 */
	@RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
}
