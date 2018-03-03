package com.damdev.question.repository;

import com.damdev.question.domain.Feature;
import com.damdev.question.domain.Question;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestRepository {

	int questionCount();

	List<Question> getQuestionList();

	int insertFeature(Feature feature);
}
