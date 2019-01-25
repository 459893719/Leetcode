class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] count = new int[2];
        for(int i=0;i<bills.length;i++){
            switch(bills[i]){
                case 5:{
                    count[0]++;
                    break;
                }
                case 10:{
                    if(count[0] == 0){
                        return false;
                    }
                    count[0]--;
                    count[1]++;
                    break;
                }
                case 20:{
                    if(count[1] > 0 && count[0] > 0){
                        count[1]--;
                        count[0]--;                    
                    }
                    else{
                        if(count[0] < 3){
                            return false;
                        }
                        else{
                            count[0] -= 3;
                        }
                    }
                    break;
                }
            }
        }
        return true;
    }
}