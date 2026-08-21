class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowZero = false;
        for(int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for(int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++) {
                if(matrix[rowIndex][columnIndex] == 0) {
                    if(rowIndex == 0) {
                        isFirstRowZero = true;
                        matrix[0][columnIndex] = 0;
                    } else {
                        matrix[0][columnIndex] = 0;
                        matrix[rowIndex][0] = 0;
                    } 
                }
            }
        }

        for(int rowIndex = 1; rowIndex < matrix.length; rowIndex++) {
            for(int columnIndex = 1; columnIndex < matrix[0].length; columnIndex++) {
                if(matrix[rowIndex][0] == 0 || matrix[0][columnIndex] == 0)
                    matrix[rowIndex][columnIndex] = 0;
            }
        }

        if(matrix[0][0] == 0) {
            for(int index = 0; index < matrix.length; index++)
                matrix[index][0] = 0;
        }

        if(isFirstRowZero) {
            for(int index = 0; index < matrix[0].length; index++)
                matrix[0][index] = 0;
        }
    }
}
