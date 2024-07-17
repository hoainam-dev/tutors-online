package com.giasuonline.dto;

import java.math.BigDecimal;

public class WebXuDTO extends AbstractDTO<WebXuDTO>{
	
	private BigDecimal current_xu;
	private BigDecimal need_xu;
	private BigDecimal total_xu;
    private long user_id;
    
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
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
}
