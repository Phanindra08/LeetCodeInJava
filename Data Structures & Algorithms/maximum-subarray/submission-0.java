class Solution {
    public int maxSubArray(int[] nums) {
        int maximumSum = nums[0];
        int currentSum = 0;
        for(int num : nums) {
            if(currentSum < 0)
                currentSum = 0;
            currentSum += num;
            maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }
}
