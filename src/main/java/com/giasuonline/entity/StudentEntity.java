package com.giasuonline.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity extends BaseEntity{

	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "is_parent")
	private Boolean is_parent;
	
	@OneToOne(mappedBy = "student")
    private UserEntity user;
	
	@OneToMany(mappedBy = "student")
	private List<TeacherStudentEntity> studentTeachers = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "student_subject_rel", joinColumns = @JoinColumn(name = "student_id"), 
								  inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private List<SubjectEntity> subjects = new ArrayList<>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getIs_parent() {
		return is_parent;
	}

	public void setIs_parent(Boolean is_parent) {
		this.is_parent = is_parent;
	}
	

	public List<TeacherStudentEntity> getStudentTeachers() {
		return studentTeachers;
	}

	public void setStudentTeachers(List<TeacherStudentEntity> studentTeachers) {
		this.studentTeachers = studentTeachers;
	}

	public List<SubjectEntity> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectEntity> subjects) {
		this.subjects = subjects;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
