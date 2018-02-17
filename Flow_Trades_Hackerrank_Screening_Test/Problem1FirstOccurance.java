package flow_trades;

public class Problem1FirstOccurance {

	public static void main(String[] args) {
		String s = "We had had a Mr. Had his Hat-enought	data ";
		System.out.println(firstOccurance(s));
	}
	
	public static String firstOccurance(String s) {
		String[] splited = s.split(" |	|:|;|,|-|\\.");
		for (int i = 0; i < splited.length; i++) {
			for (int j = i+1; j < splited.length; j++) {
				if ( splited[i].equals(splited[j]) )
					return splited[i];
			}			
		}		
		return null;
	}
}
