class Solution {
    public int maxProfit(int[] prices) {
        int maximumProfit = 0;
        int leftPointer = 0;
        for(int rightPointer = 1; rightPointer < prices.length; rightPointer++) {
            if(prices[rightPointer] < prices[leftPointer])
                leftPointer = rightPointer;
            else
               maximumProfit = (maximumProfit > (prices[rightPointer] - prices[leftPointer])) ? maximumProfit :  prices[rightPointer] - prices[leftPointer];
        }
        return maximumProfit;
    }
}
