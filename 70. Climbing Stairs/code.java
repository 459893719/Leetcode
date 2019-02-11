class Solution {
    public int climbStairs(int n) {
        //斐波那契数列
        //F(n)=F(n-1)+F(n-2)
        //F(0)=0 F(1)=1
        int[] f = new int[n+1];
        f[0]=1;f[1]=1;
        for(int i=2;i<=n;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f[n];
    }
}