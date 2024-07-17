package com.giasuonline.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_student_rel")
public class TeacherStudentEntity extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private StudentEntity student;

	@ManyToOne
	@JoinColumn(name = "teacher_id")
 	private TeacherEntity teacher;

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public TeacherEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}

	
	
}
