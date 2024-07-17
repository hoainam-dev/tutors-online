package com.giasuonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giasuonline.converter.UserConverter;
import com.giasuonline.dto.UserDTO;
import com.giasuonline.entity.UserEntity;
import com.giasuonline.repository.UserRepository;
import com.giasuonline.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

//	@Override
//	public List<RoleDTO> findAll(Pageable pageable) {
//		List<RoleDTO> models = new ArrayList<>();
//		List<RoleEntity> entities = roleRepository.findAll(pageable).getContent();
//		for (RoleEntity item : entities) {
//			RoleDTO roleModel = new RoleDTO();
//			roleModel.setId(item.getId());
//			roleModel.setCode(item.getCode());
//			roleModel.setRole_name(item.getRole_name());
//			models.add(roleModel);
//		}
//
//		return models;
//	}
//
//	@Override
//	public int getTotalItem() {
//		return (int) roleRepository.count();
//	}
//
	@Override
	public UserDTO findById(long id) {
		UserEntity entity = userRepository.findOne(id);
		return userConverter.toDto(entity);
	}
	
	@Override
	public UserDTO findOneByUserNameAndStatus(String userName, int status) {
		UserEntity entity = userRepository.findOneByUserNameAndStatus(userName, 1);
		return userConverter.toDto(entity);
	}

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		UserEntity userEntity = new UserEntity();
		if (dto.getId() != null) {
			UserEntity oldUser = userRepository.findOne(dto.getId());
			userEntity = userConverter.toEntity(oldUser, dto);
		} else {
			userEntity = userConverter.toEntity(dto);
		}
		return userConverter.toDto(userRepository.save(userEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			userRepository.delete(id);
		}
	}
}
