class Solution {
    public int[] countBits(int n) {
        int[] output = new int[n + 1];
        int offset = 1;
        for(int index = 1; index <= n; index++) {
            if(offset << 1 == index)
                offset = index;
            output[index] = 1 + output[index - offset];
        }
        return output;
    }
}
