package findNumsAppearOnce;

import java.util.HashMap;

/**
 * Created by yaodongluo on 2019/6/28.
 */
//所有数字做亦或操作
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int m = 0;
        for(int i = 0;i<array.length;i++){

            int count =0;
            for(int j =0;j<array.length;j++){
                if(array[i] == array[j]){
                    count++;
                }
            }
            if(count==1 && m==0){
                m++;
                num1[0] = array[i];
            }
            if(count==1 && m==1){
                num2[0] = array[i];
            }
        }
    }
}
