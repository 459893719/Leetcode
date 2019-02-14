class Solution {
    List<String> result = new LinkedList<String>();
    char[] temp;
    public List<String> letterCombinations(String digits) {
        //回溯法
        //注意常量字符数组的使用
        if(digits.length()==0)return result;
        char[][] numbermap = {{},{},{'a','b','c'},{'d','e','f'},
                              {'g','h','i'},{'j','k','l'},{'m','n','o'},
                              {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        temp = new char[digits.length()];
        char[] array = digits.toCharArray();
        backtrack(array,0,numbermap);
        return result;
    }
    public void backtrack(char[] digits, int now, char[][] numbermap){
        if(now == digits.length){
            result.add(new String(temp));
            return;
        }
        int charnum = numbermap[(int)digits[now]-(int)'0'].length;
        int keynum = (int)digits[now]-(int)'0';
        for(int i=0;i<charnum;i++){
            temp[now] = numbermap[keynum][i];
            backtrack(digits,now+1,numbermap);
        }
    }
}