package edu.charlotte.data_structures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * This method utilizes a HashMap to store each number in the array as the key and its corresponding index as the value.
     * Iterates through the array and checks if the map contains the difference of target and current number, if yes returns the indexes of the current number and difference of target, current number.
     *
     * @param nums - The input is array of integers provided by the user
     * @param target - The target sum that the two numbers in the array should add up.
     * @return - returns an array containing the indices of the two numbers whose sum is equal to the target. It returns null if no such pair exists.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            if(map.containsKey(target - nums[index]))
                return new int[] {map.get(target - nums[index]), index};
            map.put(nums[index], index);
        }
        return null;
    }

    /**
     * We have given the Sample test cases from the Leetcode as input to the twoSum method.
     * @param args - Command line arguments (not used)
     */
    public static void main(String[] args) {
        TwoSum twoSumObject = new TwoSum();
        System.out.println(Arrays.toString(twoSumObject.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSumObject.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSumObject.twoSum(new int[]{3,3}, 6)));
    }
}
