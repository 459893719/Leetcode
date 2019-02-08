class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //用位串来表示这个子集中包含哪个元素
        //对于集合nums, 位串包括0~2^len-1
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<(1 << nums.length);i++){
            result.add(subset(nums,i));
        }
        return result;
    }
    public List<Integer> subset(int[] nums, int num){
        List<Integer> set = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int choice = num%2;
            if(choice==1){
                set.add(nums[i]);
            }
            num/=2;
        }
        return set;
    }
}