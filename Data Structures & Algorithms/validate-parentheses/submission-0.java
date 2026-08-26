class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put('}', '{');
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        for(int index = 0; index < s.length(); index++) {
            if(bracketsMap.containsKey(s.charAt(index))) {
                if(!stack.isEmpty() && bracketsMap.get(s.charAt(index)) == stack.peek())
                    stack.pop();
                else
                    return false;
            } else
                stack.push(s.charAt(index));
        }
        return stack.isEmpty();
    }
}
