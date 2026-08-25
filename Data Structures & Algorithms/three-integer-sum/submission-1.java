class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int index = 0; index < nums.length; index++) {
            if(index > 0 && nums[index] == nums[index - 1])
                continue;
            int leftPointer = index + 1, rightPointer = nums.length - 1;
            while(leftPointer < rightPointer) {
                if(nums[leftPointer] + nums[rightPointer] + nums[index] == 0) {
                    result.add(List.of(nums[index], nums[leftPointer], nums[rightPointer]));
                    do {
                        leftPointer++;
                    } while(leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer - 1]);
                } else if(nums[leftPointer] + nums[rightPointer] + nums[index] > 0)
                    rightPointer--;
                else
                    leftPointer++;
            }
        }
        return result;
    }
}
