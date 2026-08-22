class Solution {
    public int[] countBits(int n) {
        int[] output = new int[n + 1];
        for(int index = 1; index <= n; index++)
            output[index] = 1 + output[(index & (index - 1))];
        return output;
    }
}
