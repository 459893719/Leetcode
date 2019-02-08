class Solution {
    public String longestPalindrome(String s) {
        //DP
        //定义P(i,j): [i,j]字符串是否为回文串
        //状态转移方程: P(i,j) = P(i+1,j-1)&&s[i]==s[j]
        //边界状态: P(i,i) = true ;   P(i,i+1) = s[i]==s[i+1]
        
        //优化: 改为自底向上迭代, 注意遍历子串的顺序
        if(s.length()==0) return "";
        boolean[][] P = new boolean[s.length()][s.length()];
        int maxlength = 0;
        int beg=0,end=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if((i-j < 2 || P[j+1][i-1]) && (s.charAt(i)==s.charAt(j))){
                    P[j][i] = true;
                    if(i-j+1>maxlength){
                        maxlength = i-j+1;
                        beg = j;
                        end = i;
                    }
                }
                else{
                    P[j][i] = false;
                }
            }
        }
        return s.substring(beg,end+1);
    }
}