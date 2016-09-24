public class Solution {
    public String longestCommonPrefix(String[] strs) {
         if (strs.length == 0) return "";

        int i = 0;
        while (true){
            boolean end = false;
            if (strs[0].length() ==0) return "";
            if (strs[0].length() <=i) break;
            char comChar = strs[0].charAt(i);
            for (String str:
                 strs) {
                if (str.length()<=i || str.charAt(i) != comChar) end = true;
            }
            //System.out.println("i:"+i);
            if (end) {
                break;
            }
            else i++;
        }
        if (i<0) return "";
        return strs[0].substring(0,i);
    }
}
