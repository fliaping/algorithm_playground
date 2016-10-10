public class Solution {
    public int removeElement(int[] nums, int val) {
        
        int counter = -1;
        
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if ( n == val){
                continue;
            }else{
                nums[++counter] = n;
            }
        }

        return ++counter;
    }
}