package com.giasuonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giasuonline.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	StudentEntity findOneByEmail(String email);
}
