class Solution {
    public int largestPerimeter(int[] A) {
        //思路: 首先对A序列进行排序
        //然后从最大的三个边开始往后找
        //如果满足, 就找到了
        //如果不满足条件, 指针继续往前走
        Arrays.sort(A);
        int a1 = A.length - 3;
        int a2 = A.length - 2;
        int a3 = A.length - 1;
        while(a1 >= 0){
            if(A[a1] + A[a2] > A[a3]){
                return A[a1] + A[a2] + A[a3];
            }
            else{
                a1--;a2--;a3--;
            }
        }
        return 0;
    }
}