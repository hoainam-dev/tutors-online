package com.giasuonline.service;

import com.giasuonline.dto.UserDTO;

public interface IUserService{
	UserDTO findById(long id);
	UserDTO findOneByUserNameAndStatus(String userName, int status);
	UserDTO save(UserDTO dto);
	void delete(long[] ids);
}
