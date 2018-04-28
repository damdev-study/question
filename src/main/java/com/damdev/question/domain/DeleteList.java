package com.damdev.question.domain;

import java.util.List;

/**
 * Author : zenic
 * Created : 2018. 4. 21.
 */
public class DeleteList {

  private List<DeleteFeature> data;

  public List<DeleteFeature> getData() {
    return data;
  }

  public void setData(List<DeleteFeature> data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "DeleteList{" +
      "data=" + data +
      '}';
  }
}
