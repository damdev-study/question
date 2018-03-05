package com.damdev.question.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

import com.damdev.question.domain.CategoryType;

public interface ApiService {

	/**
	 * Seed API
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	JSONObject seed(HttpServletRequest req, HttpServletResponse res);
	
	/**
	 * Doc API
	 * 
	 * @param response
	 * @param category
	 * @return
	 */
	JSONObject document(HttpServletResponse response, String category, String docId);
}
