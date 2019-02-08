class Solution {
    //注意HashMap的思想(key+value)
    //如果两个string属于同一类, 那么这两个string排序之后的结果应该相同
    //将排序后的串作为key
    
    //注意Map类各种方法的使用
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if(!map.containsKey(key))  map.put(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        //Map类可以返回所有value组成的集合(Collection)
        return new ArrayList(map.values());
    }
}