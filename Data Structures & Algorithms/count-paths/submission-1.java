class Solution {
    public int uniquePaths(int m, int n) {
        int[] rowValues = new int[n];
        int[] newRowValues;
        for(int index = 0; index < n; index++)
            rowValues[index] = 1;
        for(int index1 = m - 2; index1 >= 0; index1--) {
            newRowValues = new int[n];
            for(int index2 = n - 1; index2 >= 0; index2--)
                newRowValues[index2] = 1;
            for(int index2 = n - 2; index2 >= 0; index2--)
                newRowValues[index2] = newRowValues[index2 + 1] + rowValues[index2];
            rowValues = newRowValues;
        }
        return rowValues[0];
    }
}
