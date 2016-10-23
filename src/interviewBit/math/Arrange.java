package interviewBit.math;
import java.util.ArrayList;

/**
 * Created by priyavivek on 10/19/15.
 *
 * Problem statement
 *
 *
 *
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

 Example:

 Input : [1, 0]
 Return : [0, 1]
 */
public class Arrange {


    public void arrange(ArrayList<Integer> a) {

        int N = a.size();

        for(int i=0;i<N;i++){
            a.set(i,a.get(i) + (a.get(a.get(i))%N)*N);
        }

        for(int i=0;i<N;i++){
            a.set(i,a.get(i)/N);
        }


    }




    public static void main(String[] args){
        Arrange m = new Arrange();
        ArrayList<Integer> ip = new ArrayList<Integer>();
        ip.add(4);
        ip.add(0);
        ip.add(2);
        ip.add(1);
        ip.add(3);

        m.arrange(ip);

        for(int i=0;i<ip.size();i++){

            System.out.println(ip.get(i));
        }

        int x = 5;
    }
}
