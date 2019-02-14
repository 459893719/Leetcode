class Solution {
    public void nextPermutation(int[] nums) {
        //问题可以等价为:将排列数组转为int, 求某一个数的下一个比他大的数
        //思路:从后往前遍历, 找到第一个无序的位置i
        //然后再从后往前遍历, 找到第一个比nums[i]大的数nums[j], 将两数交换
        //然后将i之后的子数组反转
        //以3 5 4 2 1为例
        //i=0, j=2
        int i,j;
        for(i=nums.length-2;i>=0;i--){
            if(nums[i] < nums[i+1]) break;
        }
        if(i>=0){
            for(j=nums.length-1;j>=0;j--){
                if(nums[j] > nums[i]){
                    //交换两个值
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
        //将i之后的元素反转
        for(i++,j=nums.length-1;i<j;j--,i++){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}