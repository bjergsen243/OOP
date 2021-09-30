package com.thanhson;

public class DictionaryCommandLine {
  DictionaryManagement dic = new DictionaryManagement();
  public void showAllWords(){

  }
  public void dictionaryBasic(){
    dic.insertFromCommandLine();
    showAllWords();
  }
}
