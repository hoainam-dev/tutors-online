package com.giasuonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giasuonline.entity.TeacherEntity;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>{
	TeacherEntity findOneByEmail(String email);
}
