package com.thanhson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement {
  Scanner sc = new Scanner(System.in);
  Dictionary dictionary = new Dictionary();
  ArrayList<Word> currWordArrayList = dictionary.getWordArrayList();

  public void insertFromCommandLine() {
    int newNumOfWords = 0;
    int oldNumOfWords = dictionary.getNumOfWords();
    boolean checkInput = true;
    do {
      try {
        checkInput = false;
        System.out.print("\nEnter the number of word you want to add: ");
        newNumOfWords = Integer.parseInt(sc.next());
        if (newNumOfWords <= 0) {
          System.out.println("Please re-enter input!");
          checkInput = true;
        }
      } catch (Exception e) {
        System.out.println("Please re-enter input!");
        checkInput = true;
      }
    } while (checkInput);
    sc.nextLine();
    String target;
    String meaning;
    for (int i = 0; i < newNumOfWords; i++) {
      System.out.print("Enter English word: ");
      target = sc.nextLine();
      System.out.print("Enter meaning in Vietnamese: ");
      meaning = sc.nextLine();
      Word newWord = new Word(target, meaning);
      currWordArrayList.add(newWord);
    }
    dictionary.setWordArrayList(currWordArrayList);
    dictionary.setNumOfWords(newNumOfWords + oldNumOfWords);
  }

  public void insertFromFile() {
    // get data from .txt file
    // List lưu các dòng chứa key - value cách nhau bởi dấu tab
    int oldNumOfWords = dictionary.getNumOfWords();
    List<String> wordDataList = new ArrayList<>();
    try {
      File myFile = new File("E:\\College\\Nam2-Ky1\\OOP\\src\\com\\thanhson\\dictionaries.txt");
      Scanner myReader = new Scanner(myFile);
      while (myReader.hasNext()) {
        String data = myReader.nextLine();
        wordDataList.add(data);
        // System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occured!");
      e.printStackTrace();
    }
    // thêm phần tử mới trong file vào trong dictionary
    // System.out.println("wordDataList = " + wordDataList.size());
    for (String s : wordDataList) {
      String[] word;
      word = s.split("\t");
      Word newWord = new Word(word[0], word[1]);
      currWordArrayList.add(newWord);
    }
    // set lại dictionary sau khi được thêm
    dictionary.setWordArrayList(currWordArrayList);
    dictionary.setNumOfWords(wordDataList.size() + oldNumOfWords);
  }

  public void dictionaryLookup() {
    // function to find word
    // show all words if they match the input word you want to find
    System.out.print("Enter the word you want to search: ");
    String wordSearch = sc.nextLine();
    boolean checkAppear = false;
    for (Word word : currWordArrayList) {
      if (word.getWordExplain().equals(wordSearch) || word.getWordTarget().equals(wordSearch)) {
        checkAppear = true;
        break;
      }
    }
    if (!checkAppear) {
      System.out.println("Can't find the word you want to search!");
      return;
    }
    System.out.format("%-5s%-10s%-20s\n", "No", "English", "Vietnamese");
    for (int i = 0; i < currWordArrayList.size(); i++) {
      if (currWordArrayList.get(i).getWordExplain().equals(wordSearch)
          || currWordArrayList.get(i).getWordTarget().equals(wordSearch)) {
        System.out.format(
            "%-5d%-10s%-20s\n",
            i + 1,
            dictionary.getWordArrayList().get(i).getWordTarget(),
            dictionary.getWordArrayList().get(i).getWordExplain());
      }
    }
  }

  public void dictionarySeacher() {
    // function to find all words
    // show all words if they match a part of the input word you want to find
    System.out.print("Enter the word you want to search: ");
    String wordSearch = sc.nextLine();
    boolean checkAppear = false;
    for (Word word : currWordArrayList) {
      if (word.getWordExplain().contains(wordSearch) || word.getWordTarget().contains(wordSearch)) {
        checkAppear = true;
        break;
      }
    }
    if (!checkAppear) {
      System.out.println("Can't find the word you want to search!");
      return;
    }
    System.out.format("%-5s%-15s%-25s\n", "No", "English", "Vietnamese");
    for (int i = 0; i < currWordArrayList.size(); i++) {
      if (currWordArrayList.get(i).getWordExplain().contains(wordSearch)
          || currWordArrayList.get(i).getWordTarget().contains(wordSearch)) {
        System.out.format(
            "%-5d%-15s%-25s\n",
            i + 1,
            dictionary.getWordArrayList().get(i).getWordTarget(),
            dictionary.getWordArrayList().get(i).getWordExplain());
      }
    }
  }

  public void addWord() {
    int oldNumOfWords = dictionary.getNumOfWords();
    System.out.println("Enter the word-meaning you want to add to dictionary below!");
    String target;
    String meaning;
    System.out.print("Enter English word: ");
    target = sc.nextLine();
    System.out.print("Enter meaning in Vietnamese: ");
    meaning = sc.nextLine();
    Word newWord = new Word(target, meaning);
    currWordArrayList.add(newWord);
    dictionary.setWordArrayList(currWordArrayList);
    dictionary.setNumOfWords(oldNumOfWords + 1);
  }

  public void deleteWord() {
    int oldNumOfWords = dictionary.getNumOfWords();
    System.out.print("Enter the word you want to delete: ");
    String wordSearch = sc.nextLine();
    boolean checkAppear = false;
    for (Word word : currWordArrayList) {
      if (word.getWordExplain().equals(wordSearch) || word.getWordTarget().equals(wordSearch)) {
        checkAppear = true;
        break;
      }
    }
    if (!checkAppear) {
      System.out.println("Can't find the word you want to delete!");
      return;
    }
    int countDelete = 0;
    ArrayList<Word> delWordArray = new ArrayList<>();
    for (int i = 0; i < currWordArrayList.size(); i++) {
      if (currWordArrayList.get(i).getWordExplain().equals(wordSearch)
          || currWordArrayList.get(i).getWordTarget().equals(wordSearch)) {
        delWordArray.add(currWordArrayList.get(i));
        currWordArrayList.remove(i);
        countDelete++;
      }
    }
    System.out.println("List of words you deleted");
    for (Word word : delWordArray) {
      System.out.println(word.getWordTarget() + "-" + word.getWordExplain());
    }
    dictionary.setWordArrayList(currWordArrayList);
    dictionary.setNumOfWords(oldNumOfWords - countDelete);
  }

  public void changeWord() {
    System.out.print("Enter the word you want to change: ");
    String wordSearch = sc.nextLine();
    boolean checkAppear = false;
    for (Word word : currWordArrayList) {
      if (word.getWordExplain().equals(wordSearch) || word.getWordTarget().equals(wordSearch)) {
        checkAppear = true;
        break;
      }
    }
    if (!checkAppear) {
      System.out.println("Can't find the word you want to change!");
      return;
    }
    ArrayList<Word> changeWordArray = new ArrayList<>();
    for (Word value : currWordArrayList) {
      if (value.getWordExplain().equals(wordSearch)
          || value.getWordTarget().equals(wordSearch)) {
        changeWordArray.add(value);
        System.out.print("Enter English word: ");
        value.setWordTarget(sc.nextLine());
        System.out.print("Enther meaning in Vietnamese: ");
        value.setWordExplain(sc.nextLine());
      }
    }
    System.out.println("List of words you changed");
    for (Word word : changeWordArray) {
      System.out.println(word.getWordTarget() + "-" + word.getWordExplain());
    }
  }

  public void controlDictionary() {
    addWord();
    deleteWord();
    changeWord();
  }

  public void dictionaryExportToFile() {
    try {
      int numOfWords = dictionary.getNumOfWords();
      PrintWriter printWriter = new PrintWriter("out.txt");
      for (int i = 0; i < numOfWords; i++) {
        printWriter.printf(
            "%s\t%s\n",
            currWordArrayList.get(i).getWordTarget(), currWordArrayList.get(i).getWordExplain());
      }
      printWriter.close();
    } catch (IOException e) {
      System.out.println("An error occured!");
      e.printStackTrace();
    }
  }

  public Dictionary getDictionary() {
    return dictionary;
  }

  public static void main(String[] args) {
    DictionaryManagement manager = new DictionaryManagement();
    //DictionaryCommandLine.dictionaryBasic(manager);
    DictionaryCommandLine.dictionaryAdvanced(manager);
    DictionaryCommandLine.dictionaryController(manager);
  }
}
