package edu.charlotte.data_structures.binary;

public class MissingNumber {
    public int missingNumberSolution1(int[] nums) {
        int length = nums.length;
        int sum = length;
        for(int index = 0; index < length; index++)
            sum += (index - nums[index]);
        return sum;
    }

    public int missingNumberSolution2(int[] nums) {
        int length = nums.length;
        int missingNumber = length;
        for(int index = 0; index < length; index++)
            missingNumber ^= (index ^ nums[index]);
        return missingNumber;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumberSolution1(new int[] {3, 0, 1}));
        System.out.println(missingNumber.missingNumberSolution1(new int[] {0, 1}));
        System.out.println(missingNumber.missingNumberSolution2(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
