class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for(int num : nums) {
            if(!values.add(num))
                return true;
        }
        return false;
    }
}