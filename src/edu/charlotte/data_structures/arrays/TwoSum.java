package edu.charlotte.data_structures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * This method utilizes a HashMap to store each number in the array as the key and its corresponding index as the value.
     * Iterates through the array and checks if the map contains the difference of target and current number, if yes returns the indexes of the current number and difference of target, current number.
     *
     * @param nums - An array of integers provided by the user
     * @param target - The target sum that the two numbers in the array should add up.
     * @return - returns an array containing the indices of the two numbers whose sum is equal to the target. It returns null if no such pair exists.
     */
    public int[] twoSumSolution1(int[] nums, int target) {
        Map<Integer, Integer> previousMap = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            if(previousMap.containsKey(target - nums[index]))
                return new int[] {previousMap.get(target - nums[index]), index};
            previousMap.put(nums[index], index);
        }
        return null;
    }

    // Brute-Force Approach 1
    public int[] twoSumSolution2(int[] nums, int target) {
        for(int index1 = 1; index1 < nums.length; index1++){
            for(int index2 = index1; index2 < nums.length; index2++){
                if(nums[index2] + nums[index2 - index1] == target){
                    return new int[] {index2 - index1, index2};
                }
            }
        }
        return null;
    }

    // Brute-Force Approach 2
    public int[] twoSumSolution3(int[] nums, int target) {
        for(int index1 = 0; index1 < nums.length - 1; index1++) {
            for(int index2 = index1 + 1;index2 < nums.length; index2++) {
                if(nums[index1] + nums[index2] == target) {
                    return new int[] {index1, index2};
                }
            }
        }
        return new int[]{};
    }

    /**
     * We have given the Sample test cases from the Leetcode as input to the {@code twoSum} method.
     * @param args - Command line arguments (not used)
     */
    public static void main(String[] args) {
        TwoSum twoSumObject = new TwoSum();
        System.out.println(Arrays.toString(twoSumObject.twoSumSolution1(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSumObject.twoSumSolution2(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSumObject.twoSumSolution3(new int[]{3,3}, 6)));
    }
}
