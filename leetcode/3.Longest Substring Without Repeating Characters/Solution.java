public class Solution {
   public int lengthOfLongestSubstring(String s) {
    int maxLen = 0;
    int maxLenIndex = 0;
    int[] visited = new int[256];
    int i=0,j=0;
    for (i=0;i<s.length();i++) {
      memset(visited);
      visited[s.charAt(i)]=1;
  
      for (j=i+1;j<s.length();j++) {
        if (visited[s.charAt(j)]==0) {
          visited[s.charAt(j)] = 1;
        }else {
          if(j-i>maxLen){
            maxLen = j-i;
            maxLenIndex = i;
          }
          break;
        }
      }
      if (j==s.length()&&j-i>maxLen) {
          maxLen = j-i;
          maxLenIndex = i;
      }
    }
    
    return maxLen;
  }
  
  public void memset(int[] arr){
    for (int i = 0;i<arr.length;i++) {
      arr[i]=0;
    }
  }
}
