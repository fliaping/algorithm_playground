public class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums==null || nums.length == 0) return 0;

        int last  = nums[0];
        int counter = 1;

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            if (n == last) {
                continue;
            }else{
                nums[counter++] = n;
                last = n;
            }
        }
        return counter;
    }
}
