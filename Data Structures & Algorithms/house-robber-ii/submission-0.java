class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0], Math.max(calculateMaximumRob(nums, 0, nums.length - 1), calculateMaximumRob(nums, 1, nums.length)));
    }

    public int calculateMaximumRob(int[] nums, int startIndex, int length) {
        int rob1 = 0, rob2 = 0;
        for(int index = startIndex; index < length; index++) {
            int temp = rob2;
            rob2 = Math.max(nums[index] + rob1, temp);
            rob1 = temp;
        }
        return rob2;
    }
}
