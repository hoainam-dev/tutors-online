package com.giasuonline.dto;

public class TeacherStudentDTO extends AbstractDTO<TeacherStudentDTO>{
	private Long teacherId;
	private Long studentId;
	
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
