class Solution {
    public int maxSubArray(int[] nums) {
        //DP
        //dp[i]定义为以i为结尾的最优数组的和
        //max为dp数组的最大值
        //dp[i] = A[i] + ((dp[i-1]>0)?dp[i]:0)
        
        //要注意子问题的选择方法, 怎么选才能将子问题与原问题的解联系起来
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = nums[i] + ((dp[i-1] > 0) ? dp[i-1]:0);
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}