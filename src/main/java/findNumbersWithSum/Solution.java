package findNumbersWithSum;

import java.util.ArrayList;

/**
 * Created by yaodongluo on 2019/8/2.
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        if(array.length==0){
            return list;
        }
        int min_i = array.length-1;
        int min_j = 0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(i==j){
                    continue;
                }
                if((array[i]+array[j])==sum){
                    if(i<j){
                        if(min_i>i){
                            min_i = i;
                            min_j = j;
                        }
                    }
                }
            }
        }
        if(array[min_i]+array[min_j]==sum){
            list.add(array[min_i]);
            list.add(array[min_j]);
        }
        return list;
    }
}
