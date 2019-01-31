class Solution {
    //回溯法, 参照枚举所有排列等问题
    private List<String> result = new LinkedList<>();
    private char[] temp;
    public List<String> generateParenthesis(int n) {
        temp = new char[n*2];
        backtrack(0,n,0);
        return result;
    }
    public void backtrack(int position, int left, int right){
        if(left == 0 && right == 0){
            result.add(new String(temp));
            
        }
        else{
            if(left!=0){
                temp[position] = '(';
                backtrack(position+1,left-1,right+1);
            }
            if(right!=0){
                temp[position] = ')';
                backtrack(position+1,left,right-1);
            }
        }
    }
}