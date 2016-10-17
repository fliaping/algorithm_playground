public class Solution {
    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        //int position = 0;
        int[] lastRange = null;
        for(int i=0;i<array.length;i++){
            int[] thisRange = getOnceRange(array,i);
            if(lastRange == null) lastRange = thisRange;
            if((thisRange[1]-thisRange[0]+1)>(lastRange[1]-lastRange[0]+1)) lastRange = thisRange;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = lastRange[0];i<=lastRange[1];i++){
            sb.append(array[i]);
        }
        return sb.toString();
    }
    
    public int[] getOnceRange(char[] s,int position){
        int[] range = new int[2];
        int start = 0,end = 0;
        int start_x = 0,end_x =0;
        
        if((position+1)<s.length && s[position] == s[position+1]){
            start = position;
            end = position+1;
            //if((position-1) >= 0 && s[position-1] == s[position]) start = end = position;
        }else{
            start = end =position;
        }
        //System.out.println(" start:"+start+" end:"+end);
        if(start != end){
            start_x = end_x = start;
            while((start_x-1) >= 0 && (end_x+1) <= s.length-1){
                if(s[--start_x]!= s[++end_x]) {
                    ++start_x;--end_x;
                    break;
                }
            }
        }
        
        while((start-1) >= 0 && (end+1) <= s.length-1){
            if(s[--start]!= s[++end]) {
                ++start;--end;
                break;
            }
        }
        if((end_x-start_x)>(end-start)){
            range[0] = start_x;
            range[1] = end_x;
        }else{
            range[0] = start;
            range[1] = end;
        }
        
        //System.out.println("position:"+position+" start:"+start+" end:"+end);
        return range;
    }
}
