package com.damdev.question.controller;

import com.damdev.question.common.jwt.JwtUtil;
import com.damdev.question.domain.CategoryType;
import com.damdev.question.domain.Token;
import com.damdev.question.service.AuthService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	AuthService authService;

	/**
	 * 토큰 받는 URL
	 *
	 * @param name - 유저 이름
	 * @return {"access_token" : "토큰"}
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/token")
	public JSONObject token(HttpServletResponse response, @RequestParam() String name) {
		return authService.token(response, name);
	}

	/**
	 * 토큰 처리 테스트
	 *
	 * @param request - Headers(Authorization: 토큰)
	 * @return 유저 정보
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/token/test")
	public JSONObject test(HttpServletRequest request) {
		JSONObject jsonObj = new JSONObject();

		System.out.println(request.getHeader("Authorization"));
		String authorization = request.getHeader("Authorization");
		if (authorization != null) {
			String token = authorization.split(" ")[1];
			Token tokenVO = jwtUtil.verifyToken(token);
			System.out.println(tokenVO);
		}

		return jsonObj;
	}

}
