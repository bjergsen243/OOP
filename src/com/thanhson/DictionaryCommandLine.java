package com.thanhson;

public class DictionaryCommandLine {
  public static void showAllWords(Dictionary dictionary) {
    System.out.format("%-5s%-15s%-25s\n", "No", "English", "Vietnamese");
    for (int i = 0; i < dictionary.getNumOfWords(); i++) {
      System.out.format(
          "%-5d%-15s%-25s\n",
          i + 1,
          dictionary.getWordArrayList().get(i).getWordTarget(),
          dictionary.getWordArrayList().get(i).getWordExplain());
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

  public static void dictionaryMoreAdvanced(DictionaryManagement manager) {
    manager.insertFromFile();
    showAllWords(manager.getDictionary());
    manager.dictionarySeacher();
  }

  public static void dictionaryController(DictionaryManagement manager) {
    //manager.controlDictionary();
    manager.dictionaryExportToFile();
    showAllWords(manager.getDictionary());
  }
}
