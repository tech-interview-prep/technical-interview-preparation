package leetcode_online_judge.Java;

import utils.Utils;

import java.io.*;

public class _055JumpGame {
    /*
     Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.

    For example:
    A = [2,3,1,1,4], return true.

    A = [3,2,1,0,4], return false.
     */
    public static boolean canJump(int[] A) {
        return canJump(A, 0);
    }

    private static boolean canJump(int[] A, int start) {
        if (start >= A.length) {
            return true;
        }

        for (int i = 1; i <= A[start]; i++) {
            if (canJump(A, start + i)) {
                return true;
            }
        }

        return false;
    }

    public static boolean canJumpDP(int[] A) {
        if (A.length == 0) {
            return true;
        }

        boolean[] canJump = new boolean[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] + i >= A.length - 1) {
                canJump[i] = true;
            } else {
                for (int j = A[i]; j > 0; j--) {
                    if (canJump[j + i]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }

        return canJump[0];
    }

    public static boolean canJumpDP2(int[] A) {
        int closestIndex = A.length - 1;

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] + i >= closestIndex) {
                closestIndex = i;
            }
        }

        return closestIndex == 0;
    }


    protected static int[] getLargeSampleIntArray(){

        InputStream is  = _055JumpGame.class.getResourceAsStream("/JumpGame.data");

        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            int[] ret = new int[Integer.parseInt(line)];

            for ( int i = 0; i < ret.length && (line = br.readLine()) != null; i++) {
                ret[i] = Integer.parseInt(line);
            }

            br.close();
            isr.close();
            is.close();

            return ret;
        } catch (IOException e) {
            return new int[0];
        }
    }



    private static void test() {
        int[] largeArray = getLargeSampleIntArray();

        Utils.printTestln(canJump(new int[]{2, 3, 1, 1, 4}), true);
        Utils.printTestln(canJump(new int[]{3, 2, 1, 0, 4}), false);
        Utils.printTestln(canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}), false);


        Utils.printTestln(canJumpDP(new int[]{2, 3, 1, 1, 4}), true);
        Utils.printTestln(canJumpDP(new int[]{3, 2, 1, 0, 4}), false);
        Utils.printTestln(canJumpDP(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}), false);
        Utils.printTestln(canJumpDP(largeArray), false);

        Utils.printTestln(canJumpDP2(new int[]{2, 3, 1, 1, 4}), true);
        Utils.printTestln(canJumpDP2(new int[]{3, 2, 1, 0, 4}), false);
        Utils.printTestln(canJumpDP2(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}), false);
        Utils.printTestln(canJumpDP2(largeArray), false);
    }


    public static void main(String[] args) {
        test();
    }
}
