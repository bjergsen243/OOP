package com.thanhson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement {
  Scanner sc = new Scanner(System.in);
  Dictionary dictionary = new Dictionary();

  public void insertFromCommandLine() {
    int newNumOfWords = 0;
    int oldNumOfWords = dictionary.getNumOfWords();
    Word[] currWordArray = dictionary.getWordArray();
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
    // System.out.println("N = " + newNumOfWords);
    Word[] newWordArray = new Word[oldNumOfWords + newNumOfWords];
    // copy lai array cu
    for (int i = 0; i < oldNumOfWords; i++) {
      newWordArray[i] = currWordArray[i];
    }
    String target;
    String meaning;
    for (int i = 0; i < newNumOfWords; i++) {
      System.out.print("Enter English word: ");
      target = sc.nextLine();
      System.out.print("Enter meaning in Vietnamese: ");
      meaning = sc.nextLine();
      Word newWord = new Word(target, meaning);
      newWordArray[oldNumOfWords + i] = newWord;
    }
    dictionary.setWordArray(newWordArray);
    dictionary.setNumOfWords(newNumOfWords + oldNumOfWords);
  }

  public void insertFromFile() {
    // get data from .txt file
    int newNumOfWords = 0;
    int oldNumOfWords = dictionary.getNumOfWords();
    Word[] currWordArray = dictionary.getWordArray();
    // List lưu các dòng chứa key - value cách nhau bởi dấu tab
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
    newNumOfWords = wordDataList.size();
    System.out.println("wordDataList = " + newNumOfWords);
    Word[] newWordArray = new Word[newNumOfWords + oldNumOfWords];
    // copy lại dictionary cũ đang có
    for (int i = 0; i < oldNumOfWords; i++) {
      newWordArray[i] = currWordArray[i];
    }
    for (int i = 0; i < wordDataList.size(); i++) {
      String[] word;
      word = wordDataList.get(i).split("\t");
      Word newWord = new Word(word[0], word[1]);
      newWordArray[oldNumOfWords + i] = newWord;
    }
    // set lại dictionary sau khi được thêm
    dictionary.setWordArray(newWordArray);
    dictionary.setNumOfWords(newNumOfWords + oldNumOfWords);
  }

  public void dictionaryLookup() {
    // function to find word
    // show all words if they match the input word you want to find
    System.out.print("Enter the word you want to search: ");
    String wordSearch = sc.nextLine();
    Word[] currWordArray = dictionary.getWordArray();
    System.out.format("%-5s%-10s%-20s\n", "No", "English", "Vietnamese");
    for (int i = 0; i < currWordArray.length; i++) {
      if (currWordArray[i].getWordExplain().equals(wordSearch)
          || currWordArray[i].getWordTarget().equals(wordSearch)) {
        System.out.format(
            "%-5d%-10s%-20s\n",
            i + 1,
            dictionary.getWordArray()[i].getWordTarget(),
            dictionary.getWordArray()[i].getWordExplain());
      }
    }
  }
  public void dictionarySeacher() {
    // function to find all words
    // show all words if they match a part of the input word you want to find
    System.out.print("Enter the word you want to search: ");
    String wordSearch = sc.nextLine();
    Word[] currWordArray = dictionary.getWordArray();
    System.out.format("%-5s%-15s%-25s\n", "No", "English", "Vietnamese");
    for (int i = 0; i < currWordArray.length; i++) {
      if (currWordArray[i].getWordExplain().contains(wordSearch)
          || currWordArray[i].getWordTarget().contains(wordSearch)) {
        System.out.format(
            "%-5d%-15s%-25s\n",
            i + 1,
            dictionary.getWordArray()[i].getWordTarget(),
            dictionary.getWordArray()[i].getWordExplain());
      }
    }
  }

  public Dictionary getDictionary() {
    return dictionary;
  }

  public static void main(String[] args) {
    DictionaryManagement manager = new DictionaryManagement();
    DictionaryCommandLine.dictionaryBasic(manager);
    DictionaryCommandLine.dictionaryMoreAdvanced(manager);
  }
}
