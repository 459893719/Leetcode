class Solution {
    private boolean[] book;
    private List<List<Integer> > result = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        book = new boolean[nums.length];
        permute1(nums,0);
        return result;
    }
    
    public void permute1(int[] nums, int totalnum){
        if(totalnum == nums.length){
            //此时temp表示一种排列, 将temp加到result中
            List<Integer> newpermutation = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                newpermutation.add(temp.get(i));
            }
            result.add(newpermutation);
        }
        else{
            //找一个还没有出现在排列中的数, 递归调用函数
            for(int i=0;i<book.length;i++){
                if(!book[i]){
                    book[i] = true;
                    temp.add(nums[i]);
                    permute1(nums,totalnum+1);
                    book[i] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}