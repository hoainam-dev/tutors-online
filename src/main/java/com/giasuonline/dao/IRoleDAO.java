package com.giasuonline.dao;

import java.util.List;

import com.giasuonline.model.RoleModel;

public interface IRoleDAO extends GenericDAO<RoleModel>{
	List<RoleModel> findAll();
}