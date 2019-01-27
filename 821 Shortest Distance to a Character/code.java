class Solution {
    public int[] shortestToChar(String S, char C) {
        //暴力找
        int[] result = new int[S.length()];
        for(int i=0;i<S.length();i++){
            int dis1 = 10001, dis2 = 10001;
            for(int j=0;i-j>=0;j++){
                if(S.charAt(i-j) == C){
                    dis1 = j;
                    break;
                }
            }
            for(int j=0;i+j<S.length();j++){
                if(S.charAt(i+j) == C){
                    dis2 = j;
                    break;
                }
            }
            result[i] = Math.min(dis1, dis2);
        }
        return result;
    }
}