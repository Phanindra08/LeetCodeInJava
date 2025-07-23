package edu.charlotte.data_structures.binary;

import java.util.Arrays;

public class CountingBits {
    public int[] countBitsSolution1(int n) {
        int[] countNumberOfOnes = new int[n + 1];
        int offset = 1;
        countNumberOfOnes[0] = 0;
        for(int index = 1; index < (n + 1); index++) {
            if((offset << 1) == index)
                offset = index;
            countNumberOfOnes[index] = 1 + countNumberOfOnes[index - offset];
        }
        return countNumberOfOnes;
    }

    // Difficult to get this idea
    public int[] countBitsSolution2(int n) {
        int[] countNumberOfOnes = new int[n + 1];
        for(int index = 0; index < (n + 1); index++) {
            if(index == 0)
                countNumberOfOnes[0] = 0;
            else
                countNumberOfOnes[index] = 1 + countNumberOfOnes[index & (index - 1)];
        }
        return countNumberOfOnes;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        System.out.println(Arrays.toString(countingBits.countBitsSolution1(2)));
        System.out.println(Arrays.toString(countingBits.countBitsSolution2(5)));
    }
}
