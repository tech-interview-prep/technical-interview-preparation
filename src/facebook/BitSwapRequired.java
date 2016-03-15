package facebook;

public class BitSwapRequired {
    /*
        Write a function to determine the number of bits required to convert integer A
        to integer B.
        Input: 31, 14
        Output: 2

        Link: https://gist.github.com/zac-xin/2699933

    */
    // use XOR '^'  1^1 = 0  1^0= 1 0^0 = 0
    public static int bitSwapRequired(int a, int b){
        int count = 0;
        for(int c = a ^ b; c > 0; c >>= 1)
            count += c & 1;
        return count;
    }

    /*
        Given an integer, print the next smallest and next largest number that have the
        same number of 1 bits in their binary representation.

        Link: https://gist.github.com/zac-xin/2699835

    */

    public static int setBit(int number, int index, boolean flag){
        if(flag){
            number = number | (1 << index);
        }else{
            int mask = 1 << index;
            mask = ~mask;
            number = number & mask;
        }
        return number;
    }

    public static boolean getBit(int number, int index){
        return ((number & (1 << index)) > 0);
    }

    public static int getNext(int number){
        if(number <= 0)
            return -1;

        int index = 0;
        int countOnes = 0;

        //find the first one
        while(!getBit(number, index))
            index++;
        //find the next 0
        while(getBit(number, index)){
            countOnes++;
            index++;
        }
        // now index point to the first zero after 1s

        /*
         * the reason that we need to find a 0 after we find 1
         * is that in this way the flip will make the number bigger.
         * we need to make sure the 0's position weights more than 1's position
         */

        //flip the zero
        number = setBit(number, index, true);
        index--;
        //flip the previous 1
        number = setBit(number, index, false);

        //make the 1s as right as possible
        countOnes--;
        for(int i = 0; i < countOnes; i++)
            number = setBit(number, i, true);
        // set 0s
        for(int i = countOnes; i < index; i++)
            number = setBit(number, i, false);

        return number;
    }

    public static int getPrevious(int number){
        if(number <= 0)
            return -1;

        //for n = 1111111111..., there does not exist a previous number
        if((number & (number + 1)) == 0)
            return -1;

        int index = 0;
        int countZeros = 0;

        //get the first 0
        while(getBit(number, index))
            index++;

        //get the next 1
        while(!getBit(number, index)){
            index++;
            countZeros++;
        }

        number = setBit(number, index, false);
        index--;
        number = setBit(number, index, true);

        countZeros--;
        for(int i = 0; i < countZeros; i++)
            number = setBit(number, i, false);

        for(int i = countZeros; i < index; i++)
            number = setBit(number, i, true);

        return number;
    }

    /*
        Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary
        representation. If the number can not be represented accurately in binary, print “ERROR”

        Link: https://gist.github.com/zac-xin/2693783

    */

    public static String printBinary(String input){

        if(input.indexOf('.') == -1){  // input is a integer
            int num = Integer.parseInt(input);
            String int_String = "";

            while(num > 0){
                int r = num % 2;
                num >>= 1;        // num不断右移，先判断低位，再判断高位
                int_String = r + int_String;
            }

            return int_String;

        }else{
            //存在小数点'.'
            int intPart;
            if(input.indexOf('.') == 0) //对形如".5",".25"的数，要赋值intPart
                intPart = 0;
            else
                intPart = Integer.parseInt(input.substring(0, input.indexOf('.')));

            //这里截取小数部分时，要包含'.'，不然截取就变成整数了
            double decPart = Double.parseDouble(input.substring(input.indexOf('.'),
                    input.length()));

            String int_String = "";
            while(intPart > 0){
                int r = intPart % 2;
                intPart >>= 1;
                int_String = r + int_String;
            }

            StringBuilder dec_String = new StringBuilder();

            while(decPart > 0){
                if(dec_String.length() > 32)
                    return "ERROR";

                double r = decPart * 2;

                if(r >= 1){
                    dec_String.append(1);
                    decPart = r - 1;
                }else{
                    dec_String.append(0);
                    decPart = r;
                }
            }
            return int_String + "." + dec_String.toString();
        }
    }

    /*
        You are given two 32-bit numbers, N and M, and two bit positions, i and j.
        Write a method to set all bits between i and j in N equal to M (e.g., M becomes
        a substring of N located at i and starting at j).
        EXAMPLE:
        Input: N = 10000000000, M = 10101, i = 2, j = 6
        Output:N = 10001010100

        Link: https://gist.github.com/zac-xin/2650838

    */

    public static int setBit(int n, int m, int i, int j){
        int k = ~0;
        k = k << (j - i + 1);
        k = ~k;
        k <<= i;

        int mask = ~k;

        return (m << i) | (n & mask);
    }
}
