package com.damdev.question.domain;

public class DocImages {
	private String type;
	private String id;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DocImages [type=" + type + ", id=" + id + "]";
	}
	
}
