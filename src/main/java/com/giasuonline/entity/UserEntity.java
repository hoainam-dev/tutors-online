package com.giasuonline.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;
	
	@Column(name = "fullname")
	private String fullName;

	@Column
	private Integer status;
	
	@OneToOne(mappedBy = "user")
    private WebxuEntity webxu;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private TeacherEntity teacher;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private StudentEntity student;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), 
								  inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles = new ArrayList<>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

	public TeacherEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public WebxuEntity getWebxu() {
		return webxu;
	}

	public void setWebxu(WebxuEntity webxu) {
		this.webxu = webxu;
	}
	
}
