package com.damdev.question.domain;

public class CategoryType {
	private String category;
	private int cnt;
	private String docId;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	@Override
	public String toString() {
		return "CategoryType [category=" + category + ", cnt=" + cnt + ", docId=" + docId + "]";
	}

	
}
