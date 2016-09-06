package facebook;

/*
	Given a sorted array of strings which is interspersed with empty strings,
    write a meth- od to find the location of a given string.

    Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”]
        will return 4
    Example: find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”]
        will return -1

	Link: https://gist.github.com/zac-xin/3950000

*/
public class FindStringInArrayWithEmptyStrings {
    public static int searchI(String[] strings, String str, int first, int last) {
        while (first <= last) {
			/* Move mid to the middle */
            int mid = (last + first) / 2;

			/* If mid is empty, find closest non-empty string */
            if (strings[mid].isEmpty()) {
                int left = mid - 1;
                int right = mid + 1;
                while (true) {
                    if (left < first && right > last) {
                        return -1;
                    } else if (right <= last && !strings[right].isEmpty()) {
                        mid = right;
                        break;
                    } else if (left >= first && !strings[left].isEmpty()) {
                        mid = left;
                        break;
                    }
                    right++;
                    left--;
                }
            }

            int res = strings[mid].compareTo(str);
            if (res == 0) { // Found it!
                return mid;
            } else if (res < 0) { // Search right
                first = mid + 1;
            } else { // Search left
                last = mid - 1;
            }
        }
        return -1;
    }

    // ---------------------------------------------------------- //

    public static int searchR(String[] strings, String str, int first, int last) {
        if (first > last) {
            return -1;
        }

		/* Move mid to the middle */
        int mid = (last + first) / 2;

		/* If mid is empty, find closest non-empty string. */
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

		/* Check for string, and recurse if necessary */
        if (str.equals(strings[mid])) { // Found it!
            return mid;
        } else if (strings[mid].compareTo(str) < 0) { // Search right
            return searchR(strings, str, mid + 1, last);
        } else { // Search left
            return searchR(strings, str, first, mid - 1);
        }
    }

    // ---------------------------------------------------------- //

    public static int findString(String[] a, String x){
        if(a.length == 0 || x == null)
            return -1;
        if(x == ""){
            for(int i = 0 ; i < a.length; i++){
                if(a[i] == "")
                    return i;
            }
            return -1;
        }
        return findString(a, x, 0, a.length - 1);
    }

    public static int findString(String[] a, String x, int low, int high){
        while(low <= high){
            while(low <= high && a[high] == ""){
                high--;
            }
            while(low <= high && a[low] == ""){
                low++;
            }

            int mid = (low + high) / 2;

            while(a[mid] == ""){
                mid++;
            }
            if(a[mid].compareTo(x) == 0){
                return mid;
            }else if (a[mid].compareTo(x) < 0){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}
