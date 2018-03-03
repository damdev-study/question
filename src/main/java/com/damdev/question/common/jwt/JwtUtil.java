package com.damdev.question.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.damdev.question.domain.Token;
import com.damdev.question.domain.User;
import com.damdev.question.repository.AuthRepository;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

	// JWT secret key
	@Value("${security.oauth2.resource.jwt.key-value}")
	String secret;

	@Autowired
	AuthRepository authRepository;

	/**
	 * 토큰 생성 (파라미터 미정)
	 *
	 * @param name - 유저 이름
	 * @return 토큰
	 */
	public String encodeToken(String name) {

		String token = "";

		try {
			User user = authRepository.getUser(name);
			System.out.println(user);

			Algorithm algorithm = Algorithm.HMAC256(secret);
			long time = System.currentTimeMillis();
			token = JWT.create()
				.withIssuer("auth0")
				.withClaim("userName", user.getName())
				.withClaim("userId", user.getId())
				.withClaim("regDate", time)
				.sign(algorithm);
		} catch (UnsupportedEncodingException e1) {
			//UTF-8 encoding not supported
			e1.printStackTrace();
		} catch (JWTCreationException e2) {
			//Invalid Signing configuration / Couldn't convert Claims.
			e2.printStackTrace();
		}

		System.out.println("발급 토큰 : " + token);

		return token;
	}

	/**
	 * 토큰 확인
	 *
	 * @param token - 토큰
	 * @return 토큰 내 정보
	 */
	public Token verifyToken(String token) {

		Map<String, Claim> claims;
		Token tokenVO = new Token();

		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm)
				.withIssuer("auth0")
				.build(); //Reusable verifier instance
			DecodedJWT jwt = verifier.verify(token);
			System.out.println("======verifyToken=======");
			claims = jwt.getClaims();    //Key is the Claim name
			System.out.println(claims);
			Claim claim = claims.get("userId");
			System.out.println(claim);
			System.out.println(claim.asInt());
			tokenVO.setUserId(claim.asInt());
			tokenVO.setToken(token);
			System.out.println("======verifyToken=======");
		} catch (UnsupportedEncodingException e) {
			//UTF-8 encoding not supported
			e.printStackTrace();
		} catch (JWTVerificationException e) {
			//Invalid signature/claims
			System.out.println("=== 우리가 만든 토큰이 아님. ===");
		}

		return tokenVO;
	}

	/**
	 * 토큰 디코딩(토큰 확인으로 다 되서 필요 없을듯?)
	 *
	 * @param token - 토큰
	 */
	public void decodeToken(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);

			System.out.println("======decodeToken=======");
			Map<String, Claim> claims = jwt.getClaims();    //Key is the Claim name
			System.out.println(claims);
			Claim claim = claims.get("user");
			System.out.println(claim.asString());
			System.out.println("======decodeToken=======");

		} catch (JWTDecodeException e) {
			//Invalid token
			e.printStackTrace();
		}
	}

}
