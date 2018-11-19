class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
       return doClimbStairs(n, memo);
    }
    
    public int doClimbStairs(int n, int[] memo) {
         if(memo[n] > 0) {
            return memo[n];
        }
        if(n==1) {
            memo[n] = 1;
        }else if(n==2) {
            memo[n] = 2;
        } else {
            memo[n] = doClimbStairs(n-1, memo) + doClimbStairs(n-2, memo);
        }
        return memo[n];
    }
}