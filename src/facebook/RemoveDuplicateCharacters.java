package facebook;

/* 	
	Design an algorithm and write code to remove the duplicate characters in a string
	without using any additional buffer.
	
	Link: https://gist.github.com/zac-xin/2413013

*/	
public class RemoveDuplicateCharacters {
    public static void removeDup(char[] data){
        int len = data.length;
        if(len < 2)
            return;
        int i,j;
        int tail = 1;

        for(i = 1; i < len; i++){
            for(j = 0; j < tail; j++){
                if(data[i] == data[j])
                    break;
            }
            if(j == tail){
                data[tail] = data[i];
                tail++;
            }
        }
        for(i = tail; i < len; i++)
            data[i] = '\0';
    }
}
