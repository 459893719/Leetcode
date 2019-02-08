class Solution {
    public boolean canJump(int[] nums) {
        //DP
        //dp[i]表示从起点能不能到达位置i
        //dp[i] = dp[j]&& j+max[j]>=i    j=0,1,...,i-1
        //边界: dp[0] = true
        //自底向上
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i=1;i<nums.length;i++){
            //boolean flag = false;
            for(int j=0;j<i;j++){
                if(dp[j]&&j+nums[j]>=i){
                    dp[i] = true;
                    break;
                }
            }
            
        }
        return dp[nums.length-1];
    }
}