package com.damdev.question.service.impl;

import com.damdev.question.common.jwt.JwtUtil;
import com.damdev.question.domain.Token;
import com.damdev.question.domain.User;
import com.damdev.question.repository.AuthRepository;
import com.damdev.question.service.AuthService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AuthService")
public class AuthServiceImpl implements AuthService {

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	AuthRepository authRepository;

	@Override
	public JSONObject token(HttpServletResponse response, String name) {
		JSONObject jsonObj = new JSONObject();

		User user = authRepository.getUser(name);
		System.out.println(user);

		if (user == null) {
			response.setStatus(400);
			jsonObj.put("result_message", "등록되지 않은 사용자입니다.");
			return jsonObj;
		}

		// 토큰 생성
		String token = jwtUtil.encodeToken(name);

		Token tokenInfo = authRepository.getTokenInfo(user);
		System.out.println(tokenInfo);

		int ret;
		if (tokenInfo == null) {
			// 토큰 새로 입력
			tokenInfo = new Token();
			tokenInfo.setUserId(user.getId());
			tokenInfo.setToken(token);
		} else {
			// 토큰 추가 입력

			// 시간 확인
			if (calTime(tokenInfo) > 0) {
				response.setStatus(403);
				jsonObj.put("result_message", "토큰을 발급한지 10분이 되지 않았습니다.");
				jsonObj.put("access_token", tokenInfo.getToken());
				return jsonObj;
			}

			tokenInfo.setToken(token);
		}
		ret = authRepository.insertTokenInfo(tokenInfo);

		if (ret > 0) {
			jsonObj.put("access_token", token);
		} else {
			response.setStatus(503);
			jsonObj.put("result_message", "토큰 정보 업데이트 실패");
		}

		return jsonObj;
	}

	@Override
	public boolean checkToken(String token) {
		boolean result = false;

		if (token == null) {
			System.out.println("Header에 Authorization을 입력해주세요.");
		}
		System.out.println(token.split(" ").length);
		System.out.println(token.split(" ")[1].equals("Bearer"));
		if (token.split(" ").length != 2 || !token.split(" ")[0].equals("Bearer")) {
			System.out.println("토큰 타입이 다릅니다.");
		}
		token = token.split(" ")[1];

		Token tokenVO = jwtUtil.verifyToken(token);

		System.out.println(tokenVO);
		User user = new User();
		user.setId(tokenVO.getUserId());

		Token tokenInfo = authRepository.getTokenInfo(user);
		System.out.println(tokenInfo);

		// 시간 확인
		long tokenTime = calTime(tokenInfo);
		// 아직 시간체크는 안함

		if (token.equals(tokenInfo.getToken())) {
			result = true;
		}

		return result;
	}

	public long calTime(Token token) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YMMddHHmmss");

		System.out.println("현재 시간 : " + sdf.format(date));
		System.out.println("등록 시간 : " + sdf.format(token.getRegDate()));

		Calendar cal = Calendar.getInstance();
		cal.setTime(token.getRegDate());
		cal.add(Calendar.MINUTE, 10);
		System.out.println(" + 10분 : " + sdf.format(cal.getTime()));

		long curTime = Long.parseLong(sdf.format(date));
		long compareTime = Long.parseLong(sdf.format(cal.getTime()));

		long result = compareTime - curTime;
		System.out.println("새로운 토큰 발급까지 남은 시간 : " + result);

		return result;
	}

}
