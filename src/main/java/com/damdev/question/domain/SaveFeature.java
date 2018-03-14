package com.damdev.question.domain;

public class SaveFeature {
	private String uId;
	private String tokenId;
	private String feature;
	
	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
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
		return "SaveFeature [uId=" + uId + ", tokenId=" + tokenId + ", feature=" + feature + "]";
	}
	
}
