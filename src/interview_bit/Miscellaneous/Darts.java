package interview_bit.miscellaneous;
import java.util.*;
/**
 * Created by priyavivek on 11/16/15.
 *
 * Son of darts - Problem statement
 *
 * Suppose that you have a dartboard that is divided into R regions. Each dartboard region has a positive integer value associated with it. Further suppose that you have D darts and that you throw each of them at the dartboard. Each dart either lands in one of the board's R regions or misses the board altogether. Your score is the sum of the values for the regions in which the darts land. A dart that misses the board contributes nothing to your score. If multiple darts land in the same region, you accumulate the value for that region multiple times.

 For example, suppose that R = 5, that the dartboard regions have values (1, 2, 4, 7, 11), and that D = 3. If your three darts land in regions 2, 4 and 11 you score 17 points. If one dart misses the board and the other two land in region 7 you score 14 points.

 The Darts Problem is this: for a given R and D, determine what values should be associated with a dartboard's R regions in order to maximize the smallest score unattainable by throwing D darts.

 For example, again suppose that R = 5 and D = 3. If you choose the values (1, 2, 4, 7, 11) for the board's 5 regions, then the smallest score unattainable with your 3 darts is 27. But if you choose the values (1, 4, 6, 14, 15) the smallest unattainable score is 37. The second choice of values is therefore a better choice for 3 darts and 5 regions.

 Write a program that, given the values of the regions and number of darts, outputs the smallest value that can not be obtained.
 */
public class Darts {
    public static void main (String[] args) throws java.lang.Exception
    {
        test( score("1 2 3", "2") , 7 );
        test(score("1 2 4 7 11", "3") , 27);
        test(score("1 4 6 14 15", "3") , 37);
    }

    private static int score(String values, String darts){
        //return 7;
        ArrayList<Integer> sums = new ArrayList<Integer>();
        String[] regions = values.split(" ");

        ArrayList<Integer> regionVals = new ArrayList();
        regionVals.add(0);

        for(int i=0;i<regions.length;i++){

            regionVals.add(Integer.parseInt(regions[i]));

        }

        int numDarts = Integer.parseInt(darts);
        sums = calculateSums(sums,regionVals,numDarts,0);
        return calMinImpos(sums);




    }
    public static int calMinImpos(ArrayList<Integer> sums){
        Set<Integer> uniqueSums = new HashSet<Integer>();
        uniqueSums.addAll(sums);
        sums.clear();
        sums.addAll(uniqueSums);
        Collections.sort(sums);
        int result = -1;
        for(int i=1;i<sums.size();i++){
            if(sums.get(i)-sums.get(i-1) > 1){
                result = i;
                break;
            }

        }

        if(result == -1){
            result = sums.get(sums.size()-1) + 1;
        }

        return result;


    }

    public static ArrayList<Integer> calculateSums(ArrayList<Integer>sums,ArrayList<Integer> regionVals,int numDarts,int currSum){
        if(numDarts == 0){
            sums.add(currSum);
            return sums;
        }

        for(int i=0;i<regionVals.size();i++){

            sums = calculateSums(sums,regionVals,numDarts-1,currSum + regionVals.get(i));
        }

        return sums;
    }



    private static void test( int score, int expected )
            throws Exception
    {
        if( score != expected )
        {
            throw new Exception( "Incorrect Answer." + score );
        }
        else
        {
            System.out.println("Score: " + score + ", Expected: " + expected);
        }
    }



}
