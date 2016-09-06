package facebook;

/*
	Write a program to swap odd and even bits in an integer with as few instructions
    as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc).

	Link: https://gist.github.com/zac-xin/2724769

*/
public class SwapOddAndEven {
    public static int swapOddAndEven(int n){
        int mask1 = 0xAAAAAAAA;   // 1010 1010 1010 ...
        int mask2 = 0x55555555;	  // 0101 0101 0101 ...

        return  ((n & mask1) >> 1) | ((n & mask2) << 1);
    }
}
