class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        for(int index = 0; index < nums.length; index++)
            lis[index] = 1;
        for(int index1 = nums.length - 2; index1 >= 0; index1--) {
            for(int index2 = index1 + 1; index2 < nums.length; index2++) {
                if(nums[index1] < nums[index2])
                    lis[index1] = Math.max(lis[index1], 1 + lis[index2]);
            }
        }

        int maximum = lis[0];
        for(int index = 1; index < nums.length; index++) {
            if(lis[index] > maximum)
                maximum = lis[index];
        }
        return maximum;
    }
}
