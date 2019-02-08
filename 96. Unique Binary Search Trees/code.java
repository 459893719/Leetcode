class Solution {
    public int numTrees(int n) {
        //DP
        //G(n) = G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)
        //G(n)表示有n个点时BST的数目
        //右边分别为以某个点为根时的情况数
		
		//之前的公式是F(i,j)=F(i,i)*F(i+1,j)+...+F(i,k)*F(k+1,j)  k=i,i+1,...,j
        int[] G = new int[n+1];
        G[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                G[i]+=G[j]*G[i-1-j];
            }
        }
        return G[n];
    }
}