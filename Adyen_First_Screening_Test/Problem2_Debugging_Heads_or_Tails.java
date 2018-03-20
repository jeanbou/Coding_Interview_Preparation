package adyen_testing_March_2018;

// Codility

// The goal: analyze solutionHnTToCorrect provided (it is state that it does not work properly however for the given test it's OK
// Please use only 3 possible line changes correct the code (3 and not more then that!)


public class Problem2_Debugging_Heads_or_Tails {
	

	public static int solutionHnTToCorrect(int[] A) {
	    
		int N = A.length;
	    
		int result = 0;
	    
		for (int i = 0; i < N - 1; i++) {
			
	        if (A[i] == A[i + 1]) {
	            result++;
	        }	        
	    }
		
	    int r = 0;
	    
	    for (int i = 0; i < N; i++) {
	    	
	        int count = 0;
	        if (i > 0) {
	            if (A[i - 1] != A[i]) {
	                count++;
	            }
	            else {
	                count--;
	            }
	        }
	        /*// My correction 1
	        if (i < N - 1) {
	            if (A[i + 1] != A[i]) {
	                count++;
	            }
	            else {
	                count--;
	            }
	        } */ // My correction 2
	        
	        //r = Math.max(r, count);
	        r = Math.max(r, 2*count); // My correction 3 I AM NOT SURE THAT IT IS A RIGHT SOLUTION (time pressure you know)
	    
	    } // end of for
	    
	    return (result + r);
	}
	
	// Optimal solution, but it's too many line to correct
	// Credits: https://stackoverflow.com/questions/41945472/debug-the-given-code-for-coin-sequence
	//          https://github.com/rvitale/exercises/blob/master/src/core/exercises/arrays/CoinFlip.java
	//			http://ruslanledesma.com/2016/02/14/adjacent-coins.html
	public static int solutionHandT2(int[] A) {
		
		int N = A.length;
	    int count = 0;
	    boolean found = false;
	 
	    for(int i = 0; i < N-1; i++) {
	        if (A[i] == A[i+1]) {
	            //System.out.println(A[i] + " " + A[i+1]);
	            count++;
	        }
	        else if (((i + 2) <  N-1) && !found) {
	            if ((A[i] == 0 && A[i+1] == 1 && A[i+2] == 0) || (A[i] == 1 && A[i+1] == 0 && A[i+2] == 1)) {
	                found = true;
	                count = count + 2;
	            }
	            else if ((A[i] == 1 && A[i+1] == 0 && A[i+2] == 0) || (A[i] == 0 && A[i+1] == 1 && A[i+2] == 1)) {
	                found = true;
	                count = count + 1;
	            }
	        }
	    }
	 
	    return count;
	}
	
	
	
	public static void main(String[] args) {
		
		int[] A = new int[8];
		
		// To test
		A[0] = 1 ; A[1] = 1 ; A[2] = 0 ; A[3] = 1 ; A[4] = 0 ; A[5] = 0; // Expected  4
		
		A[0] = 1; A[1] = 1; A[2] = 0; A[3] = 1; A[4] = 0; A[5] = 0; A[6] = 1; A[7] = 1; // Expected 5
		
		System.out.println(solutionHnTToCorrect(A));
		System.out.println(solutionHandT2(A));

	}

}
