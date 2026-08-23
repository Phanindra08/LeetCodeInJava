class Solution {
    public boolean exist(char[][] board, String word) {
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for(int columnIndex = 0; columnIndex < board[rowIndex].length; columnIndex++)
                if(dfs(board, word, rowIndex, columnIndex, 0, new ArrayList<>()))
                    return true;
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int rowIndex, int columnIndex, int wordIndex, List<int[]> pathVisited) {
        if(wordIndex == word.length())
            return true;
        else if(rowIndex < 0 || columnIndex < 0 || rowIndex >= board.length || columnIndex >= board[0].length || board[rowIndex][columnIndex] != word.charAt(wordIndex) ||
        isElementAlreadyVisited(new int[]{rowIndex, columnIndex}, pathVisited))
            return false;
        
        int[] indexesOfElementVisited = new int[] {rowIndex, columnIndex};
        pathVisited.add(indexesOfElementVisited);
        boolean result = dfs(board, word, rowIndex - 1, columnIndex, wordIndex + 1, pathVisited) ||
        dfs(board, word, rowIndex + 1, columnIndex, wordIndex + 1, pathVisited) ||
        dfs(board, word, rowIndex, columnIndex - 1, wordIndex + 1, pathVisited) ||
        dfs(board, word, rowIndex, columnIndex + 1, wordIndex + 1, pathVisited);
        pathVisited.removeIf(arr -> Arrays.equals(arr, indexesOfElementVisited));

        return result;
    }

    private boolean isElementAlreadyVisited(int[] elementIndexes, List<int[]> pathVisited) {
        for(int[] value : pathVisited) {
            if(value[0] == elementIndexes[0] && value[1] == elementIndexes[1])
                return true;
        }
        return false;
    }
}
