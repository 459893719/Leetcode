class Solution {
    public int majorityElement(int[] nums) {
        //哈希表, 每个key对应一个value, 表示这个key出现的次数
        //在遍历数组的过程中, 如果发现一个数的出现次数已经超过[n/2], 就返回这个值
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(!map.containsKey(i)){map.put(i,0);}
            Integer num = map.get(i) + 1;
            map.put(i, num);
            if(map.get(i) > nums.length/2){
                return i;
            }
        }
        return 0;
    }
}