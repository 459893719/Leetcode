class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }

        return ans;
    }
}


/*

其他人的思路:  两个指针

i指向current group的start
j遍历整个string, 直到到达最后

如果j到了最后或者[j] != [j+1], 就说明到了这个group的结尾了
看[i,j]是否是large, 是的话插到result中


*/
