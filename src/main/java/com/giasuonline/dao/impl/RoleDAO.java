package com.giasuonline.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.giasuonline.dao.IRoleDAO;
import com.giasuonline.mapper.RoleMapper;
import com.giasuonline.model.RoleModel;

@Repository
public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {
	
	public final static String sql = "\"SELECT id, role_name, code, \"\r\n" + 
			"				+ \"create_at, create_by, update_at, update_by, delete_at, delete_by \"\r\n" + 
			"				+ \"FROM role\");";
	
	@Override
	public List<RoleModel> findAll() {
		StringBuilder result = new StringBuilder(sql);
		return query(result.toString(), new RoleMapper());
	}
}