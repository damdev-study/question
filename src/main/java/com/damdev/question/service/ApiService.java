package com.damdev.question.service;

import com.damdev.question.domain.DeleteList;
import com.damdev.question.domain.SaveList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

public interface ApiService {

  /**
   * Seed API
   */
  JSONObject seed(HttpServletRequest req, HttpServletResponse res);

  /**
   * Doc API
   */
  JSONObject document(HttpServletRequest request, HttpServletResponse response, String category, String docId);

  /**
   * Feature Extraction API
   */
  JSONObject featureExtraction(HttpServletRequest request, HttpServletResponse response, String[] idArr);

  /**
   * Feature Save API
   */
  JSONObject featureSave(HttpServletRequest request, HttpServletResponse response, SaveList dataList);

  JSONObject deleteFeature(HttpServletRequest request, HttpServletResponse response, DeleteList data);

}
