package com.damdev.question.repository;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.damdev.question.domain.CateNewReg;
import com.damdev.question.domain.CategoryType;
import com.damdev.question.domain.DocImages;

@Repository
public interface ApiRepository {

	List<Map<String, Object>> getSeed();
	
	List<DocImages> selectDocumentImages(CategoryType category);
	
	int selectCategoryHaveChk(String category);
	
	int insertNewRegQuestion(CateNewReg cateNewReg);
}
