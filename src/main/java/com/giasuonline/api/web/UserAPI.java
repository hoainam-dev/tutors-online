package com.giasuonline.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giasuonline.dto.UserDTO;
import com.giasuonline.service.IUserService;

@RestController(value = "userAPIOfWeb")
public class UserAPI {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/user")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
	@PutMapping("/api/user")
	public UserDTO updateUser(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
	@DeleteMapping("/api/user")
	public void deleteUser(@RequestBody long[] ids) {
		System.out.println("delete successfully!");
	}
}
