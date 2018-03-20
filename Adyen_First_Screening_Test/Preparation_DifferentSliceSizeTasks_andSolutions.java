package adyen_testing_March_2018;

public class Preparation_DifferentSliceSizeTasks_andSolutions {
	
	// CREDITS:
	/*
	 
	 https://app.codility.com/demo/results/demo65RNV5-T36/
	https://stackoverflow.com/questions/21635397/min-average-two-slice-codility
	https://github.com/jlhuang/codility-lessons/blob/master/lesson%207%20:%20Maximum%20slice%20problem/MaxDoubleSliceSum/Solution.java

	Max Slize Sum https://rafal.io/posts/codility-max-slice-sum.html

	Max Double Slise Sum https://rafal.io/posts/codility-max-double-slice-sum.html
	https://stackoverflow.com/questions/20660989/max-double-slice-sum
	https://codesolutiony.wordpress.com/2015/01/05/codility-7-1-max-double-slice-sum/
	In C: https://github.com/TomaszGolan/codility/blob/master/Lesson%2009/MaxDoubleSliceSum.cxx
	https://github.com/vuamitom/Code-Exercises/blob/master/codility/MaxDoubleSlice.java

	Min Average SLise Sum https://www.martinkysel.com/codility-minavgtwoslice-solution/
	https://codesays.com/2014/solution-to-min-avg-two-slice-by-codility/ (Python)

	Max alternance 
	https://discuss.leetcode.com/topic/198/maximum-alternating-slice-size/12

	MIN Average Slice https://stackoverflow.com/questions/21635397/min-average-two-slice-codility

	Counting Bounding https://stackoverflow.com/questions/21251707/counting-bounded-slice-codility
	  
	*/
	
	
	public static int solutionMaxDoubleSliceSum2(int[] A) {
		
		int N = A.length;
        
        if (N == 3) {
            return 0;
        }
        
        if (N < 3 || N > 100000 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input array size is "+Integer.toString(N)+" !\nOut of specified range");
		} 
		
        int currentSliceTotal=0; 
        Integer currentMin = null;        		
        Integer SliceTotalBeforeMin =0;
        
        int maxSliceTotal= Integer.MIN_VALUE;
        
        for(int i= 1; i < N-1; i++){
            if( currentMin==null || A[i] < currentMin ){
                if ( currentMin!=null ) {
                    if(SliceTotalBeforeMin+currentMin <0) {
                        currentSliceTotal -= SliceTotalBeforeMin;
                    }
                    else {
                        currentSliceTotal += currentMin;
                    }
                }
                
                currentMin = A[i];
                SliceTotalBeforeMin = currentSliceTotal;

                if( SliceTotalBeforeMin < 0 ) {
                    SliceTotalBeforeMin = 0;
                    currentMin = null;
                    currentSliceTotal = 0;
                }
            }
            else {
                currentSliceTotal+= A[i];
            }

            maxSliceTotal = Math.max(maxSliceTotal, currentSliceTotal);
        }

        return maxSliceTotal;
    }
	
	public static int solutionMaxDoubleSliceSum(int[] A) {
		
        int N = A.length;
        
        if (N == 3) {
            return 0;
        }
        
        if (N < 3 || N > 100000 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input array size is "+Integer.toString(N)+" !\nOut of specified range");
		} 
        
        int maxEnding = 0;
        
        int[] maxSliceLeft = new int[N];
        
        for (int i = 1; i < N-1 ; i++) {
            
        	maxEnding = Math.max(0, maxEnding + A[i]);
            
        	maxSliceLeft[i] = maxEnding;
        }
        
        int[] maxSliceRight = new int[N];
        
        // re init
        maxEnding = 0;
        
        for (int i = N-2; i >= 1; i--) {
            maxEnding = Math.max(0, maxEnding + A[i]);
            maxSliceRight[i] = maxEnding;
        }
        
        int maxDoubleSlice = 0;
        
        for (int i = 1; i < N-1; i++) {
            maxDoubleSlice = Math.max(maxDoubleSlice, maxSliceLeft[i-1] + maxSliceRight[i+1]);
        }
        
        return maxDoubleSlice;
    }
	
