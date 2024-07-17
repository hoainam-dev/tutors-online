package com.giasuonline.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.giasuonline.model.RoleModel;


public class RoleMapper implements RowMapper<RoleModel>{
	
	@Override
	public RoleModel mapRow(ResultSet resultSet) {
		try {
			RoleModel roles = new RoleModel();
			roles.setId(resultSet.getLong("role_id"));
			roles.setRole_name(resultSet.getString("role_name"));
			roles.setId(resultSet.getLong("id"));
			roles.setRole_name(resultSet.getString("role_name"));
			roles.setCode(resultSet.getString("code"));
			roles.setCreateAt(resultSet.getTimestamp("create_at"));
			roles.setCreateBy(resultSet.getString("create_by"));
			if (resultSet.getTimestamp("update_at") != null) {
				roles.setUpdateAt(resultSet.getTimestamp("update_at"));
			}
			if (resultSet.getString("update_by") != null) {
				roles.setUpdateBy(resultSet.getString("update_by"));
			}
			if (resultSet.getTimestamp("delete_at") != null) {
				roles.setDeleteAt(resultSet.getTimestamp("delete_at"));
			}
			if (resultSet.getString("delete_by") != null) {
				roles.setDeleteBy(resultSet.getString("delete_by"));
			}
			return roles;
		} catch (SQLException e) {
			return null;
		}	
	}
}