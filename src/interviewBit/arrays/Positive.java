package interviewBit.arrays;

import java.util.ArrayList;

/**
 * Created by priyavivek on 10/18/15.
 */
public class Positive {
    public int firstMissingPositive(ArrayList<Integer> a) {

        int temp;

       return -1;

        //int minVal=Integer.MAX_VALUE;
        //int maxVal = Integer.MIN_VALUE;

        //HashMap<Integer,Integer> integerCounts = new HashMap<Integer, Integer>();

       /* for(int i=0;i<a.size();i++){
            minVal = Math.min(minVal,a.get(i));
            maxVal = Math.max(maxVal,a.get(i));
            //integerCounts.put(a.get())
        }

        if(minVal>1 || maxVal<=0){
            return 1;
        }

        int missingVal = 1;

        for(int i=0;i<a.size();i++){
            if(!a.contains(missingVal)){
                return missingVal;
            }
            missingVal++;
        }*/

       /* for(int i =1;i<=maxVal;i++){
            if(!a.contains(i)){
                return i;
            }
        }*/

       // return maxVal+1;

        /*HashMap<Integer,Integer> integerCounts = new HashMap<Integer, Integer>(maxVal-minVal+1);

        for(int i=minVal;i<=maxVal;i++){
            integerCounts.put(i,0);
        }

        for(int i=0;i<a.size();i++){
            int currVal = a.get(i);
            integerCounts.put(currVal,integerCounts.get(currVal)+1);
        }

        if(!integerCounts.containsValue(0) && maxVal<=0){
            return 1;
        }else if(!integerCounts.containsValue(0) && maxVal>0) {
            return maxVal+1;
        }

        for(int i=minVal;i<=maxVal;i++){
            if(integerCounts.get(i) == 0 && i>0){
                return i;
            }

        }

        return -1;*/
    }

    public static void main(String[] args){
        Positive p = new Positive();
        ArrayList<Integer> ip = new ArrayList<Integer>();
        ip.add(-8);
        ip.add(-7);
        ip.add(-6);

        int result;

        //ArrayList<Integer> ip  = new ArrayList<Integer>(Arrays.asList(894, 669, 852, 722, 778, 169, 247, 927, 875, 858, 396, 760, 318, 409, 640, 976, 419, 600, 711, 610, 864, 655, 859, 567, 7, 487, 953, 632, 544, 158, 53, 919, 45, 699, 493, 414, 586, 460, 339, 540, 12, 948, 515, 16, 116, 772, 529, 606, 684, 214, 724, 811, 925, 703, 454, 592, 330, 143, 41, 401, 570, 326, 885, 943, 836, 252, 119, 773, 768, 447, 581, 237, 380, 182, 457, 868, 667, 109, 702, 692, 542, 517, 966, 583, 983, 273, 641, 691, 985, 115, 574, 216, 372, 298, 411, 784, 95, 251, 389, 354, 964, 430, 991, 799, 824, 826, 714, 238, 967, 977, 291, 545, 355, 287, 425, 305, 118, 902, 479, 388, 19, 61, 301, 782, 688, 893, 673, 195, 971, 693, 797, 996, 3, 314, 353, 103, 391, 905, 316, 734, 54, 939, 648, 526, 448, 255, 690, 114, 715, 148, 376, 878, 483, 408, 804, 585, 79, 644, 621, 221, 345));

        //System.out.println(ip.contains(1));
        result = p.firstMissingPositive(ip);
        System.out.println("First missing positive integer is " + result);
    }
}
