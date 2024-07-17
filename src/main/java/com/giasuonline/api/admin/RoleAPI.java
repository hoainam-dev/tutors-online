package com.giasuonline.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giasuonline.dto.RoleDTO;
import com.giasuonline.service.IRoleService;

@RestController(value = "roleAPIOfAdmin")
public class RoleAPI {

	@Autowired
	private IRoleService roleService;
	@PostMapping("/api/role")
	public RoleDTO createRole(@RequestBody RoleDTO roleDTO) {
		return roleService.save(roleDTO);
	}
	
	@PutMapping("/api/role")
	public RoleDTO updateRole(@RequestBody RoleDTO updateRole) {
		return roleService.save(updateRole);
	}
	
	@DeleteMapping("/api/role")
	public void deleteRole(@RequestBody long[] ids) {
		roleService.delete(ids);
		System.out.println("delete successfully!");
	}
}
