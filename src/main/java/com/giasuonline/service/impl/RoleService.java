package com.giasuonline.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giasuonline.converter.RoleConverter;
import com.giasuonline.dto.RoleDTO;
import com.giasuonline.entity.RoleEntity;
import com.giasuonline.repository.RoleRepository;
import com.giasuonline.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Override
	public List<RoleDTO> findAll(Pageable pageable) {
		List<RoleDTO> models = new ArrayList<>();
		List<RoleEntity> entities = roleRepository.findAll(pageable).getContent();
		for(RoleEntity item: entities) {
			RoleDTO roleModel = new RoleDTO();
			roleModel.setId(item.getId());
			roleModel.setCode(item.getCode());
			roleModel.setRole_name(item.getRole_name());
			models.add(roleModel);
		}
		
		return models;
	}
	
	@Override
	public int getTotalItem() {
		return (int) roleRepository.count();
	}

	@Override
	public RoleDTO findById(long id) {
		RoleEntity entity = roleRepository.findOne(id);
		return roleConverter.toDto(entity);
	}
	
	@Override
	@Transactional
	public RoleDTO save(RoleDTO dto) {
		RoleEntity roleEntity = new RoleEntity();
		if (dto.getId() != null) {
			RoleEntity oldRole = roleRepository.findOne(dto.getId());
			roleEntity = roleConverter.toEntity(oldRole, dto);
		} else {
			roleEntity = roleConverter.toEntity(dto);
		}
		return roleConverter.toDto(roleRepository.save(roleEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			roleRepository.delete(id);
		}
	}
}