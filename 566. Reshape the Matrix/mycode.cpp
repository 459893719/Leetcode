class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
        int r0 = nums.size();
        int c0 = nums[0].size();
        //r0,c0表示原来矩阵的row column
        
        vector< vector<int> > newnums;
        
        if(r0*c0 != r*c){
            return nums;
        }
        
        int i=0;
        for(int j=0;j<r;j++){
            
            vector<int> row;
            
            for(int k=0;k<c;k++, i++){
                
                row.push_back(nums[i/c0][i%c0]);
                
            }
            
            newnums.push_back(row);
        }
        
        return newnums;
    }
};


/*

一定要注意边界情况, 即判断能不能进行reshape

还有通过一个数来寻址二维数组时是 i/c0 i%c0


*/