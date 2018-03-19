package barclays_java_test_July_2017;

//Barclays Developer (Java) July 2017 Test, Task 1
//To Copy & Paste

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Solution_Problem1 {
	
  /**
   * The goal of this problem is for already given code adjust it in a way that it sorts out the required result
   * The task itself is to change the input string into output sting when each characters is switched to Upper and Lower cases ignoring the spaces
   * input -> Hello World
   * output-> HeLlO wOrLd
   * The idea is to count the character skipping the spaces when meet
   * Idea 1: Probably BufferString for newLine will be better object to use and not String, but I accomplished it like this
   * Idea 2: Probably condition isChar will be better and not space detection condition
   * Code is ready to copy and paste
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
					if ( (counter & 1) == 0) { // Not classical Mod, no idea why I did so fast
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