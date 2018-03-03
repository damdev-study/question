package com.damdev.question.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.damdev.question.domain.CateListDomain;

@Repository
public class TestDAO { 

	@Autowired
	private JdbcTemplate jdbcTemp;

	public List<CateListDomain> selectCategoryList(){
		String query = "SELECT category_id AS id, category_name AS name From TB_CATEGORY";

		List<CateListDomain> cateList = jdbcTemp.query(query, new BeanPropertyRowMapper<>(CateListDomain.class));

		return cateList;
	}
	
	public int insertQuestionData(String catagoryId, String uid) {
		String query = "INSERT INTO TB_QUESTION(category_id, u_id, is_apply) VALUES(?, ?, 1)";
		
		int returnCode = jdbcTemp.update(query, catagoryId, uid);
		
		return returnCode;
	}

}