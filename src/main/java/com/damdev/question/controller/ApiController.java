package com.damdev.question.controller;

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
		return apiService.document(response, category, docid);
	}
}
