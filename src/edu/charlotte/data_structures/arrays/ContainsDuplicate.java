package edu.charlotte.data_structures.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /**
     * This method utilizes a HashSet to keep track of the elements encountered during iteration.
     * Iterates through the array and checks if the number already exists in the set, if a duplicate has been found returns true, otherwise the number is added to the set.
     * Returns false, If the iteration has been completed without finding any duplicates.
     *
     * @param nums - An array of integers provided by the user
     * @return - returns true if the array contains duplicate values, else returns false.
     */
    public boolean containsDuplicateSolution1(int[] nums) {
        Set<Integer> numbersSet = new HashSet<>();
        for (int num : nums) {
            if (numbersSet.contains(num))
                return true;
            numbersSet.add(num);
        }
        return false;
    }

    public boolean containsDuplicateSolution2(int[] nums) {
        Set<Integer> numbersSet = new HashSet<>(Arrays.stream(nums).boxed().toList());
        return numbersSet.size() != nums.length;
    }

    public boolean containsDuplicateSolution3(int[] nums) {
        Set<Integer> numbersSet = new HashSet<>();
        for(int num : nums) {
            if(!numbersSet.add(num))
                return true;
        }
        return false;
    }

    public boolean containsDuplicateSolution4(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums)
            seen.add(num);
        return seen.size() != nums.length;
    }

    public boolean containsDuplicateSolution5(int[] nums) {
        for (int index1 = 1; index1 < nums.length; index1++) {
            int key = nums[index1];
            int index2 = index1 - 1;
            while (index2 >= 0 && nums[index2] > key) {
                nums[index2 + 1] = nums[index2];
                index2--;
            }
            if (index2 >= 0 && nums[index2] == key)
                return true;
            nums[index2 + 1] = key;
        }
        return false;
    }

    /**
     * We have given the Sample test cases from the Leetcode as input to the {@code containsDuplicate} method.
     * @param args - Command line arguments (not used)
     */
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicateObject = new ContainsDuplicate();
        System.out.println(containsDuplicateObject.containsDuplicateSolution1(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicateObject.containsDuplicateSolution3(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicateObject.containsDuplicateSolution2(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println(containsDuplicateObject.containsDuplicateSolution4(new int[]{2, 1, 3, 0, 5, 2}));
        System.out.println(containsDuplicateObject.containsDuplicateSolution5(new int[]{2, 1, 3, 0, 5, -1}));
    }
}