package interviewBit.trees;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by priyavivek on 11/22/15.
 *
 * Problem statement
 *
 * You are given the following :

 A positive number N
 Heights : A list of heights of N persons standing in a queue
 Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
 You need to return list of actual order of persons's height

 Consider that heights will be unique

 Example

 Input :
 Heights: 5 3 2 6 1 4
 InFronts: 0 1 2 0 3 2
 Output :
 actual order is: 5 3 2 1 6 4
 So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

 For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

 You can do similar inference for other people in the list.
 */
public class Order {
    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {

        //Sort the heights and rearrange the infronts lists to correspond the sorted heights
        HashMap<Integer,Integer> inFrontMappings = new HashMap<>();
        for(int i=0;i<heights.size();i++){
            inFrontMappings.put(heights.get(i),infronts.get(i));
        }

        Collections.sort(heights);
        ArrayList<Integer> newInFronts = new ArrayList<>();

        for(int i=0;i<heights.size();i++){
            newInFronts.add(0);
        }

        for(Map.Entry<Integer,Integer> entry:inFrontMappings.entrySet()){
            int height = entry.getKey();
            int inFront = inFrontMappings.get(height);
            for(int i=0;i<heights.size();i++){
                if(heights.get(i) == height){
                    newInFronts.set(i, inFront);
                    break;
                }
            }
        }

        ArrayList<Integer> orderResults = new ArrayList<>();

        for(int i=0;i<heights.size();i++){
            orderResults.add(0);
        }

        //Find the position of the shortest person, then the next shortest person and so on
        //For instance for any person, lets say the infronts value is 4, then look for the
        //5th position (0-based indexing) in all the empty slots in the final queue.
        //Empty slots are indicated by a value of 0 in the orderResults list

        for(int i=0;i<heights.size();i++){
            int ind = newInFronts.get(i);

            ind = insertInd(ind,orderResults);

            orderResults.set(ind,heights.get(i));

        }

        return orderResults;



    }

    public int insertInd(int inFrontVal,ArrayList<Integer> orderResults){
        int i = 0;
        int emptyCount = 0;
        while(i < orderResults.size()){
            if(orderResults.get(i) == 0){
                emptyCount++;
            }

            if(emptyCount-1 == inFrontVal){
                break;
            }
            i++;

        }

        return i;
    }



    public static void main(String[] args) throws Exception{
        Order o = new Order();
        ArrayList<Integer> heights = new ArrayList<Integer>(Arrays.asList(29,82,30,62,23,67,35));
        ArrayList<Integer> infront = new ArrayList<Integer>(Arrays.asList(5,0,2,0,3,1,1));
        ArrayList<Integer> result = new ArrayList<>();

        result = o.order(heights,infront);


        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(62,35,30,23,82,67,29));
        if(!result.equals(expected)){
            throw new Exception("Incorrect output");
        }

    }
}
