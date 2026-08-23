class Solution {
    private boolean[][] nodesVisited;
    public int numIslands(char[][] grid) {
        int count = 0;
        nodesVisited = new boolean[grid.length][grid[0].length];
        List<int[]> directions = new ArrayList<>(4);
        directions.add(new int[]{1, 0});
        directions.add(new int[]{-1, 0});
        directions.add(new int[]{0, 1});
        directions.add(new int[]{0, -1}); 
        for(int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for(int columnIndex = 0; columnIndex < grid[0].length; columnIndex++) {
                if(grid[rowIndex][columnIndex] == '1' && !nodesVisited[rowIndex][columnIndex]) {
                    count++;
                    bfs(grid, rowIndex, columnIndex, directions);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int rowIndex, int columnIndex, List<int[]> directions) {
        Deque<int[]> queue = new ArrayDeque<>();
        nodesVisited[rowIndex][columnIndex] = true;
        queue.addLast(new int[]{rowIndex, columnIndex});

        while(!queue.isEmpty()) {
            int[] elementIndexes = queue.removeFirst();
            for(int[] direction: directions) {
                int rowValue = elementIndexes[0] + direction[0];
                int columnValue = elementIndexes[1] + direction[1];
                if(rowValue >= 0 && rowValue < grid.length && columnValue >= 0 && columnValue < grid[0].length && grid[rowValue][columnValue] == '1' && !nodesVisited[rowValue][columnValue]) {
                    queue.addLast(new int[]{rowValue, columnValue});
                    nodesVisited[rowValue][columnValue] = true;
                }
            }
        }
    }
}