	public static int solutionMaxSliceSum(int[] A) {
	    int maxEndingHere = A[0];
	    int maxSoFar = A[0];
	    for(int i = 1; i < A.length; i++){
	        maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
	        maxSoFar = Math.max(maxSoFar, maxEndingHere);
	    }
	    return maxSoFar;
	}
	
	public static int solutionUnefficent(int[] A) {
	    int result = 0;
	    int N = A.length;
	    int [] prefix = new int [N+1];
	    for (int i = 1; i < prefix.length; i++) {
	        prefix[i] = prefix[i-1] + A[i-1];
	    }
	    double avg = Double.MAX_VALUE;
	    for (int i = 1; i < N; i++) {
	        for (int j = i+1; j <=N; j++) {
	            double temp = (double)(prefix[j]-prefix[i-1]) /(double)(j-i+1);
	            if (temp < avg) {
	                avg = temp;
	                result = i-1;
	            }
	        }
	    }
	    return result;
	}
	
	public static int solution(int[] A) {
		
		int N = A.length;
		
		if (N < 2 || N > 100000 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input array size is "+Integer.toString(N)+" !\nOut of specified range");
		}
		
	    if ( N == 2) {
	    	return 0;
	    }

	    int minSliceTwo = A[0] + A[1];
	    int minTwoIndex = 0;

	    int minSliceThree = Integer.MAX_VALUE;
	    int minThreeIndex = 0;

	    for (int i = 2; i < N; i++) {
	        int sliceTwo = A[i - 1] + A[i];
	        if (sliceTwo < minSliceTwo) {
	            minSliceTwo = sliceTwo;
	            minTwoIndex = i - 1;
	        }

	        int sliceThree = sliceTwo + A[i - 2];
	        if (sliceThree < minSliceThree) {
	            minSliceThree = sliceThree;
	            minThreeIndex = i - 2;
	        }
	    }
	    
	    int averageMinTwo = minSliceTwo*3;
	    int averageMinThree = minSliceThree*2;

	    if (averageMinTwo == averageMinThree) {
	    	return Math.min(minTwoIndex, minThreeIndex);
	    }
	    else {
	    	return averageMinTwo < averageMinThree ? minTwoIndex : minThreeIndex;
	    }
	    
	}
	
	public static int solutionPrefixSum(int[] A) {
        int len = A.length, result = len - 1, sum = 0;
        int[] prefixSums = new int[len + 1];

        for (int i = 1; i <= len; ++i) {
            prefixSums[i] = prefixSums[i-1] + A[i-1];
        }

        double min = Double.MAX_VALUE, average = 0d;

        for (int P = 0, Q = 1; Q + 1 < prefixSums.length; ++P, ++Q ) {
            sum = prefixSums[Q + 1] - prefixSums[P];
            average = (sum)/(double) 2;

            if (average < min) {
                min = average;
                result = P;
            }

            if ( Q + 2 < prefixSums.length ) {
                sum = prefixSums[Q + 2] - prefixSums[P];
                average = (sum)/(double) 3;

                if (average < min) {
                    min = average;
                    result = P;
                }
            }

        }

        return result;
    }
	
	public static void main(String[] args) {
		int[] A = new int[5];
		
		@SuppressWarnings("unused")
		int[] B = new int[1];
		// Used for tests
		/*
		A[0] = 4;		
		A[1] = 2;
		A[2] = 2;
		A[3] = 5;
		A[4] = 1;
		A[5] = 5;
		A[6] = 8;
		*/
		//A[0] = 10; A[1] = 0; A[2] = 8; A[3] = 2; A[4] = -1; A[5] = 12; A[6] = 11; A[7] = 3;
		
		A[0] = 3;  A[1] = 2;  A[2] = -6; A[3] = 4;   A[4] = 0; // MaxSliceSum is expected 5
		//A[0] = 3;  A[1] = 2;  A[2] = 6; A[3] = -1;   A[4] = 4;  A[5] = 5;  A[6] = -1; A[7] = 2; // DoubleSliceSum is expected 17
			    
		
		//System.out.println(solution(A));
		System.out.println(solution(A));
		System.out.println(solutionPrefixSum(A));
		System.out.println(solutionUnefficent(A));
		
		System.out.println(solutionMaxDoubleSliceSum(A));
		System.out.println(solutionMaxDoubleSliceSum2(A));
		
		System.out.println(solutionMaxSliceSum(A));

	}

}
