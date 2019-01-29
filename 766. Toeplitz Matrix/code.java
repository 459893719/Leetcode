class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m-1 && (i+j)<n-1;j++){
                if(matrix[j+1][i+j+1]!=matrix[j][j+i]){
                    return false;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n-1 && (i+j)<m-1;j++){
                if(matrix[j+1+i][j+1]!=matrix[j+i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}