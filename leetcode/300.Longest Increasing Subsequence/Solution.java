import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int maxLength = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (maxLength < dp[i]) {
                maxLength = dp[i];
            }
        }
        return maxLength;
    }

    /**
     * 二分法
     */
    public int lengthOfLISBinary(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] LIS = new int[nums.length];
        LIS[0] = nums[0];
        int endPointer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > LIS[endPointer]) {
                endPointer++;
                LIS[endPointer] = nums[i];
            } else {
                findAndReplace(LIS, nums[i], 0, endPointer);
            }
        }
        return endPointer + 1;
    }

    public void findAndReplace(int[] LIS, int num, int start, int end) {
        int sub = end - start;
        if (sub == 0) {
            LIS[start] = num;
            return;
        }
        if (sub == 1) {
            if (LIS[start] >= num) {
                LIS[start] = num;
            } else {
                LIS[end] = num;
            }
            return;
        }
        int middleIndex = sub / 2 + start;
        if (LIS[middleIndex] > num) {
            findAndReplace(LIS, num, start, middleIndex - 1);
        } else {
            findAndReplace(LIS, num, middleIndex + 1, end);
        }
    }

    public static void main(String[] args) {
        int result = new Solution().lengthOfLISBinary(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(result);
        // int[] lis = new int[]{10};
        // new Solution().findAndReplace(lis, 9, 0, 0);
        // System.out.println(Arrays.toString(lis));

    }

}