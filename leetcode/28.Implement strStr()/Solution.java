public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return 0;
        if(needle.length() == 0) return 0;
        for(int i = 0;i<haystack.length();i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                boolean isOccur = true;
              for(int j=1;j<needle.length();j++){
                 
                  if(i+j > haystack.length()-1) return -1;
                  //System.out.println(needle.charAt(j));
                  if(haystack.charAt(i+j) != needle.charAt(j))
                    isOccur = false;
              }
              if(isOccur) return i;
            }
        }
        return -1;
    }
}
