package leetcode_online_judge.Java;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * @author bkoteshwarreddy
 */

public class _168ExcelSheetColumnTitle {
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
   */

  /**
   * Get the remainder in each loop
   * It should be the last digit
   * Note that the map shall have 1 offset
   */
  public static String convertToTitle(int n) {
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
  public static String convertToTitleRec(int n) {
      return n <= 0 ? "" : convertToTitleRec(--n / 26) + (char)('A' + (n % 26));
  }
}
