class Solution {
    private int[][] turn = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private boolean[][] book;
    public boolean exist(char[][] board, String word) {
        //回溯
        //遍历数组, 如果找到起点, 开始search
        //避免走重复的路
        //把String转为char[], 效率更高
        book=new boolean[board.length][board[0].length];
        char[] array = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==array[0]){
                    book[i][j] = true;
                    if(search(1, i,j,array,board)){
                        return true;
                    }
                    book[i][j]=false;
                }
            }
        }
        return false;
    }
    //k: 正在匹配word的哪个字符
    public boolean search(int k, int x,int y,char[] array, char[][] board){
        if(k==array.length){
            return true;
        }
        //往四个方向走
        for(int t=0;t<4;t++){
            int newx = x + turn[t][0];
            int newy = y + turn[t][1];
            //判断是否出界
            if(newx>=0&&newx<board.length&&newy>=0&&newy<board[0].length){
                if(!book[newx][newy]&&board[newx][newy]==array[k]){
                    //System.out.println(newx+" "+newy);
                    book[newx][newy]=true;
                    if(search(k+1,newx,newy,array,board)){
                        return true;
                    }
                    book[newx][newy]=false;
                }
            }
        }
        return false;
    }
}