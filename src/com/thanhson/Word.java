package com.thanhson;

public class Word {
  private String wordTarget;
  private String wordExplain;

  Word(String wordTarget, String wordExplain){
    this.wordExplain = wordExplain;
    this.wordTarget = wordTarget;
  }

  public String getWordTarget() {
    return wordTarget;
  }

  public void setWordTarget(String wordTarget) {
    this.wordTarget = wordTarget;
  }

  public String getWordExplain() {
    return wordExplain;
  }

  public void setWordExplain(String wordExplain) {
    this.wordExplain = wordExplain;
  }
}
