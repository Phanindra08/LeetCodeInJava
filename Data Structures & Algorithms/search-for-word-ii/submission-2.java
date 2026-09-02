class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isWord = false;
    }

    public void addWord(String word) {
        TrieNode current = this;
        for(int index = 0; index < word.length(); index++) {
            if(!current.children.containsKey(word.charAt(index))) {
                current.children.put(word.charAt(index), new TrieNode());
            }
            current = current.children.get(word.charAt(index));
        }
        current.isWord = true;
    }
}

class Solution {
    private int rowLength;
    private int columnLength;
    private Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String word: words)
            root.addWord(word);

        rowLength = board.length;
        columnLength = board[0].length;
        for(int rowIndex = 0; rowIndex < rowLength; rowIndex++) {
            for(int columnIndex = 0; columnIndex < columnLength; columnIndex++) {
                dfs(rowIndex, columnIndex, board, new ArrayList<>(), root, new StringBuilder());
            }
        }
        return new ArrayList<>(result);
    }

    public void dfs(int rowIndex, int columnIndex, char[][] board, List<int[]> elementsVisited, TrieNode node, StringBuilder word) {
        if(rowIndex < 0 || columnIndex < 0 || rowIndex == rowLength || columnIndex == columnLength || board[rowIndex][columnIndex] == '#' || !node.children.containsKey(board[rowIndex][columnIndex]))
            return;

        node = node.children.get(board[rowIndex][columnIndex]);
        word.append(board[rowIndex][columnIndex]);
        if(node.isWord)
            result.add(word.toString());
        char temp = board[rowIndex][columnIndex];
        board[rowIndex][columnIndex] = '#';
        dfs(rowIndex + 1, columnIndex, board, elementsVisited, node, word);
        dfs(rowIndex - 1, columnIndex, board, elementsVisited, node, word);
        dfs(rowIndex, columnIndex + 1, board, elementsVisited, node, word);
        dfs(rowIndex, columnIndex - 1, board, elementsVisited, node, word);
        board[rowIndex][columnIndex] = temp;
        word.deleteCharAt(word.length() - 1);
    }

    public boolean isElementAlreadyVisited(int rowIndex, int columnIndex, List<int[]> elementsVisited) {
        for(int index = 0; index < elementsVisited.size(); index++) {
            if(elementsVisited.get(index)[0] == rowIndex && elementsVisited.get(index)[1] == columnIndex)
                return true;
        }
        return false;
    }
}
