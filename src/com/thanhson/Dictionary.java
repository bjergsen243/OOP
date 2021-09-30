package com.thanhson;
import java.util.ArrayList;
public class Dictionary extends DictionaryManagement{
  private ArrayList<Word> words = new ArrayList<>();

  public ArrayList<Word> getWords() {
    return words;
  }

  public void setWords(ArrayList<Word> words) {
    this.words = words;
  }

  public Dictionary() {}
}
