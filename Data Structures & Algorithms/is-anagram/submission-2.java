class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> characterMap = new HashMap<>();
        for(int index = 0; index < s.length(); index++) {
            // if(characterMap.containsKey(s.charAt(index)))
            //     characterMap.put(s.charAt(index), characterMap.get(s.charAt(index)) + 1);
            // else
            //     characterMap.put(s.charAt(index), characterMap.get(s.charAt(index)) + 1);

            characterMap.put(s.charAt(index), characterMap.getOrDefault(s.charAt(index), 0) + 1);
            characterMap.put(t.charAt(index), characterMap.getOrDefault(t.charAt(index), 0) - 1);
        }

        for(Map.Entry<Character, Integer> entry: characterMap.entrySet()) {
            if(entry.getValue() != 0)
                return false;
        }
        return true;
    }
}
