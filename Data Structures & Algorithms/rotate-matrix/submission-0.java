class Solution {
    public void rotate(int[][] matrix) {
        int leftPointer = 0, rightPointer = matrix.length - 1;
        while(leftPointer < rightPointer) {
            int top = leftPointer;
            int bottom = rightPointer;
            for(int index = 0; index < (rightPointer - leftPointer); index++) {
                int temp = matrix[top][leftPointer + index];
                matrix[top][leftPointer + index] = matrix[bottom - index][leftPointer];
                matrix[bottom - index][leftPointer] = matrix[bottom][rightPointer - index];
                matrix[bottom][rightPointer - index] = matrix[top + index][rightPointer];
                matrix[top + index][rightPointer] = temp;
            }
            leftPointer++;
            rightPointer--;
        }
    }
}
