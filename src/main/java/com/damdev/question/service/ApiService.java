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
	JSONObject document(HttpServletRequest request, HttpServletResponse response, String category, String docId);
	
	/**
	 * Feature Extraction API
	 * 
	 * @param request
	 * @param response
	 * @param idArr
	 * @return
	 */
	JSONObject featureExtraction(HttpServletRequest request, HttpServletResponse response, String[] idArr);
	
	/**
	 * Feature Save API
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	JSONObject featureSave(HttpServletRequest request, HttpServletResponse response);
}
