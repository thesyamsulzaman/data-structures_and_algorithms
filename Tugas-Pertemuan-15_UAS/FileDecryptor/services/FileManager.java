package services;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.StringBuilder;

public class FileManager {
  public static void main(String[] args) {
    System.out.println("Hello from Encryptor");
  }

  public static String read(String fileDir) throws Exception {
    StringBuilder content = new StringBuilder();
    FileReader fr = new FileReader(fileDir);    

    int i;    
    while( (i=fr.read()) != -1 ) {
      content.append((char) i);
    }
    fr.close();   

    return content.toString().trim();
  }

  public static void write(String fileDir, String content) {
    try {    
      FileWriter fw = new FileWriter(fileDir);    
      fw.write(content);    
      fw.close();    
    } catch(Exception e){
      System.out.println(e);
      System.out.println("Success...");    
    }    

  }

  public static String isHere() {
    return "This is FileReader";
  }

}
