package com.damdev.question.domain;

import java.util.List;

public class ListString {
	private List<String> listString;

	public List<String> getListString() {
		return listString;
	}

	public void setListString(List<String> listString) {
		this.listString = listString;
	}

	@Override
	public String toString() {
		return "ListString [listString=" + listString + "]";
	}
	
}
