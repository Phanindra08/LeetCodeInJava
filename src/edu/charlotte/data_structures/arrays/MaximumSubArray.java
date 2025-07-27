package edu.charlotte.data_structures.arrays;

public class MaximumSubArray {
    public int maxSubArraySolution1(int[] nums) {
        int currentSum = 0, maximumSum = Integer.MIN_VALUE;
        for(int num : nums) {
            currentSum += num;
            if(currentSum > maximumSum)
                maximumSum = currentSum;
            if(currentSum < 0)
                currentSum = 0;
        }
        return maximumSum;
    }

    public int maxSubArraySolution2(int[] nums) {
        int currentSum = 0;
        int maximumSum = nums[0];
        for(int num : nums) {
            currentSum = num < (currentSum + num) ? (currentSum + num) : num;
            maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }

    public static void main(String[] args) {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        System.out.println(maximumSubArray.maxSubArraySolution1(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maximumSubArray.maxSubArraySolution1(new int[] {1}));
        System.out.println(maximumSubArray.maxSubArraySolution2(new int[] {5, 4, -1, 7, 8}));
    }
}