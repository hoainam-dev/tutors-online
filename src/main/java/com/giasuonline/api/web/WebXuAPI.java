package com.giasuonline.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giasuonline.dto.TeacherDTO;
import com.giasuonline.dto.UserDTO;
import com.giasuonline.dto.WebXuDTO;
import com.giasuonline.entity.WebxuEntity;
import com.giasuonline.repository.UserRepository;
import com.giasuonline.service.ITeacherService;
import com.giasuonline.service.IUserService;
import com.giasuonline.service.IWebXuService;
import com.giasuonline.service.impl.UserService;

/**
 * Method process webxu WebXuAPI of web
 * 
 * 
 * @author NamLD
 *
 */
@RestController(value = "webXuAPIOfWeb")
public class WebXuAPI {

	@Autowired
	private IWebXuService webXuService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ITeacherService teacherService;

	/**
	 * Save webxu
	 * 
	 * @param webXuDTO
	 * @return
	 */
	@PostMapping("/api/webxu")
	public WebXuDTO saveWebXu(@RequestBody WebXuDTO webXuDTO) {
		TeacherDTO teacherDTO = new TeacherDTO();
		// Từ form gửi lên user_id
		// Từ user_id => Teacher id
		UserDTO userDTO = userService.findById(webXuDTO.getUser_id());
		teacherDTO.setId(userDTO.getTeacher_id());
		teacherDTO.setWebxu(webXuDTO.getTotal_xu());
		teacherService.save(teacherDTO);
		return webXuService.save(webXuDTO);
	}

}
