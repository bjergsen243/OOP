package com.thanhson;

public class DictionaryCommandLine {
  public static void showAllWords(Dictionary dictionary) {
    System.out.format("%-5s%-10s%-20s\n", "No", "English", "Vietnamese");
    for (int i = 0; i < dictionary.getNumOfWords(); i++) {
      System.out.format("%-5d%-10s%-20s\n", i+1, dictionary.getWordArray()[i].getWordTarget(), dictionary.getWordArray()[i].getWordExplain());
    }
  }
  public static void dictionaryBasic(DictionaryManagement manager) {
    manager.insertFromCommandLine();
    showAllWords(manager.getDictionary());
  }
  public static void dictionaryAdvanced(DictionaryManagement manager) {
    manager.insertFromFile();
    showAllWords(manager.getDictionary());
    manager.dictionaryLookup();
  }
}
