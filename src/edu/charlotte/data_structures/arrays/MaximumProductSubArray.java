package edu.charlotte.data_structures.arrays;

public class MaximumProductSubArray {
    public int maximumValue(int number1, int number2, int number3) {
        return (number1 >= number2 && number1 >= number3) ? number1 : (number1 < number2 && number2 >= number3) ? number2 : number3;
    }

    public int maxProductSolution1(int[] nums) {
        int currentMaximum = 1, currentMinimum = 1, maximumProduct = Integer.MIN_VALUE;
        int temp;
        for(int num : nums) {
            if(num == 0) {
                currentMaximum = 1;
                currentMinimum = 1;
                maximumProduct = (maximumProduct > num) ? maximumProduct : num;
                continue;
            }
            temp = currentMaximum * num;
            currentMaximum = maximumValue(num, temp, currentMinimum * num);
            currentMinimum = Math.min(num, Math.min(temp, currentMinimum * num));
            maximumProduct = (maximumProduct > currentMaximum) ? maximumProduct : currentMaximum;
        }
        return maximumProduct;
    }

    public int maxProductSolution2(int[] nums) {
        int maxProduct = nums[0];
        int currentProduct = 1;

        // Iterating from left to right
        for(int num : nums) {
            currentProduct *= num;
            maxProduct = Math.max(maxProduct, currentProduct);

            // Resetting the currentProduct when it becomes 0
            if (currentProduct == 0)
                currentProduct = 1;
        }

        currentProduct = 1;
        // Iterating from right to left
        for (int index = nums.length - 1; index >= 0; index--) {
            currentProduct *= nums[index];
            maxProduct = Math.max(maxProduct, currentProduct);
            if (currentProduct == 0)
                currentProduct = 1;
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductSubArray maximumProductSubArray = new MaximumProductSubArray();
        System.out.println(maximumProductSubArray.maxProductSolution1(new int[] {2, 3, -2, 4}));
        System.out.println(maximumProductSubArray.maxProductSolution2(new int[] {-2, 0, -1}));
    }
}