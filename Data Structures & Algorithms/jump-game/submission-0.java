class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for(int index1 = nums.length - 1; index1 >= 0; index1--) {
            if(index1 + nums[index1] >= goal)
                goal = index1;
        }
        return goal == 0;
    }
}
