package com.damdev.question.domain;

import java.util.List;

public class SaveList {
	private List<SaveFeature> data;
	
	public List<SaveFeature> getData() {
		return data;
	}

	public void setData(List<SaveFeature> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SaveList [data=" + data.toString() + "]";
	}
	
}
