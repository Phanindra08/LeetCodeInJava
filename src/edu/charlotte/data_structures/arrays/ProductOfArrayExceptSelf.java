package edu.charlotte.data_structures.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelfSolution1(int[] nums) {
        int suffix = 1;
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for(int index = 1; index < nums.length; index++)
            answer[index] = answer[index - 1] * nums[index - 1];
        for(int index = nums.length - 2; index >= 0; index--) {
            suffix = suffix * nums[index + 1];
            answer[index] *= suffix;
        }
        return answer;
    }

    public int[] productExceptSelfSolution2(int[] nums) {
        int[] answer = new int[nums.length];
        int product = 1;
        for(int index = 0; index < nums.length; index++) {
            answer[index] = product;
            product *= nums[index];
        }

        product = 1;
        for(int index = nums.length - 1; index >= 0; index--) {
            answer[index] = answer[index] * product;
            product *= nums[index];
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelfSolution1(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelfSolution2(new int[]{-1, 1, 0, -3, 3})));
    }
}
