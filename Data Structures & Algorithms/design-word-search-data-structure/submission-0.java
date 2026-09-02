class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for(int index = 0; index < word.length(); index++) {
            if(!current.children.containsKey(word.charAt(index)))
                current.children.put(word.charAt(index), new TrieNode());
            current = current.children.get(word.charAt(index));
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0, root, word);
    }

    public boolean dfs(int startIndex, TrieNode current, String word) {
        for(int index = startIndex; index < word.length(); index++) {
            if(word.charAt(index) == '.') {
                for(TrieNode node: current.children.values()) {
                    if(dfs(index + 1, node, word))
                        return true;
                }
                return false;
            } else {
                if(!current.children.containsKey(word.charAt(index)))
                    return false;
                current = current.children.get(word.charAt(index));
            }
        }
        return current.isEndOfWord;
    }
}
