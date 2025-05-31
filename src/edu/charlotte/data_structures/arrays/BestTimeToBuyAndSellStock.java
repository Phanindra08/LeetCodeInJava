package edu.charlotte.data_structures.arrays;

public class BestTimeToBuyAndSellStock {
    /**
     * This method utilizes a Two pointer approach.
     * The left pointer tracks the potential day to buy the stock (initialized with the first index of the array) and the right pointer which tracks the best possible day to sell the stock is initialized with the second index of the array.
     * If the price at the left pointer is greater than or equal to the price at the right pointer then a better day to buy the stock has been found hence the left pointer is updated to the right pointer, else if the difference of the prices at right pointer and left pointer is greater than maximum profit then the maximum profit is updated with the difference of the prices at right pointer and left pointer.
     * The right pointer is incremented after every iteration until the end of the array is reached.
     *
     * @param prices - An array of integers indicating the stock price on each day.
     * @return - returns an integer which indicates maximum profit that can be achieved from a single buy and sell transaction. Returns 0 if no profit is possible.
     */
    public int maxProfit(int[] prices) {
        int maximumProfit = 0;
        int leftPointer = 0, rightPointer = 1;
        while(rightPointer < prices.length) {
            if(prices[leftPointer] >= prices[rightPointer])
                leftPointer = rightPointer;
            else if((prices[rightPointer] - prices[leftPointer]) > maximumProfit)
                maximumProfit = prices[rightPointer] - prices[leftPointer];
            rightPointer++;
        }
        return maximumProfit;
    }

    /**
     * We have given the Sample test cases from the Leetcode as input to the maxProfit method.
     * @param args - Command line arguments (not used)
     */
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStockObject = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStockObject.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(bestTimeToBuyAndSellStockObject.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
