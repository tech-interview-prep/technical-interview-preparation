package facebook;

/* 	
	Microsoft Excel numbers cells as 1...26 and after that AA, AB.... AAA, AAB...ZZZ and so on.
    Given a number, convert it to that format and vice versa.
	
	Link: http://www.careercup.com/question?id=6139456847347712
	      http://leetcode.com/2010/10/amazon-bar-raiser-interview-question.html

*/	
public class ExcelNumbers {
    public static String replace(int n){
        StringBuffer s= new StringBuffer();

        while(n>=0){
            s.append((char)('a'+n%26));
            n=n/26-1;
        }
        return s.toString();
    }

    public String rowNumToStr(int rowNum){
        String s = "";
        char c = 'A';
        int start = (int)c -1;
        while(rowNum>0){
            s= (char)(start+rowNum%26) + s ;
            rowNum=rowNum/26;
        }
        return s;
    }
}
