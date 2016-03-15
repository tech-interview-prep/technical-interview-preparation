package facebook;

public class RomanNumbers {
    /*
        Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

        Link: https://gist.github.com/zac-xin/4389754

    */

    public int romanToInt(String s) {
        char symbols[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int values[] = {1000, 500, 100, 50, 10, 5, 1};

        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0)
            return 0;

        s = s.toUpperCase();
        for(int i = 0; i < symbols.length; i++){
            int index = s.indexOf(symbols[i]);
            if(index != -1){
                return values[i] - romanToInt(s.substring(0, index)) + romanToInt(s.substring(index + 1));
            }
        }
        return 0;
    }

    public String intToRoman(int r){
        if(r < 1 || r > 3999) {
            return "INVALID";
        }
        String[] s =
                {"M","CM","D","CD","C","XC",
                        "L","XL","X","IX","V","IV","I"};
        int[] u =
                {1000, 900, 500, 400, 100, 90,
                        50, 40, 10, 9, 5, 4, 1};
        String t = "";
        for (int i = 0; i < 13; i++)
            while (r >= u[i]) {
                t += s[i];
                r -= u[i];
            }
        return t;
    }
}
