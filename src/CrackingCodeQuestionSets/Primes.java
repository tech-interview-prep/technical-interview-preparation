import java.io.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Primes {
  
  public static ArrayList<Integer> upTo(int num){
    if(num < 0) return new ArrayList<Integer>();
    
    ArrayList<Integer>arr = new ArrayList<Integer>();
    
    for(int i = 2; i <= num; ++i){
      boolean c = isPrime(i);
      if(c == true){
        arr.add(i);
      }         
    }
    return arr;
    
  }
  
  //helper function to check to see if its prime
  public static boolean isPrime(int num){
    // TODO 1 and itself
    if(num < 2 ) return false;
      
    for(int i = 2; i < num; ++i){
      if(num % i == 0){
        return false;
      }
    }
    return true;
  }
    
}


class Solution {

  @Test
  public static void assertArrayListEquals(ArrayList<Integer> actual, ArrayList<Integer> expected) {
    if(expected.equals(actual)){
      System.out.println("PASS!");
    } else {
      System.out.println("Expected: " + expected);
      System.out.println("Actual: " + actual);

    }
  }

  public static void main(String[] args) {
    //System.out.println(Primes.upTo(2));
     
    //assertArrayListEquals(Primes.upTo(-1), new ArrayList<Integer>());
    
    ArrayList<Integer>arr = new ArrayList<Integer>();
    arr.add(2);
    arr.add(3);
    arr.add(5);
    assertArrayListEquals(Primes.upTo(5),arr);

      
  }
}
