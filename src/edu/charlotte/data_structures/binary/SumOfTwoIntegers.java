package edu.charlotte.data_structures.binary;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int carry;
        while(b != 0) {
            carry = a & b;
            a ^= b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        System.out.println(sumOfTwoIntegers.getSum(1, 2));
        System.out.println(sumOfTwoIntegers.getSum(2, 3));
    }
}
