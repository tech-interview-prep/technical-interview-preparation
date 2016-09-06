  /*
    Given a positive integer, return its corresponding column title as appear in an Excel sheet.

    For example:

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB

    Link: http://www.careercup.com/question?id=6139456847347712
    Link: http://leetcode.com/2010/10/amazon-bar-raiser-interview-question.html
  */
package facebook;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * @author bkoteshwarreddy
 */
public class _168ExcelSheetColumnTitle {

}

class Solution_ExcelSheetColumnTitle {
    public String replace(int n){
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

    /**
   * Get the remainder in each loop
   * It should be the last digit
   * Note that the map shall have 1 offset
   */
  public String convertToTitle(int n) {
    if (n <= 0) return "";
    StringBuilder title = new StringBuilder();

    while (n > 0) {
      n--; // note the 1 offset
      int r = n % 26;
      title.insert(0, (char)('A' + r));
      n = n / 26;
    }

    return title.toString();
  }

  /**
   * Recursive version, one line
   */
  public String convertToTitleRec(int n) {
      return n <= 0 ? "" : convertToTitleRec(--n / 26) + (char)('A' + (n % 26));
  }
}
