package barclays_test_07_2017_Task1;

//Barclays Developer (Java) July 2017 Test, Task 1
//To Copy & Paste

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String newLine = new String("");
      long counter = 0;
      for (int i = 0; i < line.length(); i++) {
        if (line.charAt(i) != ' ') {
          if ( (counter & 1) == 0) {
            newLine += Character.toUpperCase(line.charAt(i));    
          }
          else {
            newLine += Character.toLowerCase(line.charAt(i));
          }
          counter++;
        }
        else {
          newLine += line.charAt(i); 
        }
      }
      System.out.println(newLine);
    }
  }
}