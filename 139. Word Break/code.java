class Solution {
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Character, List<String>> map = new HashMap<>();
        for(String string: wordDict){
            if(!map.containsKey(string.charAt(0))){
                map.put(string.charAt(0),new ArrayList<>());
            }
            map.get(string.charAt(0)).add(string);
        }
        //递归程序, 太慢
        char[] array = s.toCharArray();
        return wordBreak(s,0,wordDict,map);
    }
    public boolean wordBreak(String s, int begin, List<String> wordDict,
                            Map<Character, List<String>> map){
        //循环遍历dict, 如果有一个单词与s的最前面匹配, 对后面的串进行递归调用
        //使用HashMap加快找词速度
        if(begin==s.length()){
            return true;
        }
        List<String> list = map.get(s.charAt(begin));
        if(list!=null)
            for(String pattern:list){
                if(s.indexOf(pattern,begin)==begin && wordBreak(s,begin+pattern.length(),
                                                               wordDict,map)){
                    return true;
                }
            }
        return false;
    }
    */
    public boolean wordBreak(String s, List<String> wordDict){
        //优化为DP问题, 因为该问题用到了子问题的结果
        //dp[i]表示s[0...i]是否满足条件
        //如果存在j, dp[j]==true且s[j+1...i]能查到, dp[i]=true
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}