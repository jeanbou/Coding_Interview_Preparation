package barclays_java_test_July_2017;

// Barclays Developer (Java) July 2017 Test, Task 2
// Credits:  https://gist.github.com/vikashvverma/4650142


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Solution_Problem2 {

   /**
   * The goal of this tast is to check the balance of brackets:
   * For example {()} is OK, but {(}) not OK
   * Among available solution in Google found the good one from vikashvverma for 3 type of brackets , but I quickly adapted
   * to the given specificity of this problem of 2 brackets problem
   */

  public static void main(String[] args) throws IOException {
	  InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	  BufferedReader in = new BufferedReader(reader);
	  String line;
	  while ((line = in.readLine()) != null) {
		  System.out.println(printResult(line));
	  }
  }
  
  private static String printResult(String string) {
        
	  String s = string.replaceAll( "[^:\\(\\)]", "" );

      for (int i = 0; i < s.length() / 2; i++) {
    	  String lead = "";
          String trail = "";
          if (s.charAt(i) == '(' && s.charAt(s.length() - i - 1) == ')') {
        	  if (i > 0) {
        		  lead = s.substring(0, i);
                  trail = s.substring(s.length() - i, s.length());
              }
              s = lead + s.substring(i + 1, s.length() - i - 1) + trail;
              --i;
          }
      }
      
      s = s.replaceAll( ":\\(", "" );
      s = s.replaceAll( ":\\)", "" );

      for (int i = 0; i < s.length(); i++) {
    	  if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                return "NO";
          }
      }

      return "YES";
}
  
  
}
