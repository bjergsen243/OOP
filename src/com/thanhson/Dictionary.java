package com.thanhson;

public class Dictionary {
  private int numOfWords = 0;
  private Word[] wordArray;

  public Dictionary() {}

  public Dictionary(int size) {
    wordArray = new Word[size];
    this.numOfWords = size;
  }

  public Dictionary(Word[] newWordArray) {
    this.numOfWords = newWordArray.length;
    this.wordArray = newWordArray;
  }

  public int getNumOfWords() {
    return numOfWords;
  }

  public void setNumOfWords(int numOfWords) {
    this.numOfWords = numOfWords;
  }

  public Word[] getWordArray() {
    return wordArray;
  }

  public void setWordArray(Word[] wordArray) {
    this.wordArray = wordArray;
  }
}
