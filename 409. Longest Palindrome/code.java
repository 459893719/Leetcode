class Solution {
	//没用哈希表, 速度比较慢
    public int longestPalindrome(String s) {
        //如果找到一个出现次数为奇数的字母, 就减一
        char[] chararray = s.toCharArray();
        Arrays.sort(chararray);
        System.out.println(chararray);
        boolean flag = false;
        int num = 0;
        int result = 0;
        char lastletter = chararray[0];
        for(int i=0;i<chararray.length;i++){
            if(chararray[i] == lastletter){
                num++;
            }
            else{
                System.out.println(num);
                //检查num
                result+=num;
                if(num%2==1){
                    if(flag){
                        result--;
                    }
                    else{
                        flag = true;
                    }
                }
                num=1;
                lastletter=chararray[i];
            }
        }
        result+=num;
        if(num%2==1&&flag){
            result--;
        }
        return result;
    }
}

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> hs = new HashSet<>();
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                res++;
            }
            else
                hs.add(s.charAt(i));
        }
        return hs.isEmpty()?res*2:res*2+1;
    }
}