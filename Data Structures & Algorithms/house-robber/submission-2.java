class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int rob1 = nums[0];
        int rob2 = Math.max(nums[0], nums[1]);
        for(int index = 2; index < nums.length; index++) {
            int temp = rob2;
            rob2 = Math.max(nums[index] + rob1, rob2);
            rob1 = temp;
        }
        return rob2;

        // int[] dp = new int[nums.length];
        // for(int index = 0; index < nums.length; index++) {
        //     if(index == 0)
        //         dp[index] = nums[index];
        //     else if(index == 1)
        //         dp[index] = Math.max(dp[index - 1], nums[index]);
        //     else {
        //         dp[index] = Math.max(dp[index - 1], nums[index] + dp[index - 2]);
        //     }
        // }
        // return dp[nums.length - 1];
    }
}
