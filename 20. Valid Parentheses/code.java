class Solution {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i=0;i<array.length;i++){
            if(array[i]==')'||array[i]==']'||array[i]=='}'){
                if(stack.empty()||stack.pop()!=map.get(array[i])){
                    return false;
                }
            }
            else{
                stack.push(array[i]);
            }
        }
        if(!stack.empty()){
            return false;
        }
        else{
            return true;
        }
    }
}