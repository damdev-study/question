package com.damdev.question.domain;

public class FeatureExt {
	private String image;
	private String feature;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	@Override
	public String toString() {
		return "FeatureExt [image=" + image + ", feature=" + feature + "]";
	}
	
}
