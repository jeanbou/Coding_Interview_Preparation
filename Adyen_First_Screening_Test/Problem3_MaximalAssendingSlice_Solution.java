package adyen_testing_March_2018;

// Codility

// Credits (Description and Solution) https://discuss.leetcode.com/topic/101384/maximal-ascending-slice/3


class Problem3_MaximalAssendingSlice_Solution {
	
    public int solution(int[] A) {
        
        int N = A.length;
        
        // Added just a check
        if (N < 1 || N > 150000 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input array size is "+Integer.toString(N)+" !\nOut of specified range");
		}
		
	    if ( N == 1) {
	    	return 0;
	    }
	    
	    // init and work
        int maxSliceStart = 0;
        int maxSliceLength = 1;

        int currentSliceStart = 0;

        for (int i = 1; i < N; i++)
        {
            if (A[i - 1] >= A[i]) {
                currentSliceStart = i;
            }
            
            if (i - currentSliceStart + 1 > maxSliceLength)
            {
                maxSliceStart = currentSliceStart;
                maxSliceLength = i - currentSliceStart + 1;
            }
        }
        
        return maxSliceStart;
    }    
    
}