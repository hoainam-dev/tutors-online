package com.giasuonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giasuonline.entity.EvaluateEntity;

public interface EvalueteRepository extends JpaRepository<EvaluateEntity, Long>{
	EvaluateEntity findOneByTeacherId(Long id);
}
