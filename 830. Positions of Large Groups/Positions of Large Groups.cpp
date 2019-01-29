
/*

AC, 用时8ms


使用变量
i: 遍历string中的所有字母
lastletter: i对应字母前面的字母
result: 最后的结果

思路:


对每一个i指向的字母:
	如果与lastletter不一样: s[i]在新的group中
		判断result最后一个group大小是否小于3, 是的话, 说明这个group不符合要求, pop掉这个group
		在result中插入一个新group[i, i]
		更新lastletter
	如果与lastletter一样: s[i]在原来的group中
		更新group为[i', i]

		
		
遍历完之后要看一下result最后的group是否满足要求, 因为在之前的循环中没有进行检查

*/




class Solution {
public:
    vector<vector<int>> largeGroupPositions(string S) {
        vector< vector<int> > result;
        char lastletter = 'A';
        
        for(int i=0;i<S.length();i++){
            
            if(lastletter == S[i]){
                result[result.size() - 1][1] = i;
            }
            else{

                
                //判断长度是不是large
                if(result.size()){
                    vector<int> nowgroup = result[result.size()-1];
                    if(nowgroup[1] - nowgroup[0] < 2){
                        result.pop_back();
                    }
                }
                
                
                //加新的group
                vector<int> newgroup = {i, i};
                result.push_back(newgroup);
                
                //更新lastletter
                lastletter = S[i];
            }
            
            
        }
        
        //看最后一个group是否满足要求
        if(result.size()){
            vector<int> nowgroup = result[result.size()-1];
            if(nowgroup[1] - nowgroup[0] < 2){
                result.pop_back();
            }
        }
        
        return result;
    }
};