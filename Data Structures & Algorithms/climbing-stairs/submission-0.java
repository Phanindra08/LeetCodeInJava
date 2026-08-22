class Solution {
    public int climbStairs(int n) {
        int oneStep = 1;
        int twoStep = 0;
        for(int index = n - 1; index >= 0; index--) {
            int temp = oneStep;
            oneStep = oneStep + twoStep;
            twoStep = temp;
        }
        return oneStep;
    }
}
