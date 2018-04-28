package com.damdev.question.domain;

/**
 * Author : zenic
 * Created : 2018. 4. 21.
 */
public class DeleteFeature {

  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "DeleteFeature{" +
      "id='" + id + '\'' +
      '}';
  }
}
