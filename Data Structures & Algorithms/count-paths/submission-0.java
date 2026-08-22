class Solution {
    public int uniquePaths(int m, int n) {
        int[][] numberOfPaths = new int[m][n];
        numberOfPaths[m - 1][n - 1] = 1;
        for(int rowIndex = m - 1; rowIndex >= 0; rowIndex--) {
            for(int columnIndex = n - 1; columnIndex >= 0; columnIndex--) {
                if(rowIndex + 1 < m)
                    numberOfPaths[rowIndex][columnIndex] += numberOfPaths[rowIndex + 1][columnIndex];
                    if(columnIndex + 1 < n)
                    numberOfPaths[rowIndex][columnIndex] += numberOfPaths[rowIndex][columnIndex + 1];
            }
        }
        return numberOfPaths[0][0];
    }
}
