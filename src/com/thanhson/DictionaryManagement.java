package com.thanhson;
import java.util.Scanner;
public class DictionaryManagement{
  private final Dictionary dictionary = new Dictionary();

  public void insertFromCommandLine(){
    Scanner sc = new Scanner(System.in);
    int n = 0;
    boolean checkInput = true;
    do{
      try{
        checkInput = false;
        System.out.print("\nNhap so tu vung ban muon them vao tu dien: ");
        n = Integer.parseInt(sc.next());
        if (n <= 0){
          System.out.println("Vui long nhap lai dau vao");
          checkInput = true;
        }
      } catch (Exception e) {
        System.out.println("Vui long nhap lai dau vao");
        checkInput = true;
      }
    } while (checkInput);
    System.out.println("N = " + n);
    for (int i = 0; i < n; i++){
      System.out.print("\nNhap tu tieng Anh: ");
      dictionary.setWords(setWord_target(sc.nextLine()));
      System.out.print("\nNhap nghia tieng Viet: ");

    }
  }
}
