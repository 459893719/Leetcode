class Solution {
    //思路: 直觉, 找规律, 具体看题解的动画
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<=(n-1)/2;i++){
            for(int j=0;j<=(n-1)/2-n%2;j++){
                int[] temp = new int[4];
                int row = i, col = j;
                for(int k=0;k<4;k++){
                    temp[(k+1)%4] = matrix[row][col];
                    int temp1 = row;
                    row = col;
                    col = n-1-temp1;
                }
                row = i; col = j;
                for(int k=0;k<4;k++){
                    matrix[row][col] = temp[k];
                    int temp1 = row;
                    row = col;
                    col = n-1-temp1;
                }
            }
        }
    }
}