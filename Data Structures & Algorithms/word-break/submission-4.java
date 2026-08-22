class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isWordPossible = new boolean[s.length() + 1];
        for(int index = 0; index < isWordPossible.length; index++)
            isWordPossible[index] = false;
        isWordPossible[s.length()] = true;
        for(int index = s.length() - 1; index >= 0; index--) {
            for(String word: wordDict) {
                int size = index + word.length();
                if(size <= s.length() && s.substring(index, size).equals(word))
                    isWordPossible[index] = isWordPossible[size];
                if(isWordPossible[index])
                    break;
            }
        }
        return isWordPossible[0];
    }
}
