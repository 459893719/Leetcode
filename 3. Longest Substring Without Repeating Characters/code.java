class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){return 0;}
        int maxlength = 1;
        int low=0,high=0;
        维护一个HashMap, key为字母, value为此时子串中该字母所在的位置
        每次high移动一位, 加入一个新字母到Map
        如果新字母已经出现过, 右移low, 过程中移除Map相关条目
        
        优化 如果新字母已经出现过, low直接移到最后, 不用移除条目
        char[] array = s.toCharArray();
        MapCharacter,Integer map = new HashMap();
        map.put(array[0],0);
        while(highs.length()-1){
            high++;
            if(map.containsKey(array[high])&&map.get(array[high])=low){
                low = map.get(array[high])+1;
            }
            map.put(array[high],high);
            if(high-low+1  maxlength){
                maxlength = high-low+1;
            }
        }
        return maxlength;
    }
}