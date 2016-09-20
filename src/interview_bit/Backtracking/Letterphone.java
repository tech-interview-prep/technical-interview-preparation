package interview_bit.backtracking;

import java.util.*;

/**
 * Created by priyavivek on 11/8/15.
 *
 * Problem statement
 *
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters is just like that on the telephone buttons.

 The digit 0 maps to 0 itself.
 The digit 1 maps to 1 itself.

 Input: Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Make sure the returned strings are lexicographically sorted.
 */
public class Letterphone {
    HashMap<Character,String> mapping = new HashMap<Character,String>();
    ArrayList<String> result = new ArrayList<String>();

    //Create a dictionary of mappings
    Letterphone(){
        mapping.put('1',"1");
        mapping.put('2',"abc");
        mapping.put('3',"def");
        mapping.put('4',"ghi");
        mapping.put('5',"jkl");
        mapping.put('6',"mno");
        mapping.put('7',"pqrs");
        mapping.put('8',"tuv");
        mapping.put('9', "wxyz");
        mapping.put('0', "0");


    }

    public ArrayList<String> letterCombinations(String a) {
        getCombos(a, "");
        return result;


    }

    public void getCombos(String a, String prev) {

        String mapVal = mapping.get(a.charAt(0));

        //Add strings to an array list
        if(a.length() == 1){
            for(int i=0;i<mapVal.length();i++){
                result.add(prev + mapVal.charAt(i));
            }

            return;


        }else {
            //Recursively iterate on a subset of the input string, adding a character at time
            for (int i = 0; i < mapVal.length(); i++) {
                getCombos(a.substring(1, a.length()), prev + mapVal.charAt(i));
            }
        }


    }

    public static void main(String[] args){

        Letterphone lp = new Letterphone();
        ArrayList<String> result = new ArrayList<String>();
        result = lp.letterCombinations("84835");


    }


}
