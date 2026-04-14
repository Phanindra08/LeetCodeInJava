class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] result = new int[nums.length];

        for(int index = 0; index < nums.length; index++) {
            result[index] = product;
            product *= nums[index];
        }

        product = 1;
        for(int index = nums.length - 1; index >= 0; index--) {
            result[index] *= product;
            product *= nums[index];
        }

        return result;
    }
}  
