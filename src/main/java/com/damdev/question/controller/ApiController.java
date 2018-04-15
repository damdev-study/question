package com.damdev.question.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.damdev.question.domain.SaveFeature;
import com.damdev.question.domain.SaveList;
import com.damdev.question.service.ApiService;


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
		return apiService.document(request, response, category, docid);
	}
	
	@GetMapping("/image/feature")
	public JSONObject featureExtraction(HttpServletRequest request, HttpServletResponse response, @Param(value = "id") String[] id) {
		return apiService.featureExtraction(request, response, id);
	}
	
	@PostMapping(value = "/image/feature", produces = "application/json")
	public JSONObject featureSave(HttpServletRequest request, HttpServletResponse response, @RequestBody SaveList data) {
		return apiService.featureSave(request, response, data);
	}
	
	@PostMapping(value = "/image/test")
	public void testeSave(HttpServletRequest request, HttpServletResponse response, @RequestBody SaveFeature[] data) {
		System.out.println(data.toString());
	}
}
