package com.damdev.question.service.impl;

import com.damdev.question.domain.CateNewReg;
import com.damdev.question.domain.CategoryType;
import com.damdev.question.domain.DocImages;
import com.damdev.question.domain.FeatureExt;
import com.damdev.question.domain.ListString;
import com.damdev.question.repository.ApiRepository;
import com.damdev.question.service.ApiService;
import com.damdev.question.service.AuthService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ApiService")
public class ApiServiceImpl implements ApiService {

	@Autowired
	AuthService authService;

	@Autowired
	ApiRepository apiRepository;
	
	@Override
	public JSONObject seed(HttpServletRequest req, HttpServletResponse res) {
		JSONObject jsonObj = new JSONObject();

		String token = req.getHeader("Authorization");

		if (authService.checkToken(token)) {
			// 카테고리별 url 만들기
			List<Map<String, Object>> questionList = apiRepository.getSeed();
			System.out.println(questionList);
			for (int i = 0; i < questionList.size(); i++) {
				String url = "/doc/" + questionList.get(i).get("categoryName") + "/" + questionList.get(i)
					.get("questionValue");
				jsonObj.put(questionList.get(i).get("categoryName"), url);
			}
		}

		return jsonObj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject document(HttpServletRequest request, HttpServletResponse response, String category, String docid) {
		JSONObject jsonObj = new JSONObject();
		
		String token = request.getHeader("Authorization");
		
		if(authService.checkToken(token)) {
		
			int limit = (int)(Math.random()*100)+1;
			
			CategoryType cateType = new CategoryType();
			cateType.setCategory(category);
			cateType.setCnt(limit);
			cateType.setDocId(docid);
			
			System.out.println(category);
			int cnt = apiRepository.selectCategoryHaveChk(category);
	
			if (cnt <= 0) {
				response.setStatus(400);
				jsonObj.put("result_message", "존재하지 않는 카테고리입니다.");
				return jsonObj;
			}
			
			List<DocImages> imageList = apiRepository.selectDocumentImages(cateType);
			
			String nextUrl = "/doc/"+category+"/";
			
			if(imageList.size() < limit) {
				nextUrl += docid;
				
				int newRegCnt = (int)(Math.random()*9000)+1000;
				int regCnt = 0;
				
				System.out.println(newRegCnt+"개 갱신");
				
				for(int i=0;i<newRegCnt;i++) {
					CateNewReg cateNewReg = new CateNewReg();
					
					UUID uuid = UUID.randomUUID();
					String strUID = uuid.toString().replaceAll("-", "").substring(0, 10);
					int random = (int)(Math.random())*10;
					int isApply = (random >= 3 && random <=6)?1:2;
					
					cateNewReg.setCategoryName(category);
					cateNewReg.setuId(strUID);
					cateNewReg.setIsApply(isApply);
					
					int addCnt = apiRepository.insertNewRegQuestion(cateNewReg);
					regCnt += addCnt;
					
					System.out.println(regCnt+"번째 정보 : "+cateNewReg.toString());
				}
				
			} else {
				nextUrl += imageList.get(imageList.size()-1).getId();
				imageList.remove(imageList.size()-1);
			}
			
			jsonObj.put("next_url", nextUrl);
			jsonObj.put("images", imageList);

		}
		return jsonObj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject featureExtraction(HttpServletRequest request, HttpServletResponse response, String[] idArr) {
		JSONObject jsonObj = new JSONObject();
		
		String token = request.getHeader("Authorization");
		
		if(authService.checkToken(token)) {
			List<String> idList = new ArrayList<String>();
			
			System.out.println(idArr.length+"개 id 요청");
			for(int i=0;i<idArr.length;i++) {
				System.out.println(idArr[i]);
				idList.add(idArr[i]);
			}
			
			ListString listString = new ListString();
			listString.setListString(idList);
			List<FeatureExt> features = apiRepository.selectFeatureExtraction(listString);
			
			jsonObj.put("features", features);
		}
		
		return jsonObj;
	}
	
}
