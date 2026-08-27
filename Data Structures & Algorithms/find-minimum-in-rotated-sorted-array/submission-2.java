class Solution {
    public int findMin(int[] nums) {
        int minimumValue = nums[0];
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] < minimumValue)
                minimumValue = nums[mid];
            if(nums[mid] >= nums[start] && nums[mid] >= nums[end])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return minimumValue;
    }
}
