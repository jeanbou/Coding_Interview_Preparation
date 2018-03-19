package anaplan_testing_March_2018;

public class CupCakeFeast {
	
	// https://github.com/havelessbemore/hackerrank/blob/master/algorithms/implementation/chocolate-feast.java
	// O(n) complexity

	static void maximumCupcakes(String[] trips) {
        StringBuffer result = new StringBuffer();
        for (String str : trips) { // read line by line
            String[] line = str.split(" ");
            int N = Integer.parseInt(line[0]);
            int C = Integer.parseInt(line[1]);
            int M = Integer.parseInt(line[2]);
            int total = N/C;
            int wrappers = total;
            while (wrappers >= M){
                int free = wrappers/M;
                total += free;
                wrappers = free + wrappers%M;
            }
            result.append(total + "\n");
        }
        
        System.out.print(result.toString());
    }	

}
