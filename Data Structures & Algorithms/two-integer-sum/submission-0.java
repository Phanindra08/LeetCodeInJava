class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberAlongWithIndexes = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            if(numberAlongWithIndexes.containsKey(target - nums[index]))
                return new int[]{numberAlongWithIndexes.get(target - nums[index]), index};
            numberAlongWithIndexes.put(nums[index], index);
        }
        return null;
    }
}
