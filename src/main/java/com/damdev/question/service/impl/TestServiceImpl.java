package com.damdev.question.service.impl;

import com.damdev.question.dao.TestDAO;
import com.damdev.question.domain.CateListDomain;
import com.damdev.question.domain.Feature;
import com.damdev.question.domain.Question;
import com.damdev.question.repository.TestRepository;
import com.damdev.question.service.TestService;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource(name = "testDAO")
	private TestDAO testDAO;

	@Autowired
	private TestRepository testRepository;

	@Override
	public List<CateListDomain> chkCategoryList() throws Exception {
		List<CateListDomain> cateList = testDAO.selectCategoryList();

		return cateList;
	}

	@Override
	public int pushQuestion() throws Exception {
		List<CateListDomain> cateList = testDAO.selectCategoryList();

		int resultCode = 0;

		for (CateListDomain cate : cateList) {
			for (int i = 0; i < 10000; i++) {
				UUID uuid = UUID.randomUUID();
				String strUID = uuid.toString().replaceAll("-", "").substring(0, 10);

				int addCode = testDAO.insertQuestionData(cate.getId(), strUID);
				resultCode += addCode;

				System.out.println(resultCode + " 번째 uuid : " + strUID);
			}
		}

		return resultCode;
	}

	@Override
	public int questionCount() {

		int count = testRepository.questionCount();

		return count;
	}

	@Override
	public JSONObject insertFeature() {

		JSONObject jsonObj = new JSONObject();
		List<Question> list = testRepository.getQuestionList();

		int ret = 0;

		for (int i = 0; i < list.size(); i++) {
			int random = (int) (Math.random() * 100000000);

			Feature feature = new Feature();
			feature.setFeature(random);
			feature.setQuestionValue(list.get(i).getQuestionValue());

			ret += testRepository.insertFeature(feature);
		}

		jsonObj.put("count", ret);

		return jsonObj;
	}
}
