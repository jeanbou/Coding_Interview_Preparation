package flow_trades;

public class ProblemTwoPointsAnd2DTriangle {
		
	public static void main(String[] args) {
		System.out.println("Value for right triangle : " + belonging(0,0,0,20,30,0,1,1,3,3));
	}

	static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
		return Math.abs((x1*(y2-y3) + x2*(y3-y1)+x3*(y1-y2))/2.0);
	}

	static boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
		double A = area (x1, y1, x2, y2, x3, y3);

		double A1 = area (x, y, x2, y2, x3, y3);

		double A2 = area (x1, y1, x, y, x3, y3);

		double A3 = area (x1, y1, x2, y2, x, y);

		return (A == A1 + A2 + A3);
	}
	
	/** This is the method that you need to submit,
	 *  It returns required integer value that corresponds to requirement of
	 *  Triangle with coordinates x1,y1,x2,y2,x3,y3 and Two Points (xp,yp) and (xq,yq)
	 *  signature of the method is correct
	 *  NB: I do not remember exactly the whole condition, so don't take it as a copy & paste,
	 *  but the principal structure of code is this one, please experiment with it and here we are it
	 *  allow you to pass the test, please suggest perfect solution (if you have a time)  */
	
	static int belonging(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp, int xq, int yq) {
		if ( area(x1, y1, x2, y2, x3, y3) == 0 ) {
			return 0;
		}
		else if ( !isInside(x1, y1, x2, y2, x3, y3, xp, yp) && !isInside(x1, y1, x2, y2, x3, y3, xq, yq) ) {
			return 1;
		}
		else if ( !isInside(x1, y1, x2, y2, x3, y3, xp, yp) && isInside(x1, y1, x2, y2, x3, y3, xq, yq) ) {
			return 2;
		}
		else if ( isInside(x1, y1, x2, y2, x3, y3, xp, yp) && !isInside(x1, y1, x2, y2, x3, y3, xq, yq) ) {
			return 3;
		}
		else if ( isInside(x1, y1, x2, y2, x3, y3, xp, yp) && isInside(x1, y1, x2, y2, x3, y3, xq, yq) ) {
			return 4;
		}
		return 0;		
	}

}