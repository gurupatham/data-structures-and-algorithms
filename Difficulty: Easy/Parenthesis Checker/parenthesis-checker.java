
class Solution {
    static boolean isBalanced(String s) {
        // code here
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)== '(' || s.charAt(i)== '{' || s.charAt(i)== '['){
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            if(stack.peek()!=map.get(s.charAt(i))){
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
