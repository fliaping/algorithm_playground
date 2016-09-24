public class Solution {
    public int myAtoi(String str) {
       int result = 0;
        int i = 0 ,limit = -Integer.MAX_VALUE;
        boolean isNegative = false;
        if (str == null || "".equals(str)) return 0;
        int len = str.length();
        while (str.charAt(i++) == ' ');
        --i;
        char firstChar = str.charAt(i);
        if (firstChar == '-'){
            limit = Integer.MIN_VALUE;
            isNegative = true;
            i++;
        }else if (firstChar == '+'){
            i++;
        }
        while (i<len){
            char thisChar = str.charAt(i++);
            if (thisChar < '0' || thisChar > '9') break;
            int thisNum = thisChar - '0';

            if (result < limit/10) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            result *= 10;

            if (result < limit + thisNum) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            result -= thisNum;
        }

        return isNegative ? result : -result;
    }
}
