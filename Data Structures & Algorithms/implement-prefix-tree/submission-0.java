class TrieNode {
    Map<Character, TrieNode> children;
    boolean isLast;

    public TrieNode() {
        children = new HashMap<>();
        isLast = false;
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(int index = 0; index < word.length(); index++) {
            if(!current.children.containsKey(word.charAt(index)))
                current.children.put(word.charAt(index), new TrieNode());
            current = current.children.get(word.charAt(index));
        }
        current.isLast = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int index = 0; index < word.length(); index++) {
            if(!current.children.containsKey(word.charAt(index)))
                return false;
            current = current.children.get(word.charAt(index));
        }
        return current.isLast;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int index = 0; index < prefix.length(); index++) {
            if(!current.children.containsKey(prefix.charAt(index)))
                return false;
            current = current.children.get(prefix.charAt(index));
        }
        return true;
    }
}
