package edu.charlotte.data_structures.binary;

public class NumberOf1Bits {
    public int hammingWeightSolution1(int number) {
        int countNumberOfOnes = 0;
        while(number != 0) {
            countNumberOfOnes += (number % 2);
            number >>= 1;
        }
        return countNumberOfOnes;
    }

    public int hammingWeightSolution2(int number) {
        int countNumberOfOnes = 0;
        while(number != 0) {
            number &= (number - 1);
            countNumberOfOnes += 1;
        }
        return countNumberOfOnes;
    }

    public static void main(String[] args) {
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        System.out.println(numberOf1Bits.hammingWeightSolution1(11));
        System.out.println(numberOf1Bits.hammingWeightSolution1(128));
        System.out.println(numberOf1Bits.hammingWeightSolution2(2147483645));
    }
}
