package facebook;

/*
	Given an array of integers. 

	Move all non-zero elements to the left of all zero elements.
	
	Link: http://www.careercup.com/question?id=5668212962230272
*/
public class MoveZeroesToEnd {	
	public int[] moveZeroesToEnd(int[] input) {
		if(input == null || input.length == 0) {
			return input; //Talk to interviewer on what should be returned
		}
		
		int i = 0;
		int j = input.length-1;
		while(i<j){
			if(input[j] == 0){
				j--;
			} else if (input[i]!=0){
				i++;
			} else {
				int temp = input[j];
				input[j] = input[i];
				input[i] = temp;
				i++;
				j--;
			}
		}
		
		return input;
	}

    static void moveZeroesToEnd(int arr[], int n){
        int i = 0;
        for(int j = 0; j < n; ++j){
            if(arr[j] != 0){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
            }
        }
    }
}
