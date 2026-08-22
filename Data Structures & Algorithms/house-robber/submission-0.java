class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for(int index = 0; index < nums.length; index++) {
            if(index == 0)
                dp[index] = nums[index];
            else if(index == 1)
                dp[index] = Math.max(dp[index - 1], nums[index]);
            else {
                dp[index] = Math.max(dp[index - 1], nums[index] + dp[index - 2]);
            }
        }
        return dp[nums.length - 1];
    }
}
