class Solution {
    public boolean isPalindrome(String s) {
        int startIndex = 0;
        int endIndex = s.length() - 1;
        while(startIndex < endIndex) {
            while(startIndex < endIndex && !isAlphanumeric(s.charAt(startIndex)))
                startIndex++;
            
            while(startIndex < endIndex && !isAlphanumeric(s.charAt(endIndex)))
                endIndex--;
            
            char startingIndexCharacter = s.charAt(startIndex);
            char endingIndexCharacter = s.charAt(endIndex);

            if(convertToLowerCase(startingIndexCharacter) != convertToLowerCase(endingIndexCharacter))
                return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }

    private boolean isAlphanumeric(char character) {
        return ((character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z') 
        || (character >= '0' && character <= '9'));
    }

    private char convertToLowerCase(char character) {
        int difference = 'a' - 'A';
        return (character >= 'A' && character <= 'Z') ? (char)(character + difference) : character;
    }
}
