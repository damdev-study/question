package com.damdev.question.controller;

import com.damdev.question.domain.CategoryType;
import com.damdev.question.service.ApiService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@Autowired
	ApiService apiService;

	@GetMapping("/seed")
	public JSONObject seed(HttpServletRequest req, HttpServletResponse res) {
		return apiService.seed(req, res);
	}
	
	@GetMapping("/doc/{category}/{docid}")
	public JSONObject document(HttpServletRequest request, HttpServletResponse response, @PathVariable String category, @PathVariable String docid) {
		JSONObject result = new JSONObject();
		
		int limit = (int)(Math.random()*100)+1;
		
		CategoryType cateType = new CategoryType();
		cateType.setCategory(category);
		cateType.setCnt(limit);
		cateType.setDocId(docid);
		
		result = apiService.document(response, cateType);
		
		return result;
	}
}
