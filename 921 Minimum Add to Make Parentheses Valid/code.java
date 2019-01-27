class Solution {
    public int minAddToMakeValid(String S) {
        //思路:
        //将匹配成功的括号去掉, 剩下的失配括号数就是结果
        //考虑使用栈
        
        //注意push语句中的参数尽量不直接写常量, 而是用数组元素来表示
        Stack<Character> s = new Stack<Character>();
        char[] array = S.toCharArray();
        for(int i=0;i<array.length;i++){
            if(array[i] == '('){
                s.push(array[i]);
            }
            else{
                if(s.size() > 0 && s.peek() == '('){
                    s.pop();
                }
                else{
                    s.push(array[i]);
                }
            }
        }
        return s.size();
    }
}