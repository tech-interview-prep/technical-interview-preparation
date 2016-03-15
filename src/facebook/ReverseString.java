package facebook;

/*
	Code a function that receives a string composed by words separated by spaces and returns a
	string where words appear in the same order but than the original string, but every word is inverted.

    Example, for this input string

    @"the boy ran"
    the output would be


    @"eht yob nar"
    Tell the complexity of the solution.
	
	Link: http://www.careercup.com/question?id=5106757177180160

*/	
public class ReverseString {

    // "the boy ran" --> "ran boy the"
    public String reverseWordsInLine(String str) {
        if( str == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for(String s: str.split(" ")) {
            sb.append(reverse(s));
            sb.append(" ");
        }

        return reverse(sb.toString());
    }

    // "the boy ran" --> "eht yob nar"
    public String reverseTheLine(String str) {
        if( str == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for(String s: str.split(" ")) {
            sb.append(reverse(s));
            sb.append(" ");
        }

        return sb.toString();
    }

    // hello --> olleh
	public String reverse(String str) {
        if( str == null) {
            return null;
        }

        char[] charArray = str.toCharArray();
        int i=0;
        int j=charArray.length-1;
        while(i<j) {
            char temp = charArray[j];
            charArray[j] = charArray[i];
            charArray[i] = temp;
            i++;
            j--;
        }

        return new String(charArray);
	}
}
