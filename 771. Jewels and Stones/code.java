class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] book = new boolean[(int)'z'-(int)'A'+1];
        char[] Jarray = J.toCharArray();
        char[] Sarray = S.toCharArray();
        
        for(char j:Jarray){
            int position = (int)j - (int)'A';
            book[position] = true;
        }
    
        int count = 0;
        for(char s:Sarray){
            int position = (int)s - (int)'A';
            if(book[position]){
                count++;
            }
        }
        return count;
    }
}