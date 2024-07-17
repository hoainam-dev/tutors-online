package com.giasuonline.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="evaluate")
public class EvaluateEntity extends BaseEntity{
	
	@Column(name = "numberStar")
	private BigDecimal numberStar;
	
	@Column(name = "favourite")
	private Boolean favourite;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "level")
	private BigDecimal level;
	
	@Column(name = "teacher_id")
	private Long teacherId;
	
	@Column(name = "student_id")
	private Long studentId;

	public BigDecimal getNumberStar() {
		return numberStar;
	}

	public void setNumberStar(BigDecimal numberStar) {
		this.numberStar = numberStar;
	}

	public Boolean getFavourite() {
		return favourite;
	}

	public void setFavourite(Boolean favourite) {
		this.favourite = favourite;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BigDecimal getLevel() {
		return level;
	}

	public void setLevel(BigDecimal level) {
		this.level = level;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	
}
