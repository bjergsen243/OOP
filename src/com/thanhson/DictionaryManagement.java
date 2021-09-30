package com.thanhson;
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
        System.out.print("\nNhap so tu vung ban muon them vao tu dien: ");
        newNumOfWords = Integer.parseInt(sc.next());
        if (newNumOfWords <= 0){
          System.out.println("Vui long nhap lai dau vao");
          checkInput = true;
        }
      } catch (Exception e) {
        System.out.println("Vui long nhap lai dau vao");
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
      System.out.print("Nhap tu tieng Anh: ");
      target = sc.nextLine();
      System.out.print("Nhap nghia tieng Viet: ");
      meaning = sc.nextLine();
      Word newWord = new Word(target,meaning);
      newWordArray[oldNumOfWords + i] = newWord;
    }
    dictionary.setWordArray(newWordArray);
    dictionary.setNumOfWords(newNumOfWords + oldNumOfWords);
  }

  public void insertFromFile() {
    // get data from .txt file
  }

  public void dictionaryLookup() {
    // function to find word
  }
  public Dictionary getDictionary() {
    return dictionary;
  }

  public static void main(String[] args) {
    DictionaryManagement manager = new DictionaryManagement();
    DictionaryCommandLine.dictionaryBasic(manager);
    //DictionaryCommandLine.dictionaryBasic(manager);

  }
}
