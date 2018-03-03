package com.damdev.question.domain;

import org.springframework.stereotype.Component;

@Component
public class Question {

	private String id;
	private int categoryId;
	private String questionValue;
	private int isApply;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}

	public int getIsApply() {
		return isApply;
	}

	public void setIsApply(int isApply) {
		this.isApply = isApply;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", categoryId=" + categoryId + ", questionValue="
			+ questionValue + ", isApply=" + isApply + "]";
	}
}
