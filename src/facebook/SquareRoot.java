package facebook;

/* 	
	Babylonian method for square root
	
	Algorithm:
	This method can be derived from (but predates) Newton–Raphson method.
	
	
	1 Start with an arbitrary positive start value x (the closer to the 
	   root, the better).
	2 Initialize y = 1.
	3. Do following until desired approximation is achieved.
	  a) Get the next approximation for root using average of x and y
	  b) Set y = n/x
	
	Link: http://www.geeksforgeeks.org/square-root-of-a-perfect-square/

*/	
public class SquareRoot {
	/*Returns the square root of n. Note that the function */
	double squareRoot(double n) {
	  /*We are using n itself as initial approximation
	   This can definitely be improved */
		double x = n;
		double y = 1;
		double e = 0.000001; /* e decides the accuracy level*/
		while(x - y > e) {
		    x = (x + y)/2;
		    y = n/x;
		}
		
		return x;
	}

    // https://gist.github.com/zac-xin/4353800
    public int sqrt(int x) {
        long low = 0;
        long high = x;
        while(low <= high){
            long mid = low + (high - low) / 2;
            long result = mid * mid;
            if(result == x){
                return (int)mid;
            } else if(result > x){
                high = mid - 1;
            } else{

                low = mid + 1;
            }
        }
        return (int)high;
    }
}
