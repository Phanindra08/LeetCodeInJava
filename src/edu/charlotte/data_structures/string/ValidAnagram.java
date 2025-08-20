package edu.charlotte.data_structures.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnagram {
    public boolean isAnagramSolution1(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] characterCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            characterCount[s.charAt(i) - 'a']++;
            characterCount[t.charAt(i) - 'a']--;
        }

        for (int count : characterCount) {
            if (count != 0)
                return false;
        }
        return true;
    }

    public boolean isAnagramSolution2(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> characterMap = new HashMap<>();
        char letter;
        for(int index = 0; index < s.length(); index++) {
            letter = s.charAt(index);
            if(characterMap.containsKey(letter))
                characterMap.put(letter, characterMap.get(letter) + 1);
            else
                characterMap.put(letter, 1);
        }

        for(int index = 0; index < t.length(); index++) {
            letter = t.charAt(index);
            if(characterMap.containsKey(letter) && characterMap.get(letter) > 0)
                characterMap.put(letter, characterMap.get(letter) - 1);
            else
                return false;
        }

        return true;
    }

    public boolean isAnagramSolution3(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> characterMapForStringS = new HashMap<>();
        Map<Character, Integer> characterMapForStringT = new HashMap<>();
        for(int index = 0; index < s.length(); index++) {
            if(characterMapForStringS.containsKey(s.charAt(index)))
                characterMapForStringS.put(s.charAt(index), characterMapForStringS.get(s.charAt(index)) + 1);
            else
                characterMapForStringS.put(s.charAt(index), 1);

            if(characterMapForStringT.containsKey(t.charAt(index)))
                characterMapForStringT.put(t.charAt(index), characterMapForStringT.get(t.charAt(index)) + 1);
            else
                characterMapForStringT.put(t.charAt(index), 1);
        }

        for(Map.Entry<Character, Integer> mapEntryForStringS : characterMapForStringS.entrySet()) {
            Character key = mapEntryForStringS.getKey();
            if(!Objects.equals(mapEntryForStringS.getValue(), characterMapForStringT.get(key)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagramSolution1("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagramSolution2("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagramSolution3("rat", "car"));
    }
}
