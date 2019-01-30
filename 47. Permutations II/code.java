class Solution {
    //相比没有重复数字的排列, 做了一下改动
    //首先要保证nums数组有序
    //每次向排列中加入一个数之前, 在原有的基础上还要与上一个放的数进行比较, 
    //保证每次加入的数值不一样
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    private boolean[] book;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        book = new boolean[nums.length];
        backtrack(nums,0);
        return result;
    }
    public void backtrack(int[] nums, int first){
        if(first == nums.length){
            List<Integer> newresult = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++){
                newresult.add(temp.get(i));
            }
            result.add(newresult);
        }else{
            int lastnum = 0;
            boolean flag = true;
            for(int i=0;i<nums.length;i++){
                if(!book[i] && (flag||lastnum!=nums[i])){
                    if(flag){flag = false;}
                    lastnum = nums[i];
                    book[i] = true;
                    temp.add(nums[i]);
                    backtrack(nums,first+1);
                    book[i] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}