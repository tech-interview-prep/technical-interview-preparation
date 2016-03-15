package leetcode_online_judge;

public class ExcelSheetColumnTitle {
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
    static char[] alp = new char[27];
	static {
		alp[1] = 'A';
		for (int i = 2; i < 27; i++) {
			alp[i] = (char) (alp[i - 1] + 1);
		}
	}
	// Time:O(n/26) Space:O(1)
	public String convertToTitle(int n) {
		StringBuilder res = new StringBuilder();
		return convertToTitle(res, n);
	}

	private String convertToTitle(StringBuilder res, int n) {
		if (n == 0) {
			return res.toString();
		}
		int div = n / 26;
		int mod = n % 26;
		if (mod == 0) {
			res.insert(0, alp[26]);
			div--;
		} else {
			res.insert(0, alp[mod]);
		}
		return convertToTitle(res, div);
	}
}