class Solution {
    public String decodeString(String s) {
        //思路:
        //用两个栈, 一个存字符串重复次数, 另一个存对应的字符串
        //算法开始时, 遍历表达式
        //数字: 不断扫描, 获得重复的次数, 并入栈
        //字母: 加到res中
        //[: 说明后面要重复字符串. 如果res有东西, 将res入栈, 暂存起来.
        //]: 首先将栈顶暂存的字符串拿出来, 然后往后不断地接res, 最后的结果放回res中
        
        //之前的思路是用Character栈, 太慢, 用String封装起来会更快
        //注意StringBuider的使用
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                System.out.println(res);
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                System.out.println("    "+res);
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}