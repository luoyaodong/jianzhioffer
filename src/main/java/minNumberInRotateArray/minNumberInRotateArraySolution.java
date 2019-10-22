package minNumberInRotateArray;

/**
 * Created by yaodongluo on 2018/7/9.
 */
public class minNumberInRotateArraySolution {
    public int minNumberInRotateArray(int[] array){
        int min = 0;
        if(array.length==0){
            return 0;
        }
        else {
            for(int i = 0;i<array.length-1;i++){
                if(array[i]>array[(i+1)%array.length]){
                    min = array[(i+1)%array.length];
                }
            }
        }
        return min;
    }
}
