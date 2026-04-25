class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder s1 = new StringBuilder();
        int length = s.length();
        int unicodeOfCharacter;
        for(int index = 0; index < length; index++) {
            unicodeOfCharacter = s.codePointAt(index);
            if((unicodeOfCharacter >= 65 && unicodeOfCharacter <= 90) || 
            (unicodeOfCharacter >= 97 && unicodeOfCharacter <= 122) || 
            (unicodeOfCharacter >= 47 && unicodeOfCharacter <= 56))
                s1.append(s.charAt(index));
        }

        length = s1.length();
        for(int index = 0; index < length; index++) {
            if(s1.charAt(index) != s1.charAt(length - index - 1))
                return false;
        }
        return true;
    }
}
