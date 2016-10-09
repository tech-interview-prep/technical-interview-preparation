import java.io.*;
import java.util.*;

//Multiples of 3 and 5
class Problem1 {
	public static int sum(int num){
		int sum = 0;
		for(int i = 0; i < num; ++i){
			if(i % 3 == 0 || i % 5 == 0){
				sum += i;
			}
		}
		return sum;
	}
	public static void main(String[] args){
		System.out.println(Problem1.sum(10));
		System.out.println(sum(1000));

	}
}
