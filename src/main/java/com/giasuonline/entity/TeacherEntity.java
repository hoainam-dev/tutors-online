package com.giasuonline.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class TeacherEntity extends BaseEntity {

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "birthDate")
	private String birthDate;

	@Column(name = "gender")
	private String gender;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "introduce", columnDefinition = "TEXT")
	private String introduce;

	@Column(name = "webxu")
	private BigDecimal webxu;
	
	@OneToOne(mappedBy = "teacher")
    private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id")
	private SubjectEntity subject;
	
	@OneToMany(mappedBy = "teacher")
	 private List<TeacherStudentEntity> studentTeachers = new ArrayList<>();

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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public BigDecimal getWebxu() {
		return webxu;
	}

	public void setWebxu(BigDecimal webxu) {
		this.webxu = webxu;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public List<TeacherStudentEntity> getStudentTeachers() {
		return studentTeachers;
	}

	public void setStudentTeachers(List<TeacherStudentEntity> studentTeachers) {
		this.studentTeachers = studentTeachers;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
