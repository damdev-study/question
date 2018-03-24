package com.damdev.question.domain;

import com.fasterxml.jackson.annotation.JsonView;

public class SaveFeature {
	@JsonView
	private String id;
	@JsonView	
	private int tokenId;
	@JsonView
	private String feature;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	@Override
	public String toString() {
		return "SaveFeature [id=" + id + ", tokenId=" + tokenId + ", feature=" + feature + "]";
	}
	
}
