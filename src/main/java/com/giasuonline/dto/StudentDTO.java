package com.giasuonline.dto;

public class StudentDTO extends AbstractDTO<StudentDTO>{
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;
	private Boolean is_parent;
	private Long teacher_id;
	
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
	public Long getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Long teacher_id) {
		this.teacher_id = teacher_id;
	}
	
}
