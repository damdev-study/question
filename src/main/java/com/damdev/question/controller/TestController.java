package com.damdev.question.controller;

import com.damdev.question.dao.TestDAO;
import com.damdev.question.domain.CateListDomain;
import com.damdev.question.service.TestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("/")
	public String testHello() throws Exception {
		String result = "Hello";

		return result;
	}

	@RequestMapping("/category")
	public String testDBConntect() throws Exception {
		String result = "실패";

		List<CateListDomain> cateList = testService.chkCategoryList();
		System.out.println(cateList.toString());

		ObjectMapper mapper = new ObjectMapper();
		result = mapper.writeValueAsString(cateList);

		return result; 
	}

	@RequestMapping("/input")
	public String pushQuestionData() throws Exception {
		//int resultCode = testService.pushQuestion();
		int resultCode = 0;

		String resultMsg = resultCode + "건 데이터 추가";

		return resultMsg;
	}

	@GetMapping("/question/count")
	public int questionCount() {
		return testService.questionCount();
	}

	@GetMapping("/feature/insert")
	public JSONObject insertFeature() {
		return testService.insertFeature();
	}
}