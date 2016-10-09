public class FindNegNumMatrix {
	public static void main(String[] args){
		int[][] arr = { 
			{-3,-2,-1,1}, 
			{-2,2,3,4}, 
			{4,5,7,8}
		};
		System.out.println(findNeg(arr));

	}
	public static int findNeg(int[][] arr){
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length;j++){
				if(arr[i][j] < 0){
					count += 1;
				}

			}
		}
		return count;
	}
}