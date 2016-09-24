c class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int origin = x;
        long result = 0;
        while (x != 0){
            int r = x % 10;
            result = result * 10 + r;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return false;
            x = x/10;
        }
        if (result == origin) return true;
        else return false;
    }
}
