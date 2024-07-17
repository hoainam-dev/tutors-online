package com.giasuonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giasuonline.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findOneByUserNameAndStatus(String name, int status);
}
