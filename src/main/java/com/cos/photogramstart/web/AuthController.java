package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // DI 첫번째 방법(final 필드 DI)
@Controller // IoC, 파일 리턴 컨트롤러
public class AuthController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	// @Autowired // DI 두번째 방법
	private final AuthService authService;

	// DI 세번째 방법
	// public AuthController(AuthService authService) {
	// this.authService = authService;
	// }

	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}

	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}

	@PostMapping("/auth/signup")
	public String signup(SignupDto signupDto) { // key=value(x-www-form-urlencoded)
		log.info("디버그 : " + signupDto.toString());

		// User <- signupDto
		User user = signupDto.toEntity();
		log.info("디버그 : " + user.toString());

		User userEntity = authService.회원가입(user);
		log.info("디버그 : " + userEntity);

		return "auth/signin";
	}

}
