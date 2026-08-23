class Solution {
    private List<int[]> nodesVisited = new ArrayList<>();
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for(int columnIndex = 0; columnIndex < grid[0].length; columnIndex++) {
                if(grid[rowIndex][columnIndex] == '1' && !isNodeVisited(rowIndex, columnIndex)) {
                    count++;
                    dfs(grid, rowIndex, columnIndex);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int rowIndex, int columnIndex) {
        if(rowIndex < 0 || rowIndex >= grid.length || columnIndex < 0 || columnIndex >= grid[0].length || grid[rowIndex][columnIndex] == '0' || isNodeVisited(rowIndex, columnIndex))
            return;
        
        nodesVisited.add(new int[]{rowIndex, columnIndex});
        dfs(grid, rowIndex - 1, columnIndex);
        dfs(grid, rowIndex + 1, columnIndex);
        dfs(grid, rowIndex, columnIndex + 1);
        dfs(grid, rowIndex, columnIndex - 1);
    }

    private boolean isNodeVisited(int rowIndex, int columnIndex) {
        for(int[] node : this.nodesVisited) {
            if(node[0] == rowIndex && node[1] == columnIndex)
                return true;
        }
        return false;
    }
}
