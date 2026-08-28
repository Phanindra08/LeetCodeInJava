class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for(int index = 0; index < 32; index++) {
            result = (result << 1) | (n & 1);
            n >>>= 1;
        }
        return result;
    }
}
