/* Reverse bits of a given 32 bits unsigned integer.
 * Given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 
 * (represented in binary as 00111001011110000010100101000000).
 */


public class ReverseBits {
    public static void main(String[] args){
        System.out.println(reverseBits(43261596));
    }


    public static int reverseBits(int n) {
        for(int i = 0; i < 16; i++){
            //called a helper function to swap each number into bits
            n = swapBits(n,i,32-i-1);
        }
        return n;
    }
    private static int swapBits(int n, int i, int j){
        System.out.println("n: " + n);
        System.out.println("i: " + i);
        System.out.println("j: " + j);
        System.out.println("n >> i: " + (n >> i));

        int a = (n >> i) & 1; //right shift by 1 follow by xor of 1 which brings back n
        int b = (n >> j) & 1;
        
        System.out.println("a: " + a);
        System.out.println("b:" + b);
        System.out.println( a^b); //bitwise or
        if((a^b) != 0){ //xor
            return n ^= (1 << i) | (1 << j); //bitwise or
        }
        return n;
    }

}