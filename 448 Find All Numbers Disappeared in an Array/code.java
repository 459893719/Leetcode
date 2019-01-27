class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //思路: 遍历一遍数组, 如果遍历到了i, 就将input数组的第i个元素设置为负值
        //再遍历一次数组, 如果某个位置的元素值为正, 说明相应的数没出现过
        //通过这样就能记录哪个元素出现过了
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0){
                nums[val] = -nums[val];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}