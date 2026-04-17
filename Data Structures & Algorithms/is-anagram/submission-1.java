class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> countOfEachCharacterInString = new HashMap<>();
        for(int index = 0; index < s.length(); index ++) {
            if(countOfEachCharacterInString.containsKey(s.charAt(index)))
                countOfEachCharacterInString.put(s.charAt(index), 
                countOfEachCharacterInString.get(s.charAt(index)) + 1);
            else
                countOfEachCharacterInString.put(s.charAt(index), 1);
        }

        for(int index = 0; index < t.length(); index ++) {
            if(countOfEachCharacterInString.containsKey(t.charAt(index)) && countOfEachCharacterInString.get(t.charAt(index)) > 0)
                countOfEachCharacterInString.put(t.charAt(index), 
                countOfEachCharacterInString.get(t.charAt(index)) - 1);
            else
                return false;
        }
        return true;
    }
}
