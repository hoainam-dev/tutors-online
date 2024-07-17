package com.giasuonline.dto;

import java.math.BigDecimal;

public class EvaluateDTO extends AbstractDTO<EvaluateDTO>{
	
	private BigDecimal numberStar;
	private Boolean favourite;
	private String comment;
	private BigDecimal level;
	private Long studentId;
	private Long teacherId;
	
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
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	
	
}
