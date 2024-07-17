package com.giasuonline.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "webxu")
public class WebxuEntity extends BaseEntity{
	
	@Column(name = "current_xu")
	private BigDecimal current_xu;
	
	@Column(name = "need_xu")
	private BigDecimal need_xu;
	
	@Column(name = "total_xu")
	private BigDecimal total_xu;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

	public BigDecimal getCurrent_xu() {
		return current_xu;
	}

	public void setCurrent_xu(BigDecimal current_xu) {
		this.current_xu = current_xu;
	}

	public BigDecimal getNeed_xu() {
		return need_xu;
	}

	public void setNeed_xu(BigDecimal need_xu) {
		this.need_xu = need_xu;
	}

	public BigDecimal getTotal_xu() {
		return total_xu;
	}

	public void setTotal_xu(BigDecimal total_xu) {
		this.total_xu = total_xu;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
