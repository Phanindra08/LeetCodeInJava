class Solution {
    public int search(int[] nums, int target) {
        int startIndex = 0, endIndex = nums.length - 1;
        while(startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if(nums[midIndex] == target)
                return midIndex;
            
            if(nums[midIndex] >= nums[startIndex]) {
                if(target < nums[startIndex] || target > nums[midIndex])
                    startIndex = midIndex + 1;
                else
                    endIndex = midIndex - 1;
            } else {
                if(target >= nums[midIndex] && target <= nums[endIndex])
                    startIndex = midIndex + 1;
                else
                    endIndex = midIndex - 1;
            }
        }
        return -1;
    }
}
