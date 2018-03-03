package com.damdev.question.domain;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class Token {

	private String id;
	private int userId;
	private String token;
	private java.util.Date regDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Token{" +
			"id='" + id + '\'' +
			", userId=" + userId +
			", token='" + token + '\'' +
			", regDate=" + regDate +
			'}';
	}
}
