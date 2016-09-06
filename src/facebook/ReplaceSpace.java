package facebook;

/*
	Write a method to replace all spaces in a string with ‘%20’

	Link: https://gist.github.com/zac-xin/2413516

*/
public class ReplaceSpace {
    public static String replaceSpace(String input){
        char s[] = input.toCharArray();
        int spaceCount = 0;
        int index = 0;

        for(int i = 0; i < s.length; i++)
            if(s[i] == ' ')
                spaceCount++;

        int newLength = s.length + 2 * spaceCount;
        char r[] = new char[newLength];

        for(int i = 0 ; i < s.length; i++){
            if(s[i] != ' ')
                r[index++] = s[i];
            else{
                r[index++] = '%';
                r[index++] = '2';
                r[index++] = '0';
            }
        }
        String result = new String(r);
        return result;
    }
}
