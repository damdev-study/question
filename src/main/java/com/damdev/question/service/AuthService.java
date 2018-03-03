package com.damdev.question.service;

import com.damdev.question.domain.CategoryType;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

public interface AuthService {

	/**
	 * 토큰 발급
	 *
	 * @param response - 에러 시에 응답코드 쓰기 위해 사용
	 * @param name 
	 * @return
	 */
	JSONObject token(HttpServletResponse response, String name);

	/**
	 * 토큰 체크
	 *
	 * @param token
	 * @return
	 */
	boolean checkToken(String token);
	
}
