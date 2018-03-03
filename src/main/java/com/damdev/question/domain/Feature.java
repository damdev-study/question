package com.damdev.question.domain;

public class Feature {

	private String id;
	private int feature;
	private String questionValue;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFeature() {
		return feature;
	}

	public void setFeature(int feature) {
		this.feature = feature;
	}

	public String getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}

	@Override
	public String toString() {
		return "Feature [id= " + id + ", feature=" + feature + ", questionValue=" + questionValue + "]";
	}
}
