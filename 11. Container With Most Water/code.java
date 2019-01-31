class Solution {
    public int maxArea(int[] height) {
        //注意双指针的使用
        //从宽度最大的情况开始找, 因为我们默认宽度越大, 结果越大
        //每次循环中, 将高度较小的这一边移动一格, 因为移动较大的那一边不可能得到更好的结果
        int result = 0;
        int low = 0, high = height.length-1;
        while(low < high){
            int v = (high-low)*Math.min(height[high],height[low]);
            if(result < v){
                result = v;
            }
            if(height[high] > height[low]){
                low++;
            }
            else{
                high--;
            }
        }
        return result;
    }
}