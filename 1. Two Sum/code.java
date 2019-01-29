class Solution {
    public int[] twoSum(int[] nums, int target) {
        //暴力算法 O(n^2)
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    int[] result = {i,j};
                    return result;
                }
            }
        }
        return null;
    }
}