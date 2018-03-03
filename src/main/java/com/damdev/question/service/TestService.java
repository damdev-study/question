package com.damdev.question.service;

import com.damdev.question.domain.CateListDomain;
import java.util.List;
import org.json.simple.JSONObject;

/**
 * @author dongha
 */
public interface TestService {

	public List<CateListDomain> chkCategoryList() throws Exception;

	public int pushQuestion() throws Exception;

	int questionCount();

	JSONObject insertFeature();

}
