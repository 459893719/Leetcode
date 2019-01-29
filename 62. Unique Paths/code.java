class Solution {
    //算排列数 (m-1+n-1)! / (m-1)! * (n-1)!
    public int uniquePaths(int m, int n) {
        if(m>=n){
            long result = 1;
            for(int i=m+n-2;i>m-1;i--){
                result*=i;
            }
            long temp = 1;
            for(int i=2;i<n;i++){
                temp*=i;
            }
            return (int)(result/temp);
        }
        else{
            long result = 1;
            for(int i=m+n-2;i>n-1;i--){
                result*=i;
            }
            long temp = 1;
            for(int i=2;i<m;i++){
                temp*=i;
            }
            return (int)(result/temp);
        }
    }
    
}


/*
//TLE
class Solution {
    private int count = 0;
    public int uniquePaths(int m, int n) {
        countPath(1,1,m,n);
        return count;
    }
    public void countPath(int x, int y, int m, int n){
        if(x == m && y == n){
            count++;
            return;
        }
        if(x<m){
            countPath(x+1,y,m,n);
        }
        if(y<n){
            countPath(x,y+1,m,n);
        }
    }
}*/