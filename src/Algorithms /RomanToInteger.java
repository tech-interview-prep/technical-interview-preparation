public class RomanToInteger {
    public static void main(String[] args){
        String s = "LXV"; //1996
        System.out.println(romanToInt(s));
    }


    public static int romanToInt(String s) {
        if(s == null) throw new IllegalArgumentException("not a valid string");
        
        int value = 0, prev = 0, curr = 0;
    
        char prevRomanSign = s.charAt(0);

        if(s.length() == 1){
            value = getValue(prevRomanSign);
            return value;
        }

        for(int i = 1; i < s.length();++i){
            prev = getValue(prevRomanSign);
            curr = getValue(s.charAt(i));

            if(prev >= curr) value += prev;
            else value -= prev;
            
            prevRomanSign = s.charAt(i);     
        }
        value += curr; //not forgetting about last element
        return value; 
    }
    
    private static int getValue(char s){
        if(s == 'I') return 1;
        else if(s == 'V') return 5; 
        else if(s == 'X') return 10; 
        else if(s == 'L') return 50;
        else if(s == 'C') return 100;
        else if(s == 'D') return 500;
        else return 1000;
    }
    
}