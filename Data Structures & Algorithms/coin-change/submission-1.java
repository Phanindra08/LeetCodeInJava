class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int index = 0; index < amount + 1; index++)
            dp[index] = amount + 1;
        dp[0] = 0;
        for(int index = 1; index < amount + 1; index++) {
            for(int coin: coins) {
                if(index - coin >= 0)
                    dp[index] = Math.min(dp[index], 1 + dp[index - coin]);
            }
        }
        return (dp[amount] == amount + 1)? -1 : dp[amount];
    }
}
