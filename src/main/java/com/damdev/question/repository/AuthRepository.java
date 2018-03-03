package com.damdev.question.repository;

import com.damdev.question.domain.CategoryType;
import com.damdev.question.domain.DocImages;
import com.damdev.question.domain.Token;
import com.damdev.question.domain.User;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository {

	User getUser(String name);

	Token getTokenInfo(User user);

	int insertTokenInfo(Token token);

	int updateTokenInfo(Token token);
	
}
