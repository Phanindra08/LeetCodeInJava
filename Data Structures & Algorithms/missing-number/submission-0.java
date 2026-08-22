class Solution {
    public int missingNumber(int[] nums) {
        int missingNumber = nums.length;
        for(int index = 0; index < nums.length; index++)
            missingNumber ^= index ^ nums[index];
        return missingNumber;
    }
}
