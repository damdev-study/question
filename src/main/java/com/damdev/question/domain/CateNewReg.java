package com.damdev.question.domain;

public class CateNewReg {
	private String categoryName;
	private String uId;
	private int isApply;
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public int getIsApply() {
		return isApply;
	}

	public void setIsApply(int isApply) {
		this.isApply = isApply;
	}

	@Override
	public String toString() {
		return "CateNewReg [categoryName=" + categoryName + ", uId=" + uId + ", isApply=" + isApply + "]";
	}
	
}
