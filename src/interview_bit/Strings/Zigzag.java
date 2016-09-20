package interview_bit.strings;

/**
 * Created by priyavivek on 11/1/15.
 *
 * Problem statement
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P.......A........H.......N
 ..A..P....L....S....I...I....G
 ....Y.........I........R
 And then read line by line: PAHNAPLSIIGYIR
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 **Example 2 : **
 ABCD, 2 can be written as

 A....C
 ...B....D
 and hence the answer would be ACBD.
 */
public class Zigzag {

    public enum Direction{
        UP,DOWN
    }

    public String convert(String a, int b) {
        StringBuilder cleanA = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==' '){
                break;
            }else{
                cleanA.append(a.charAt(i));
            }

        }

        if(cleanA.length() <=b || b==1){
            return cleanA.toString();
        }



       Direction mDIRECTION = Direction.DOWN;

       for(int i=0;i<b;i++){
           int j=i;

            //The first and last rows are special cases. They can be thought of as only going down or up
           if(i==0){
               mDIRECTION = Direction.DOWN;
           }

           if(i==b-1){
               mDIRECTION=Direction.UP;
           }

           while(j<cleanA.length()){
               result.append(cleanA.charAt(j));
               if(mDIRECTION == Direction.DOWN){
                   j = j + 2*(b-1-i);
                   //Dont change directions for first row
                   if(i!=0) {
                       mDIRECTION = Direction.UP;
                   }
               }else if(mDIRECTION == Direction.UP){
                   j = j + 2*i;
                   //Dont change directions for last row
                   if(i!=b-1) {
                       mDIRECTION = Direction.DOWN;
                   }
               }
           }

           //Reset direction to default - DOWN
           mDIRECTION = Direction.DOWN;

       }

        return result.toString();
    }

    public static void main(String[] args){

        Zigzag z = new Zigzag();
        String result = z.convert("PAYPALISHIRING",5);
        System.out.println(result);


    }

}
