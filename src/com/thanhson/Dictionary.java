package com.thanhson;

import java.util.ArrayList;

public class Dictionary {
  private int numOfWords = 0;
  private ArrayList<Word> wordArrayList;

  public Dictionary() {
    wordArrayList = new ArrayList<>();
  }

  public Dictionary(ArrayList newWordArrayList) {
    this.numOfWords = newWordArrayList.size();
    this.wordArrayList = newWordArrayList;
  }

  public int getNumOfWords() {
    return numOfWords;
  }

  public void setNumOfWords(int numOfWords) {
    this.numOfWords = numOfWords;
  }

  public ArrayList<Word> getWordArrayList() {
    return wordArrayList;
  }

  public void setWordArrayList(ArrayList<Word> wordArrayList) {
    this.wordArrayList = wordArrayList;
  }
}
