package facebook;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3
 * characters left in the file.
 *
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 *
 * Note:
 * The read function will only be called once for each test case.
 *
 * https://leetcode.com/problems/read-n-characters-given-read4/
 */
public class _157ReadNCharactersGivenRead4 {
}

class Solution_ReadNCharactersGivenRead4 {
    /**
     * @param buf
     *            Destination buffer
     * @param n
     *            Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        int length = 0;
        char[] temp = new char[4];
        int readNum = 4;
        while (length < n && readNum == 4) {
            readNum = read4(temp);
            for (int i = 0; i < readNum && length < n; i++) {
                buf[length] = temp[i];
                length++;
            }
        }
        return length;
    }

    int read4(char[] buf) {
        throw new UnsupportedOperationException();
    }
}
