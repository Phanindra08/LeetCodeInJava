class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            if(numberMap.containsKey(target - nums[index]))
                return new int[]{numberMap.get(target - nums[index]), index};
            numberMap.put(nums[index], index);
        }
        return null;
    }
}
