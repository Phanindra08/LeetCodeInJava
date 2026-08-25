class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int startPosition = 0;
        int lengthOfLongestSequence = 0;
        for(int endPosition = 0; endPosition < s.length(); endPosition++) {
            while(characterSet.contains(s.charAt(endPosition))) {
                characterSet.remove(s.charAt(startPosition));
                startPosition++;
            }
            characterSet.add(s.charAt(endPosition));
            lengthOfLongestSequence = (lengthOfLongestSequence > (endPosition - startPosition + 1))? lengthOfLongestSequence : (endPosition - startPosition + 1);
        }
        return lengthOfLongestSequence;
    }
}
