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

    /**
     * We have given the Sample test cases from the Leetcode as input to the {@code containsDuplicate} method.
     * @param args - Command line arguments (not used)
     */
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicateObject = new ContainsDuplicate();
        System.out.println(containsDuplicateObject.containsDuplicateSolution1(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicateObject.containsDuplicateSolution1(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicateObject.containsDuplicateSolution2(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
