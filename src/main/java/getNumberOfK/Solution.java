package getNumberOfK;

/**
 * Created by yaodongluo on 2018/9/18.
 */
public class Solution {
    public int GetNumberOfK(int[] array,int k){
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum += zhidao(array[i],k);
        }
        return sum;
    }

    static int zhidao (int i,int k){
        int j = 0;
        while(i != 0){
            if(k==i %10){
                j++;
            }
            i = i /10;
        }
        return j;
    }
}
