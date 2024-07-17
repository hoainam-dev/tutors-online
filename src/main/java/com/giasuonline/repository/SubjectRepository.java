package com.giasuonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giasuonline.entity.SubjectEntity;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long>{
	SubjectEntity findOneByCode(String code);
	
}
