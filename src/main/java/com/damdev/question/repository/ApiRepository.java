package com.damdev.question.repository;

import com.damdev.question.domain.CateNewReg;
import com.damdev.question.domain.CategoryType;
import com.damdev.question.domain.DocImages;
import com.damdev.question.domain.FeatureExt;
import com.damdev.question.domain.ListString;
import com.damdev.question.domain.SaveFeature;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository {

  List<Map<String, Object>> getSeed();

  List<DocImages> selectDocumentImages(CategoryType category);

  int selectCategoryHaveChk(String category);

  int insertNewRegQuestion(CateNewReg cateNewReg);

  List<FeatureExt> selectFeatureExtraction(ListString listString);

  int insertFeatureSave(SaveFeature data);

  int selectTokenId(String token);

  int deleteFeature(String id);

  // 유저 리스트
  List<Map<String, String>> getUserList();

  // 유저의 토큰 리스트
  List<Map<String, String>> getUserTokenList(String id);

  // 정상 저장된 이미지 수
  int getRightDataCnt(String id);

  // 저장되지 않고 누락된 이미지 수
  int getMissDataCnt(String id);

  // 삭제되지 않고 남아있는 이미지 수
  int getNotDeletedCnt(String id);

  // 총 쿼리량
  int getTotalCnt(String id);

  // 입력해야할 데이터
  List<String> getInsertTotalData();

  // 유저가 입력한 데이터
  List<String> getInsertedData(String id);

}
