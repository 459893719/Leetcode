class Solution {
    public int minPathSum(int[][] grid) {
        //DP
        //dp[i][j] = A[i][j] + min(dp[i-1][j], dp[i][j-1])
        //注意边界数据
        int[][] dp = grid.clone();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i!=0||j!=0){
                    int up = (i==0)?Integer.MAX_VALUE:dp[i-1][j];
                    int left = (j==0)?Integer.MAX_VALUE:dp[i][j-1];
                    dp[i][j]+=Math.min(up,left);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}