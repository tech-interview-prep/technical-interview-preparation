package facebook;

/* 	
	Print non comments

*/	
public class PrintNonComments {
    public static void printNonComments(){

        String line = null;
        boolean begin = false;
        int j = 0;
        while((line= getNextLine(j)) != null){
            j++;
            if(line.isEmpty())
                System.out.println(line);
            else {
                int index = -1;
                for(int i=0; i<line.length(); i++){
                    if(!begin && line.charAt(i)=='/' && i+1<line.length() && line.charAt(i+1)=='*'){
                        begin = true;
                        index = i;
                        break;
                    }else if(begin && line.charAt(i)=='*' && i+1<line.length() && line.charAt(i+1)=='/'){
                        begin = false;
                        index = i+2<line.length()?i+2:line.length()-1;
                        break;
                    }
                }

                if(index != -1){
                    System.out.println(begin? line.substring(0, index) : line.substring(index));
                }else if(!begin)
                    System.out.println(line);

            }

        }
    }

    private static String getNextLine(int i) {
        if(i==0)
            return "hello /* this is a ";
        if(i==1)
            return "dsdsad";
        if(i==2)
            return "multi line comment */ all ";
        return null;
    }
}
