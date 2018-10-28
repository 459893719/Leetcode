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