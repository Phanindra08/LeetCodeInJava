class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        for(int num: nums) {
            if(!numberSet.add(num))
                return true;
        }
        return false;
    }
}