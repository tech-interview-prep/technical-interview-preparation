package utils;

import java.util.List;

public class Utils {
    public static void printTestln(Object get, Object expected) {
        if (get == null && expected == null) {
            System.out.println("get: null, expected: null");
        } else if (get == null){
            System.out.println("[ERROR] get: null, expected: " + expected.toString());
        } else if (expected == null) {
            System.out.println("[ERROR] get: "+ get.toString() + ", expected: null");
        } else if (get.equals(expected)) {
            System.out.println("get: " + get.toString() + ", expected: " + expected.toString());
        } else {
            System.out.println("[ERROR] get: " + get.toString() + ", expected: " + expected.toString());
        }
    }

    public static void printTestBooleanArrayln(boolean[] get, boolean[] expected) {
        for (int i = 0; i < get.length; i++) {
            if (get == expected) {
                System.out.println("get: " + get[i] + ", expected: " + expected[i]);
            } else {
                System.out.println("[ERROR] get: " + get[i] + ", expected: " + expected[i]);
            }
        }
        System.out.println();
    }

    public static void printArrayln(String[] data, String dilimit) {
        for (String s : data) {
            System.out.print(s + dilimit);
        }
        System.out.println();
    }

    public static void printArrayln(String[] data) {
        printArrayln(data, "\t");
    }

    public static void printArrayln(char[] data) {
        for (char c : data) {
            System.out.print(c + "\t");
        }
        System.out.println();
    }

    public static void printArrayln(int[] data) {
        for (int i : data) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void print2DArrayln(int[][] data) {
        for (int[] i : data) {
            printArrayln(i);
        }
    }

    public static void print2DArrayln(char[][] data) {
        for (char[] i : data) {
            printArrayln(i);
        }
    }

    public static void printArrayRangeln(char[] charSeq, int start, int end) {
        if (end > charSeq.length) {
            end = charSeq.length;
        } else if (end < 0) {
            return;
        }

        for (int i = 0; i < end; i++) {
            System.out.print(charSeq[start + i]);
        }
    }

     public static void printArrayRangeln(char[] charSeq, int end) {
        printArrayRangeln(charSeq, 0, end);
    }

    public static void printListln(List<?> data) {
        for (Object o : data) {
            System.out.print(o.toString() + "\t");
        }
        System.out.println();
    }

    public static void printListln(List<?> data, String dilimit) {
        for (Object o : data) {
            System.out.print(o.toString() + dilimit);
        }
        System.out.println();
    }

    public static void printListListln(List<? extends List<?>> data) {
        for (List<?> l : data) {
            printListln(l);
        }
        System.out.println();
    }

    public static void printListArrayln(List<String[]> data, String dilimit) {
        for (String[] l : data) {
            printArrayln(l, dilimit);
        }
        System.out.println();
    }

    public static void printListArrayln(List<String[]> data) {
        printListArrayln(data, "\t");
    }

    public static void printIntListln(List<Integer> data) {
        for (int i : data) {
            System.out.print(i + "\t");
        }
        System.out.println("");
    }

    public static void printTestArrayln(int[] get, int[] expected) {
        int getLength = get.length, expectedLength = expected.length, length;
        if (getLength != expectedLength) {
            System.out.println("[ERROR] Integer Array Lengths do not match: " + getLength + " vs " + expectedLength);
        }
        length = Math.min(getLength, expectedLength);
        for (int i = 0; i < length; i++) {
            if (get[i] == expected[i]) {
                System.out.println("get: " + get[i] + ", expected: " + expected[i]);
            } else {
                System.out.println("[ERROR] get: " + get[i] + ", expected: " + expected[i]);
            }
        }
        System.out.println();
    }

    public static void printTestListln(List<Integer> get, List<Integer> expected) {
        int getSize = get.size(), expectedSize = expected.size(), size;
        if (getSize != expectedSize) {
            System.out.println("[ERROR] Integer List Sizes do not match: " + getSize + " vs " + expected.size());
        }
        size = Math.min(getSize, expectedSize);
        for (int i = 0; i < size; i++) {
            if (get.get(i).equals(expected.get(i))) {
                System.out.println("get: " + get.get(i) + ", expected: " + expected.get(i));
            } else {
                System.out.println("[ERROR] get: " + get.get(i) + ", expected: " + expected.get(i));
            }
        }
        System.out.println();
    }

    public static void swap(char[] input, int i, int j) {
        if (i == j || i < 0 || j < 0 || i >= input.length || j >= input.length) {
            return;
        }

        input[i] ^= input[j];
        input[j] ^= input[i];
        input[i] ^= input[j];
    }

     public static void swap(int[] input, int i, int j) {
        if (i == j || i < 0 || j < 0 || i >= input.length || j >= input.length) {
            return;
        }

        input[i] ^= input[j];
        input[j] ^= input[i];
        input[i] ^= input[j];
    }
}