package com.giasuonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giasuonline.entity.TeacherStudentEntity;

public interface TeacherStudentRepository extends JpaRepository<TeacherStudentEntity, Long>{
	
}
